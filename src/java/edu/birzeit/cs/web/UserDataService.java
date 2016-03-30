/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.birzeit.cs.web;

import edu.birzeit.cs.parsers.Location;
import edu.birzeit.cs.parsers.User;
import edu.birzeit.cs.parsers.UserParser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import org.json.JSONException;

/**
 *
 * @author root
 */
@WebService(serviceName = "UserDataService")
public class UserDataService {

    private UserParser parser = new UserParser("/home/mohannad/NetBeansProjects/Assignment 2/src/java/edu/birzeit/cs/parsers/user.json");

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getUserLocation")
    public String getUserLocation(@WebParam(name = "id") int id) throws JSONException, IOException {
        for (int i = 0; i < parser.parse().size(); i++) {
            if (parser.parse().get(i).getId() == id) {
                return parser.parse().get(i).getLocation().toString();
            }
        }
        return "User not found";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getFriendList")
    public String getFriendList(@WebParam(name = "id") int id) throws JSONException, IOException {
        StringBuffer out = new StringBuffer("Friend List: ");
        for (int i = 0; i < parser.parse().size(); i++) {
            if (parser.parse().get(i).getId() == id) {
                for (int j = 0; j < parser.parse().get(i).getFriendList().size(); j++) {
                    int checkId =parser.parse().get(i).getFriendList().get(j);
                    for (int k = 0;k< parser.parse().size(); k++) {
                        if(checkId == parser.parse().get(k).getId());
                        out.append(" \n"+ parser.parse().get(k).getName() );
                    }
                }
            }
        }
        return out.toString();
    }

}
