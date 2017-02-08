/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.visitors;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import wordCount.dsForStrings.TreeForStringI;
import wordCount.util.FileProcessorI;
import wordCount.util.Logger;

/**
 *
 * @author abhi2
 */
public class PopulateVisitor implements DSProcessingVisitorI {

    private FileProcessorI readFile = null;
    private List<String> item_lines = null;
    private String line = null;

    public PopulateVisitor(FileProcessorI fpIn) {
        Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                Logger.DebugLevel.CONSTRUCTOR);
        readFile = fpIn;
        item_lines = new ArrayList<>();
    }

    
    /**
     * reading a line from a file and populating the tree
     * @param tree 
     */
    @Override
    public void visit(TreeForStringI tree) {
        wordCount.util.Logger.writeMessage(this.getClass().getSimpleName() + "visitand populate data structure",
                wordCount.util.Logger.DebugLevel.RUN);

        /**
         * removed as StringTokenizer works more faster than split
         */
        
        
        /*  int i;
        while ((line=readFile.readByLine()) != null) {
            String[] parts;
            parts = line.split("\\s+");

            for (i = 0; i < parts.length; i++) {
                if(!parts[i].isEmpty())
                tree.insert(parts[i]);
            }
            
        }
        
         */
        while ((line = readFile.readByLine()) != null) {
            StringTokenizer tokens = new StringTokenizer(line);
            while (tokens.hasMoreTokens()) {
                String value = tokens.nextToken();
                tree.insert(value);
            }
        }
    }

}
