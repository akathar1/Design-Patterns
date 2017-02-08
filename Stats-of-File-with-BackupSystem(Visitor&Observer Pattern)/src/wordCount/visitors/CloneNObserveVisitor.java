/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.visitors;

import java.util.logging.Level;
import java.util.logging.Logger;
import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.TreeForStringI;

/**
 *
 * @author abhi2
 */
public class CloneNObserveVisitor implements DSProcessingVisitorI {

    
    private TreeForStringI backupTree=null;
    
    public CloneNObserveVisitor(TreeForStringI backupTreeIn) {
       backupTree=backupTreeIn;
    }

    
    /**
     * cloning the original tree to create backupTree
     * @param tree 
     */
    @Override
    public void visit(TreeForStringI tree) {
         wordCount.util.Logger.writeMessage(this.getClass().getSimpleName() + "visit in Clone and observe visitor",
                wordCount.util.Logger.DebugLevel.RUN);

        try {
            backupTree.setRoot((Node) (tree.getRootNode()).clone());
            tree.getRootNode().registerObeserver(backupTree.getRootNode(),backupTree.getRootNode().getValue());
            tree.cloneNodesInorder(backupTree.getRootNode(), tree.getRootNode());
        } catch (CloneNotSupportedException ex) {
            Logger.getLogger(CloneNObserveVisitor.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
