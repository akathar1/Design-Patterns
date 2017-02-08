/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.builder;

import studentorientation.util.Logger;

/**
 *
 * @author abhi2
 */
public class WorkShop implements WorkShopInterface {

    public WorkShop()
    {
        Logger.writeMessage(" Workshop constructor called...", Logger.DebugLevel.CONSTRUCTOR);
    }
    
    
    /**
     * Calling the method for completing all the activities
     * @param bo 
     */
    @Override
    public void construct(BuildOrientationInterface bo) {

        bo.campusTour();
        bo.buyBooks();
        bo.slectingDorms();
        bo.registerForClasses();
    }

}
