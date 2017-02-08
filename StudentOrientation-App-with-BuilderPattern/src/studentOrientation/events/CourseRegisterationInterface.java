/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.events;

/**
 *
 * @author abhi2
 */
public interface CourseRegisterationInterface {

    public void setTime(int time);

    public double getTime();

    public void setEffort(double effort);

    public double getEffort();

    public double getCost();
    
    public double getFootPrint();
    
      public String getCostName();
    
    public String getEffortName();
    
    public String getFootprintName();
    
    public String getTimeName();
}
