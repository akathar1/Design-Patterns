/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.dsForStrings;

import wordCount.visitors.DSProcessingVisitorI;

/**
 *
 * @author abhi2
 */
public interface TreeForStringI {

    public void insert(String word);

    public void accept(DSProcessingVisitorI visitor);

    public Node getRootNode();

    public void cloneNodesInorder(Node backuprootNode, Node rootNode);

    public void updateNode();

    public void setRoot(Node root);

    public void printInOrder(Node root);
}
