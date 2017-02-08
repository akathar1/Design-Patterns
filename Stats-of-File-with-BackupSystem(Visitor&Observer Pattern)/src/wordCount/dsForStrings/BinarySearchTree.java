/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.dsForStrings;

import java.util.logging.Level;
import java.util.logging.Logger;
import wordCount.visitors.DSProcessingVisitorI;

/**
 *
 * @author abhi2
 */
public class BinarySearchTree implements TreeForStringI {

    public Node root;

    public BinarySearchTree() {
         wordCount.util.Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                wordCount.util.Logger.DebugLevel.CONSTRUCTOR);
        root = null;
    }

    
    /**
     * creating the tree by inserting data one by one
     * @param word 
     */
    @Override
    public void insert(String word) {
        wordCount.util.Logger.writeMessage(this.getClass().getSimpleName() +
                "Inserting data to the tree/creating binary search tree",
                wordCount.util.Logger.DebugLevel.ENTRY);
        Node newNode = new Node(word);
        if (root == null) {

            root = newNode;
            return;
        }
        int compare;

        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;

            if ((current.getValue().compareTo(word)) > 0) {
                current = current.getLeftChild();
                if (current == null) {
                    parent.setLeftChild(newNode);
                    return;
                }
            } else if ((current.getValue().compareTo(word)) < 0) {
                current = current.getRightChild();
                if (current == null) {
                    parent.setRightChild(newNode);
                    return;
                }
            } else {
                current.setWordOccurences(current.getWordOccurences() + 1);
                return;
            }
        }

    }

    @Override
    public void updateNode() {

        updateInOrder(root);

    }
/**
 * increasing the count of the words of each node twice
 * @param node 
 */
    public void updateInOrder(Node node) {
        if (node == null) {
            return;
        }

        updateInOrder(node.getLeftChild());
        node.setWordOccurences(node.getWordOccurences()*2);
        node.notifyObservers(node.getValue(),node.getWordOccurences());
        updateInOrder(node.getRightChild());
    }

    @Override
    public void accept(DSProcessingVisitorI visitor) {
        visitor.visit(this);
    }

    @Override
    public Node getRootNode() {
        return root;
    }

    @Override
    public void setRoot(Node node) {
        root = node;
    }

    
    /**
     * cloning the original tree to create a backup
     * registering the nodes as observers one by one
     * @param backupNode
     * @param originalNode 
     */
    @Override
    public void cloneNodesInorder(Node backupNode, Node originalNode) {
         wordCount.util.Logger.writeMessage(this.getClass().getSimpleName() + " cloining nodes in order",
                wordCount.util.Logger.DebugLevel.RUN);
        if (originalNode == null) {
            return;
        }

        if (originalNode.getLeftChild() != null) {
            try {
                backupNode.setLeftChild((Node) originalNode.getLeftChild().clone());
                originalNode.getLeftChild().registerObeserver(backupNode.getLeftChild(), backupNode.getLeftChild().getValue());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(BinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
            }
            cloneNodesInorder(backupNode.getLeftChild(), originalNode.getLeftChild());

        }

        if (originalNode.getRightChild() != null) {
            try {
                backupNode.setRightChild((Node) originalNode.getRightChild().clone());
                originalNode.getRightChild().registerObeserver(backupNode.getRightChild(), backupNode.getRightChild().getValue());
            } catch (CloneNotSupportedException ex) {
                Logger.getLogger(BinarySearchTree.class.getName()).log(Level.SEVERE, null, ex);
            }
            cloneNodesInorder(backupNode.getRightChild(), originalNode.getRightChild());
        }

    }

    
    /**
     * printing inorder
     * @param root 
     */
    @Override
    public void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.getLeftChild());
            System.out.println("word : " + root.getValue() + " count " + root.getWordOccurences());
            printInOrder(root.getRightChild());
        }
    }

    @Override
    public String toString() {
        return "BinarySearchTree{" + "root=" + root + '}';
    }

}
