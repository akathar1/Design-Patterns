/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.visitors;

import wordCount.dsForStrings.Node;

/**
 *
 * @author abhi2
 */
public class TreeTraversal implements TreeTraversalI {

    private Node currentNode;
    private int totalUniqueWords;
    private int totalNumberOfWords;
    private int totalChar;

    public TreeTraversal() {
        totalUniqueWords = 0;
        totalNumberOfWords = 0;
        totalChar = 0;

    }

    
    /**
     * traversing in order to get the stats of the original tree
     * @param node 
     */
    @Override
    public void traverseInorder(Node node) {
        if (node == null) {
            return;
        }

        traverseInorder(node.getLeftChild());

        setTotalChar(totalChar + (node.getValue().length() * node.getWordOccurences()));
        setTotalUniqueWords(totalUniqueWords + 1);
        setTotalNumberOfWords(totalNumberOfWords + node.getWordOccurences());

        traverseInorder(node.getRightChild());
    }

    

    @Override
    public int getTotalUniqueWords() {
        return totalUniqueWords;
    }

    @Override
    public void setTotalUniqueWords(int totalUniqueWords) {
        this.totalUniqueWords = totalUniqueWords;
    }

    @Override
    public int getTotalNumberOfWords() {
        return totalNumberOfWords;
    }

    @Override
    public void setTotalNumberOfWords(int totalNumberOfWords) {
        this.totalNumberOfWords = totalNumberOfWords;
    }

    @Override
    public int getTotalChar() {
        return totalChar;
    }

    @Override
    public void setTotalChar(int totalChar) {
        this.totalChar = totalChar;
    }

}
