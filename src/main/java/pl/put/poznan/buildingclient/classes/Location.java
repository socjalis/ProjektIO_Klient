/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.put.poznan.buildingclient.classes;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author wisni
 */
public class Location {

    static final AtomicInteger counter = new AtomicInteger();
    private int id;
    private String name;

    //konstruktory
    /**
     * Konstruktor
     *
     * @param nazwa Pierwszy parametr konstruktora - nazwa danej lokacji
     */
    public Location(String nazwa) {
        this.id = counter.getAndIncrement();
        this.name = nazwa;
    }

    /**
     * Konstruktor bezparametrowy
     *
     */
    public Location() {
    }

    //gettery
    /**
     * Getter Id
     *
     * @return zwraca int id lokacji
     */
    public int getId() {
        return id;
    }

    /**
     * Getter Name
     *
     * @return zwraca string name danej lokacji
     */
    public String getName() {
        return name;
    }

    @Override
    public String toString()  {
        return name;
    }
}
