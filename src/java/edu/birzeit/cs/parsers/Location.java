/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.birzeit.cs.parsers;

/**
 *
 * @author root
 */
public class Location {
    private double xCoor;
    private double yCoor;
    
    public Location(double xCoor,double yCoor){
        this.xCoor = xCoor;
        this.yCoor = yCoor;
    }


    public double getyCoor() {
        return yCoor;
    }

    public double getxCoor() {
        return xCoor;
    }
    public String toString(){
        return xCoor +"," + yCoor;
    }
}
