/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.put.poznan.buildingclient.classes;

/**
 * <h1>Klasa Pokoj</h1>
 *
 * @author Amarantowy
 * @version 1.0
 */
public class Room extends Location {

    Double area;
    Double cube;
    Double heating;
    Double light;

    //kosntruktory
    /**
     * Konstruktor
     *
     * @param nazwa Pierwszy parametr konstruktora - nazwa danej lokalizacji
     */
    public Room(String nazwa) {
        super(nazwa);
    }

    /**
     * Konstruktor bezparametrowy
     *
     */
    public Room() {
    }

    /**
     * Getter Area
     *
     * @return zwraca double area
     */
    public Double getArea() {
        return area;
    }

    /**
     * Getter Cube
     *
     * @return zwraca double cube
     */
    public Double getCube() {
        return cube;
    }

    /**
     * Getter Heating
     *
     * @return zwraca double heating
     */
    public Double getHeating() {
        return heating;
    }

    /**
     * Getter Light
     *
     * @return zwraca double light
     */
    public Double getLight() {
        return light;
    }

}
