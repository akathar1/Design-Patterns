/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.factors;

import studentorientation.util.Logger;

/**
 *
 * @author abhi2
 */
public class Efforts implements EffortsInterface{
    private double value;
    private String name;

    
    /**
     * stores the value and unit for efforts 
     * @param valueIn
     * @param nameIn 
     */
    public Efforts(double valueIn, String nameIn) {
        value = valueIn;
        name = nameIn;

        Logger.writeMessage("Efforts constructor called...", Logger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * 
     * @return double that holds the value for efforts 
     */
    @Override
    public double getValue() {
        return value;
    }

    
    /**
     * setting the value for effort
     * @param value 
     */
    @Override
    public void setValue(double value) {
        this.value = value;
    }

    
    /**
     * 
     * @return string that holds the name for unit of effort
     */
    @Override
    public String getName() {
        return name;
    }

    
    /**
     * setting the unit
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

}
