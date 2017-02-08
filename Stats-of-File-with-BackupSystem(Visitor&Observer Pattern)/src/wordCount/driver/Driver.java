/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.driver;

import java.io.FileNotFoundException;
import java.io.IOException;
import wordCount.dsForStrings.BinarySearchTree;
import wordCount.dsForStrings.TreeForStringI;
import wordCount.util.FileProcessor;
import wordCount.util.FileProcessorI;
import wordCount.util.Test;
import wordCount.util.Logger;
import wordCount.visitors.DSProcessingVisitorI;
import wordCount.visitors.PopulateVisitor;
import wordCount.visitors.WordCountVisitor;

/**
 *
 * @author abhi2
 */
public class Driver {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        long start_time = System.currentTimeMillis();
        TreeForStringI treeDS = null;
        DSProcessingVisitorI dsp = null;
        DSProcessingVisitorI wordCount = null;
        // Logger.setDebugValue(4);

        if (args.length != 3) {
            System.err.println("Please enter arguments as (inputfile_name)(outputfile_name)(number_of_iterations)");
            System.exit(0);
        }

        String inputFile = args[0];
        String outputFile = args[1];
        int num_iterations = 0;

        if (isNumber(args[2])) {
            num_iterations = Integer.parseInt(args[2]);
        }
        String originalTreeFile = "originalTree.txt";
        String backUpTreeFile = "backupTree.txt";
        FileProcessorI fp = null;
        for (int i = 0; i < num_iterations; i++) {
            fp = new FileProcessor(inputFile, outputFile);
            treeDS = new BinarySearchTree();

            dsp = new PopulateVisitor(fp);
            treeDS.accept(dsp);

            wordCount = new WordCountVisitor(fp);
            treeDS.accept(wordCount);
            fp.closeReader();
            fp.closeWriter();
        }
        long finish_time = System.currentTimeMillis();
        long total_time = (finish_time - start_time) / num_iterations;
        System.out.println("Total Time : " + total_time + " milli seconds");

        Test test = new Test(treeDS, fp);
        test.createBackup(originalTreeFile, backUpTreeFile);

    }

    /**
     *
     * @param str checks if num_iterations are numbers(format checker)
     * @return boolean
     */
    private static boolean isNumber(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException exception) {
            System.err.println("INVALID FORMAT: Arguments num_iterations should be in Number format !!");
            System.exit(1);
        }
        return true;
    }

}
