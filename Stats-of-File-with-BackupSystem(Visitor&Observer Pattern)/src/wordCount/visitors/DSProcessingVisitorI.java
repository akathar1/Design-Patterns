/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.visitors;

import wordCount.dsForStrings.TreeForStringI;

/**
 *
 * @author abhi2
 */
public interface DSProcessingVisitorI  {
    
    
    public void visit(TreeForStringI tree);
}
