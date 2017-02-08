/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.util;

import wordCount.dsForStrings.BinarySearchTree;
import wordCount.dsForStrings.TreeForStringI;
import wordCount.visitors.CloneNObserveVisitor;
import wordCount.visitors.DSProcessingVisitorI;

/**
 *
 * @author abhi2
 */
public class Test {

    TreeForStringI primaryTree = null;
    FileProcessorI fp = null;

    public Test(TreeForStringI treeDSIn, FileProcessorI fpIn) {
         Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                Logger.DebugLevel.CONSTRUCTOR);
        primaryTree = treeDSIn;
        fp = fpIn;
    }

    /**
     * check observer pattern implementation
     * @param originalTreeFile
     * @param backUpTreeFile 
     */
    public void createBackup(String originalTreeFile, String backUpTreeFile) {
        if (primaryTree.getRootNode() != null) {
            TreeForStringI backupTree = new BinarySearchTree();
            DSProcessingVisitorI cloneObserver = new CloneNObserveVisitor(backupTree);
            primaryTree.accept(cloneObserver);
            fp.openFileToWrite(originalTreeFile);
            fp.printInOrder(primaryTree.getRootNode());
            fp.closeWriter();
            primaryTree.updateNode();
           // System.out.println("------------Updated Original Tree-----------");
            //primaryTree.printInOrder(primaryTree.getRootNode());
            fp.openFileToWrite(backUpTreeFile);
            fp.printInOrder(backupTree.getRootNode());
            fp.closeWriter();
        }

    }

}
