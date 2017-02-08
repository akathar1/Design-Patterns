/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.store;

import studentorientation.events.BuyingBooksInterface;
import studentorientation.events.CampusTourInterface;
import studentorientation.events.CourseRegisterationInterface;
import studentorientation.events.SelectingDormInterface;
import studentorientation.util.Logger;

/**
 *
 * @author abhi2
 */
public class OrientationResults implements OrientationResultsInterface {

    private BuyingBooksInterface buyingBooks = null;
    private CampusTourInterface campusTour = null;
    private CourseRegisterationInterface courseRegistration = null;
    private SelectingDormInterface selectDorm = null;
    private OrientationResultsInterface results = null;

    /**
     * storing the final results of all activities
     *
     * @param resultsIn
     */
    public OrientationResults(OrientationResultsInterface resultsIn) {
        results = resultsIn;

        Logger.writeMessage("OrientationResults constructor called...", Logger.DebugLevel.CONSTRUCTOR);
    }

    public OrientationResults() {

    }

    /**
     *
     * @return BuyingBooksInterface object which holds the value for
     * time,cost,effort required for buying book activity
     */
    @Override
    public BuyingBooksInterface getBuyingBooks() {
        return buyingBooks;
    }

    /**
     *
     * @param buyingBooks
     */
    @Override
    public void setBuyingBooks(BuyingBooksInterface buyingBooks) {
        this.buyingBooks = buyingBooks;
    }

    /**
     *
     * @return CampusTourInterface object which holds the value for
     * time,cost,effort required for CampusTour activity
     */
    @Override
    public CampusTourInterface getCampusTour() {
        return campusTour;
    }

    /**
     *
     * @param campusTour
     */
    @Override
    public void setCampusTour(CampusTourInterface campusTour) {
        this.campusTour = campusTour;
    }

    /**
     *
     * @return CourseRegisterationInterface object which holds the value for
     * time,cost,effort required for CourseRegisteration activity
     */
    @Override
    public CourseRegisterationInterface getCourseRegistration() {
        return courseRegistration;
    }

    /**
     *
     * @param courseRegistration
     */
    @Override
    public void setCourseRegistration(CourseRegisterationInterface courseRegistration) {
        this.courseRegistration = courseRegistration;
    }

    /**
     *
     * @return SelectingDormInterface object which holds the value for time,
     * cost , effort required for dorm selection activity
     */
    @Override
    public SelectingDormInterface getSelectDorm() {
        return selectDorm;
    }

    /**
     *
     * @param selectDorm
     */
    @Override
    public void setSelectDorm(SelectingDormInterface selectDorm) {
        this.selectDorm = selectDorm;
    }

    /**
     * display method that displays all the results on screen
     */
    @Override
    public void display() {
        
        if(Logger.getDebugLevel()==null){
            Logger.setDebugValue(2);
        }
        Logger.writeMessage("In OrientationResults.Display  method...\n ", Logger.DebugLevel.RESULTDISPLAY);

        Logger.writeMessage("CampusTour", Logger.DebugLevel.RESULTDISPLAY);
        Logger.writeMessage("Cost : " + results.getCampusTour().getCost() + " " + results.getCampusTour().getCostName() + "   Effort : " + results.getCampusTour().getEffort()
                + " " + results.getCampusTour().getEffortName() + "   FootPrint : " + results.getCampusTour().getFootPrint() + " " + results.getCampusTour().getFootprintName() + "   Time : " + results.getCampusTour().getTime() + " " + results.getCampusTour().getTimeName(), Logger.DebugLevel.RESULTDISPLAY);

        Logger.writeMessage("\nBookStore", Logger.DebugLevel.RESULTDISPLAY);
        Logger.writeMessage("Cost : " + results.getBuyingBooks().getCost() + " " + results.getBuyingBooks().getCostName() + "   Effort : " + results.getBuyingBooks().getEffort() + " " + results.getBuyingBooks().getEffortName()
                + "   FootPrint : " + results.getBuyingBooks().getFootPrint() + " " + results.getBuyingBooks().getFootprintName() + "   Time : " + results.getBuyingBooks().getTime() + " " + results.getBuyingBooks().getTimeName(), Logger.DebugLevel.RESULTDISPLAY);
        Logger.writeMessage("\nDorms ", Logger.DebugLevel.RESULTDISPLAY);
        Logger.writeMessage("Cost : " + results.getSelectDorm().getCost() + " " + results.getSelectDorm().getCostName() + "   Effort : " + results.getSelectDorm().getEffort() + " " + results.getSelectDorm().getEffortName()
                + "   FootPrint : " + results.getSelectDorm().getFootPrint() + " " + results.getSelectDorm().getFootprintName() + "   Time : " + results.getSelectDorm().getTime() + " " + results.getSelectDorm().getTimeName(), Logger.DebugLevel.RESULTDISPLAY);
        Logger.writeMessage("\nCourse Registration ", Logger.DebugLevel.RESULTDISPLAY);
        Logger.writeMessage("Cost : " + results.getCourseRegistration().getCost() + " " + results.getCourseRegistration().getCostName() + "   Effort : " + results.getCourseRegistration().getEffort() + " " + results.getCourseRegistration().getEffortName()
                + "   FootPrint : " + results.getCourseRegistration().getFootPrint() + " " + results.getCourseRegistration().getFootprintName() + "   Time : " + results.getCourseRegistration().getTime() + " " + results.getCourseRegistration().getTimeName(), Logger.DebugLevel.RESULTDISPLAY);
        double totalCost = results.getCampusTour().getCost() + results.getBuyingBooks().getCost() + results.getSelectDorm().getCost() + results.getCourseRegistration().getCost();
        Logger.writeMessage("\nTotal Cost: " + totalCost + " " + results.getCampusTour().getCostName(), Logger.DebugLevel.RESULTDISPLAY);

        double totalEffort = results.getCampusTour().getEffort() + results.getBuyingBooks().getEffort() + results.getSelectDorm().getEffort() + results.getCourseRegistration().getEffort();
        Logger.writeMessage("\nTotal Effort: " + totalEffort + " " + results.getCampusTour().getEffortName(), Logger.DebugLevel.RESULTDISPLAY);

        double totalFootPrint = results.getCampusTour().getFootPrint() + results.getBuyingBooks().getFootPrint() + results.getSelectDorm().getFootPrint() + results.getCourseRegistration().getFootPrint();
        Logger.writeMessage("\nTotal Carbon FootPrint: " + totalFootPrint + " " + results.getCampusTour().getFootprintName(), Logger.DebugLevel.RESULTDISPLAY);

        double totalTime = results.getCampusTour().getTime() + results.getBuyingBooks().getTime() + results.getSelectDorm().getTime() + results.getCourseRegistration().getTime();
        Logger.writeMessage("\nTotal Time: " + totalTime + " " + results.getCampusTour().getTimeName(), Logger.DebugLevel.RESULTDISPLAY);

    }

}
