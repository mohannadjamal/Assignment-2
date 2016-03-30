/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.birzeit.cs.parsers;

import java.util.ArrayList;

/**
 *
 * @author mohannad
 */
public class User {

    private String name;
    private Location location;
    private int id;
    private String address;
    private ArrayList<Integer> friendList;

    public String getAddress() {
        return address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Integer> getFriendList() {
        return friendList;
    }

    public void setFriendList(ArrayList<Integer> friendList) {
        this.friendList = friendList;
    }
    @Override
    public String toString(){
        return "\nId: "+ getId()+ " Name: "+getName() +" Location " + getLocation() +" Address "+ getAddress();
    }

    public User(int id,String name, String address, Location location, ArrayList<Integer> friendList) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.location = location;
        this.friendList = friendList;
    }

}
