/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.put.poznan.buildingclient.classes;

import java.util.ArrayList;

/**
 * <h1>Klasa Budynek</h1>
 *
 * @author Amarantowy
 * @version 1.0
 */
public class Building extends Location {

    ArrayList<Floor> poziomy = new ArrayList();

    //konstruktory
    /**
     * Konstruktor
     *
     * @param nazwa Pierwszy parametr konstruktora
     */
    public Building(String nazwa) {
        super(nazwa);
    }

    /**
     * Konstruktor bezparametrowy
     *
     */
    public Building() {
    }

    /**
     * Getter Piziomy
     *
     * @return zwraca ArrayList poziomy - poziomy danego budynku
     */
    public ArrayList<Floor> getPoziomy() {
        return poziomy;
    }
}
