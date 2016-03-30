/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.birzeit.cs.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class UserParser {

    private String filePath;
    private JSONTokener jsonOut;
    
    public UserParser(String path){
        filePath = path;
    }
    public ArrayList<User> parse () throws JSONException, IOException {

        File f = new File(filePath);
        String jsonString = readFile(f.getPath());

        ArrayList<User> arrUsers = new ArrayList<User>();

        jsonOut = new JSONTokener(jsonString);
        JSONObject output = new JSONObject(jsonOut);
        JSONArray users = output.getJSONArray("users");
        for (int i = 0; i < users.length(); i++) {
            int id = Integer.parseInt(((JSONObject) users.get(i)).getString("id"));
            String[] unparsedLoc =((JSONObject) users.get(i)).getString("loc").split(",");
            Location loc = new Location(Double.parseDouble(unparsedLoc[0]),Double.parseDouble(unparsedLoc[1]));
            String name = ((JSONObject) users.get(i)).getString("name"),
                    address = ((JSONObject) users.get(i)).getString("address");

            JSONArray friends = ((JSONObject) users.get(i)).getJSONArray("friends");
            ArrayList<Integer> friendIds = new ArrayList<Integer>();
            for (int j = 0; j < friends.length(); j++) {
                int friendId = Integer.parseInt(((JSONObject) friends.get(j)).getString("id"));
                friendIds.add(friendId);
            }
            arrUsers.add(new User(id, name, address, loc, friendIds));
        }
        for (int i = 0; i < arrUsers.size(); i++) {
            System.out.println(arrUsers.get(i) + "\nFriend List:");
            for (int j = 0; j < arrUsers.get(i).getFriendList().size(); j++) {
                int friendIdCheck = arrUsers.get(i).getFriendList().get(j);
                for (int k = 0; k < arrUsers.size(); k++) {
                    if (friendIdCheck == arrUsers.get(k).getId()) {
                        System.out.println(arrUsers.get(k).getName());
                    }
                }
            }

        }
        return arrUsers;
    }

    private static String readFile(String file) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");

        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
            stringBuilder.append(ls);
        }

        return stringBuilder.toString();
    }
}
