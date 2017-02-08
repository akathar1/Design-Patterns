/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.dsForStrings;

import java.util.HashMap;
import java.util.Map;
import wordCount.Observer.ObserverInterface;
import wordCount.Observer.SubjectInterface;
import wordCount.util.Logger;

/**
 *
 * @author abhi2
 */
public class Node implements Cloneable, ObserverInterface, SubjectInterface {

    private String value;
    private Node leftChild;
    private Node rightChild;
    private int wordOccurences;
    private Map<ObserverInterface, String> observerMap=null;

    public Node(String valueIn) {
        value = valueIn;
        leftChild = null;
        rightChild = null;
        wordOccurences = 1;
        observerMap = new HashMap<>();

    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node leftChild) {
        this.leftChild = leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node rightChild) {
        this.rightChild = rightChild;
    }

    public int getWordOccurences() {
        return wordOccurences;
    }

    public void setWordOccurences(int wordOccurences) {
        this.wordOccurences = wordOccurences;
    }

    /**
     * update the notified observers
     * @param updatedValue 
     */
    @Override
    public void update(int updatedValue) {
        wordOccurences = updatedValue;
    }

    
    /**
     * registering nodes as observers
     * @param observer
     * @param nodeName 
     */
    @Override
    public void registerObeserver(ObserverInterface observer, String nodeName) {
         Logger.writeMessage(this.getClass().getSimpleName() + "adding observers to hashmap",
                Logger.DebugLevel.ENTRY);
        observerMap.put(observer, nodeName);
    }

    @Override
    public void removeObserver(ObserverInterface observer) {
         observerMap.remove(observer);
    }

    
    /**
     * notifying observers as they are updated
     * @param nodeId
     * @param updateValue 
     */
    @Override
    public void notifyObservers(String nodeId,int updateValue) {
         Logger.writeMessage(this.getClass().getSimpleName() + " notifying observers",
                Logger.DebugLevel.RUN);
        ObserverInterface currentObserver;

        for (Map.Entry<ObserverInterface, String> entry : observerMap.entrySet()) {  // Ietrate through hashmap
            if (entry.getValue().equals(nodeId)) {
                currentObserver = entry.getKey();
                currentObserver.update(updateValue);
                break;
            }
        }

    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Node{" + "value=" + value + ", wordOccurences=" + wordOccurences + '}';
    }

}
