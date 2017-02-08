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

/**
 *
 * @author abhi2
 */
public interface OrientationResultsInterface {

    public BuyingBooksInterface getBuyingBooks();

    public void setBuyingBooks(BuyingBooksInterface buyingBooks);

    public CampusTourInterface getCampusTour();

    public void setCampusTour(CampusTourInterface campusTour);

    public CourseRegisterationInterface getCourseRegistration();

    public void setCourseRegistration(CourseRegisterationInterface courseRegistration);

    public SelectingDormInterface getSelectDorm();

    public void setSelectDorm(SelectingDormInterface selectDorm);

    public void display();
}
