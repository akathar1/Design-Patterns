/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.Observer;

/**
 *
 * @author abhi2
 */
public interface SubjectInterface {

    public void registerObeserver(ObserverInterface observer,String nodeName);

    public void removeObserver(ObserverInterface observer);

    public void notifyObservers(String nodeId,int updateValue);

}
