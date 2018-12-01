/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.put.poznan.buildingclient.classes;

import java.util.ArrayList;

/**
 *
 * @author wisni
 */
public class Floor extends Location{
    ArrayList<Room> rooms = new ArrayList();
    
    //konstruktory
    public Floor(String nazwa) {
        super(nazwa);
    }
    public Floor() {}

    public ArrayList<Room> getRooms() {
        return rooms;
    }
}
