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
public class Duration implements TimeInterface {

    private double value;
    private String name;

    
    /**
     * stores the value for duration and (minutes/seconds/hours)
     * @param valueIn
     * @param nameIn 
     */
    public Duration(double valueIn, String nameIn) {
        value = valueIn;
        name = nameIn;

        Logger.writeMessage("Duration constructor called...", Logger.DebugLevel.CONSTRUCTOR);
    }

    
    /**
     * 
     * @return double that holds the value for duration
     */
    @Override
    public double getValue() {
        return value;
    }

    
    /**
     * setting the value for duration
     * @param value 
     */
    @Override
    public void setValue(double value) {
        this.value = value;
    }

    
    /**
     * 
     * @return string that holds (minutes/seconds/hours)
     */
    @Override
    public String getName() {
        return name;
    }

    
    /**
     *  setting value for (minutes/seconds/hours)
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

}
