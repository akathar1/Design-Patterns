/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.events;

import studentorientation.factors.CurrencyInterface;
import studentorientation.factors.CarbonFootPrintInterface;
import studentorientation.factors.EffortsInterface;
import studentorientation.factors.TimeInterface;
import studentorientation.util.Logger;

/**
 *
 * @author abhi2
 */
public class DormGamingContest implements SelectingDormInterface {

    private double duration = 0;
    private double effort = 0;
    private double cost = 0;
    private double surCharge = 0;
    private double footPrint = 0;
    private String costName = null;
    private String effortName = null;
    private String footPrintName = null;
    private String timeName = null;

    /**
     * set the cost in the constructor according to the surcharge given and
     * getting the values of time, footprint, effort to store them
     *
     * @param costIn
     * @param effortsIn
     * @param footPrintIn
     * @param durationIn
     */
    public DormGamingContest(CurrencyInterface costIn, EffortsInterface effortsIn, CarbonFootPrintInterface footPrintIn, TimeInterface durationIn) {
        surCharge = 0.02;
        cost = costIn.getValue() + (costIn.getValue() * surCharge);
        duration = durationIn.getValue();
        effort = effortsIn.getValue();
        footPrint = footPrintIn.getValue();
        costName = costIn.getName();
        effortName = effortsIn.getName();
        footPrintName = footPrintIn.getName();
        timeName = durationIn.getName();

        Logger.writeMessage("DormGamingContest constructor called...", Logger.DebugLevel.CONSTRUCTOR);
    }

    @Override
    public String toString() {
        return "DormGamingContest{" + "duration=" + duration + ", effort=" + effort + ", cost=" + cost + ", surCharge=" + surCharge + ", footPrint=" + footPrint + ", costName=" + costName + ", effortName=" + effortName + ", footPrintName=" + footPrintName + ", timeName=" + timeName + '}';
    }

    /**
     * setting the time
     * @param time
     */
    @Override
    public void setTime(int time) {
        duration = time;
    }

    /**
     *
     * @return double which holds the value for duration
     */
    @Override
    public double getTime() {
        return duration;

    }

    /**
     * setting the effort
     * @param effortIn 
     */
    @Override
    public void setEffort(double effortIn) {
        effort = effortIn;
    }

    /**
     * 
     * @return double which holds the value for effort
     */
    @Override
    public double getEffort() {
        return effort;
    }

    /**
     * 
     * @return double which holds the value for cost
     */
    @Override
    public double getCost() {
        return cost;

    }

    
    /**
     * 
     * @return double which holds the value for footprint
     */
    @Override
    public double getFootPrint() {
        return footPrint;
    }

    
    /**
     * 
     * @return String which holds the value for currency
     */
    @Override
    public String getCostName() {
        return costName;

    }

    
    /**
     * 
     * @return String which holds the value for effort unit
     */
    @Override
    public String getEffortName() {
        return effortName;

    }

    
    /**
     * 
     * @return String which holds the value for time unit
     */
    @Override
    public String getTimeName() {
        return timeName;

    }

    
    /**
     * 
     * @return String which holds the value for footprint unit
     */
    @Override
    public String getFootprintName() {
        return footPrintName;

    }

}
