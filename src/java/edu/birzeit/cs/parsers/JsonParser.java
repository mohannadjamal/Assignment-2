package edu.birzeit.cs.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.JSONArray;
//import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class JsonParser {

    private static JSONTokener jsonOut;

    public static void main(String myHelpers[]) throws JSONException, IOException {
                       
                File f = new File("/home/mohannad/NetBeansProjects/Assignment 2/src/java/edu/birzeit/cs/parsers/user.json");

                  
                    String jsonString = readFile(f.getPath());
                                
                    jsonOut = new JSONTokener(jsonString);
                    JSONObject output = new JSONObject(jsonOut);
                    JSONArray arr = new JSONArray();
                    System.out.println(output.has("root"));
                    
                         
            
        
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