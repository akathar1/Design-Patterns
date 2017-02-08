/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.util;

import wordCount.dsForStrings.Node;
import wordCount.visitors.TreeTraversalI;

/**
 *
 * @author abhi2
 */
public interface FileProcessorI {

    public String readByLine();

    public void closeReader();
    
    public void closeWriter();

    public void writeTofile(TreeTraversalI result);

    public void openFileToWrite(String filename);
    
    public void printInOrder(Node root);
}
