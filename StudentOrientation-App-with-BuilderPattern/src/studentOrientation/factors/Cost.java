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
public class Cost implements CurrencyInterface {

    private double value;
    private String name;

    
    /**
     * stores the value and currency for amount
     * @param valueIn
     * @param nameIn 
     */
    public Cost(double valueIn, String nameIn) {
        value = valueIn;
        name = nameIn;
        Logger.writeMessage(" Cost constructor called...", Logger.DebugLevel.CONSTRUCTOR);
    }

    
    /**
     * 
     * @return double that holds the value for cost
     */
    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void setValue(double value) {
        this.value = value;
    }

    
    /**
     * 
     * @return String that holds the currency
     */
    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

}
