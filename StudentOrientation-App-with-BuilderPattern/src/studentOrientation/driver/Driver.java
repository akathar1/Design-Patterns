/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.driver;

import studentorientation.util.Logger;
import studentorientation.builder.BuildOrientation;
import studentorientation.builder.BuildOrientationInterface;
import studentorientation.builder.WorkShop;
import studentorientation.builder.WorkShopInterface;
import studentorientation.constants.BookStoreChoice.BookstoreE;
import studentorientation.constants.CampusTourChoice.CampusTourE;
import studentorientation.constants.DormsChoice.DormsE;
import studentorientation.constants.RegistrationChoice.RegistrationE;
import studentorientation.store.OrientationResults;
import studentorientation.store.OrientationResultsInterface;

/**
 *
 * @author abhi2
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        /**
         * Debug value 0 for Constructor 
         * Debug value 1 for SETTINGACTIVITYCONTENTS 
         * Debug value 2 for displaying results
         * even if you don't use logger it will
         * display result but if you specify a logger value it will perform the
         * corresponding action only without displaying results
         */
        
        
        //Builder pattern
        BuildOrientationInterface buildOrientation = new BuildOrientation(BookstoreE.MANDO, CampusTourE.BYBUS, DormsE.STAND_LINE, RegistrationE.ONLINE_LAB);
        WorkShopInterface shop = new WorkShop();

        shop.construct(buildOrientation);

        OrientationResultsInterface resultsInterface = new OrientationResults(buildOrientation.getResults());

        /**
         * method call to display results
         */
        resultsInterface.display();

    }

}
