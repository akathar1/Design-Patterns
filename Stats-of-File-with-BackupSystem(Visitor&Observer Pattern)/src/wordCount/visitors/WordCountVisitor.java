/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.visitors;

import wordCount.dsForStrings.Node;
import wordCount.dsForStrings.TreeForStringI;
import wordCount.util.FileProcessorI;
import wordCount.util.Logger;

/**
 *
 * @author abhi2
 */
public class WordCountVisitor implements DSProcessingVisitorI {

    private TreeTraversalI treeTraversal = null;
    private Node rootNode;
    private FileProcessorI fileProcessor=null;

    public WordCountVisitor(FileProcessorI fileProcessorIn) {
        
         Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                Logger.DebugLevel.CONSTRUCTOR);

        treeTraversal = new TreeTraversal();
        fileProcessor=fileProcessorIn;
    }
/**
 * this visit method visits the tree to obtain information
 * about the tree
 * @param tree 
 */
    @Override
    public void visit(TreeForStringI tree) {
        rootNode = tree.getRootNode();

        treeTraversal.traverseInorder(rootNode);
        fileProcessor.writeTofile(treeTraversal);
        
    }

}
