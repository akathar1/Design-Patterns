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
public class CarbonFootPrint implements CarbonFootPrintInterface {

    private double value;
    private String name;

    
    /**
     * stores the value of carbon footprint and unit
     * @param valueIn
     * @param nameIn 
     */
    public CarbonFootPrint(double valueIn, String nameIn) {
        value = valueIn;
        name = nameIn;

        Logger.writeMessage(" Carbon FootPrint constructor called...", Logger.DebugLevel.CONSTRUCTOR);
    }

    
    /**
     * 
     * @return double that contains the value for the carbon footprint
     */
    @Override
    public double getValue() {
        return value;
    }

    
    /**
     * setting value 
     * @param value 
     */
    @Override
    public void setValue(double value) {
        this.value = value;
    }

    
    /**
     * 
     * @return string that holds the unit of carbon footprint
     */
    @Override
    public String getName() {
        return name;
    }

    
    /**
     * 
     * @param name 
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }

}
