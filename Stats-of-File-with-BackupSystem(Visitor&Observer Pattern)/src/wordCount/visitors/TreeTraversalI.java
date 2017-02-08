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
public interface TreeTraversalI {

    public void traverseInorder(Node node);

    public int getTotalUniqueWords();

    public void setTotalUniqueWords(int totalUniqueWords);

    public int getTotalNumberOfWords();

    public void setTotalNumberOfWords(int totalNumberOfWords);

    public int getTotalChar();

    public void setTotalChar(int totalChar);
}
