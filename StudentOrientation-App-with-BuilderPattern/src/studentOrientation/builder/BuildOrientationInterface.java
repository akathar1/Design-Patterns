/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentorientation.builder;

import studentorientation.store.OrientationResultsInterface;

/**
 *
 * @author abhi2
 */
public interface BuildOrientationInterface {

    public void campusTour();

    public void buyBooks();

    public void slectingDorms();

    public void registerForClasses();

    public OrientationResultsInterface getResults();

}
