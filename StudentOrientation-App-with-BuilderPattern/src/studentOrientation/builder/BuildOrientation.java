 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.builder;

import studentorientation.constants.BookStoreChoice.BookstoreE;
import studentorientation.constants.CampusTourChoice.CampusTourE;
import studentorientation.constants.DormsChoice.DormsE;
import studentorientation.constants.RegistrationChoice.RegistrationE;
import studentorientation.factors.Cost;
import studentorientation.events.DormGamingContest;
import studentorientation.events.DormInLine;
import studentorientation.events.MandoBookStore;
import studentorientation.events.RegisterInLabOnline;
import studentorientation.events.RegisterInOffice;
import studentorientation.events.TourByBus;
import studentorientation.events.TourOnFoot;
import studentorientation.events.UniversityBookStore;
import studentorientation.events.BuyingBooksInterface;
import studentorientation.events.CampusTourInterface;
import studentorientation.events.CourseRegisterationInterface;
import studentorientation.factors.CurrencyInterface;
import studentorientation.events.SelectingDormInterface;
import studentorientation.factors.CarbonFootPrint;
import studentorientation.factors.CarbonFootPrintInterface;
import studentorientation.factors.Duration;
import studentorientation.factors.Efforts;
import studentorientation.factors.EffortsInterface;
import studentorientation.factors.TimeInterface;
import studentorientation.store.OrientationResults;
import studentorientation.store.OrientationResultsInterface;
import studentorientation.util.Logger;

/**
 *
 * @author abhi2
 */
public class BuildOrientation implements BuildOrientationInterface {

    private final BookstoreE bookStoreChoice;
    private final CampusTourE tourChoice;
    private final DormsE dormsChoice;
    private final RegistrationE registrationChoice;
    private CurrencyInterface cost;
    private EffortsInterface efforts;
    private CarbonFootPrintInterface footPrint;
    private TimeInterface duration;
    String dollars = "Dollars";
    private CampusTourInterface cti = null;
    private BuyingBooksInterface bbi = null;
    private SelectingDormInterface sdi = null;
    private CourseRegisterationInterface cri = null;
    private OrientationResultsInterface results = null;

    
    /**
     * Constructor for taking the choice for all the activities required for starting the class
     * @param bookstoreEIn
     * @param campusTourEIn
     * @param dormsEIn
     * @param registrationEIn 
     */
    public BuildOrientation(BookstoreE bookstoreEIn, CampusTourE campusTourEIn, DormsE dormsEIn, RegistrationE registrationEIn) {
        bookStoreChoice = bookstoreEIn;
        tourChoice = campusTourEIn;
        dormsChoice = dormsEIn;
        registrationChoice = registrationEIn;
        results = new OrientationResults();

        Logger.writeMessage(" Build Orientation constructor called...", Logger.DebugLevel.CONSTRUCTOR);
    }

    
    /**
     * sets the cost, effort, carbon footprint and duration for selected sub-activity for campus tour
     */
    @Override
    public void campusTour() {

        if (tourChoice.equals(CampusTourE.BYBUS)) {
            cost = new Cost(2.00, dollars);
            efforts = new Efforts(100.00, "Calories");
            footPrint = new CarbonFootPrint(0.8, "tons Co2");
            duration = new Duration(60, "Minutes");
            cti = new TourByBus(cost, efforts, footPrint, duration);
        } else {
            cost = new Cost(0.10, dollars);
            efforts = new Efforts(300.00, "Calories");
            footPrint = new CarbonFootPrint(2.0, "tons Co2");
            duration = new Duration(150, "Minutes");
            cti = new TourOnFoot(cost, efforts, footPrint, duration);
        }

        results.setCampusTour(cti);

        Logger.writeMessage("Campus Tour Activity built:\n " + cti, Logger.DebugLevel.SETTINGACTIVITYCONTENTS);

    }

    /**
     * sets the cost, effort, carbon footprint and duration for selected sub-activity for Buying Books according to the selected book store
     */
    @Override
    public void buyBooks() {
        cost = new Cost(250.00, dollars);
        if (bookStoreChoice.equals(BookstoreE.MANDO)) {
            efforts = new Efforts(150.00, "Calories");
            footPrint = new CarbonFootPrint(0.6, "tons Co2");
            duration = new Duration(45, "Minutes");
            bbi = new MandoBookStore(cost, efforts, footPrint, duration);
        } else {
            efforts = new Efforts(50.00, "Calories");
            footPrint = new CarbonFootPrint(0.3, "tons Co2");
            duration = new Duration(15, "Minutes");
            bbi = new UniversityBookStore(cost, efforts, footPrint, duration);
        }

        results.setBuyingBooks(bbi);

        Logger.writeMessage("Buying Books Activity built:\n " + bbi, Logger.DebugLevel.SETTINGACTIVITYCONTENTS);

    }

    
    /**
     * sets the cost, effort, carbon footprint and duration for selected sub-activity for Selecting Dorm according to the selected Dorm
     */
    @Override
    public void slectingDorms() {

        cost = new Cost(700.00, dollars);
        if (dormsChoice.equals(DormsE.GAMING)) {
            efforts = new Efforts(150.00, "Calories");
            footPrint = new CarbonFootPrint(0.3, "tons Co2");
            duration = new Duration(30, "Minutes");
            sdi = new DormGamingContest(cost, efforts, footPrint, duration);
        } else {
            efforts = new Efforts(300.00, "Calories");
            footPrint = new CarbonFootPrint(0.9, "tons Co2");
            duration = new Duration(120, "Minutes");
            sdi = new DormInLine(cost, efforts, footPrint, duration);
        }

        results.setSelectDorm(sdi);

        Logger.writeMessage("Selecting Dorms Activity built:\n " + sdi, Logger.DebugLevel.SETTINGACTIVITYCONTENTS);

    }

    /**
     * sets the cost, effort, carbon footprint and duration for selected sub-activity for registering for classes
     */
    @Override
    public void registerForClasses() {

        cost = new Cost(3000.00, dollars);
        if (registrationChoice.equals(RegistrationE.OFFICE)) {
            efforts = new Efforts(200.00, "Calories");
            footPrint = new CarbonFootPrint(0.5, "tons Co2");
            duration = new Duration(30, "Minutes");
            cri = new RegisterInOffice(cost, efforts, footPrint, duration);
        } else {
            efforts = new Efforts(80.00, "Calories");
            footPrint = new CarbonFootPrint(0.2, "tons Co2");
            duration = new Duration(10, "Minutes");
            cri = new RegisterInLabOnline(cost, efforts, footPrint, duration);
        }

        results.setCourseRegistration(cri);

        Logger.writeMessage("Registering for Classes Activity built:\n " + cri, Logger.DebugLevel.SETTINGACTIVITYCONTENTS);

    }

    @Override
    public OrientationResultsInterface getResults() {
        return results;
    }

}
