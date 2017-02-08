/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import wordCount.dsForStrings.Node;
import wordCount.visitors.TreeTraversalI;

/**
 *
 * @author abhi2
 */
public class FileProcessor implements FileProcessorI {

    private String in_file = null;
    private String out_file = null;
    FileReader fileReader = null;
    private BufferedReader reader = null;
    FileWriter writer = null;
    private BufferedWriter bw = null;

    public FileProcessor(String inputfileIn, String out_fileIn) throws FileNotFoundException, IOException {
        Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                Logger.DebugLevel.CONSTRUCTOR);
        try {
            in_file = inputfileIn;
            out_file = out_fileIn;
            fileReader = new FileReader(in_file);
            reader = new BufferedReader(fileReader);
            writer = new FileWriter(out_file);
            bw = new BufferedWriter(writer);
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found.");
            System.exit(1);
        }

    }

    /**
     *
     * @param filename
     */
    @Override
    public void openFileToWrite(String filename) {
        try {
            writer = new FileWriter(filename);
            bw = new BufferedWriter(writer);
        } catch (IOException ex) {
            System.err.println("Error opening file");
            System.exit(1);
        }
    }

    /**
     * reads and returns one line at a time
     *
     * @return
     *
     */
    @Override
    public String readByLine() {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading file");
            System.exit(1);
        }
        return null;
    }

    
    /**
     * close file after reading
     */
    @Override
    public void closeReader() {
        try {
            fileReader.close();
        } catch (IOException e) {
            System.err.println("Error closing file");
            System.exit(1);
        }
    }

     /**
     * close file after writing
     */
    @Override
    public void closeWriter() {
        try {
            bw.close();
        } catch (IOException e) {
            System.err.println("Error closing file");
            System.exit(1);
        }
    }

    public String getIn_file() {
        return in_file;
    }

    public void setIn_file(String in_file) {
        this.in_file = in_file;
    }

    
    /**
     * writing tree stats to the file
     * @param result 
     */
    @Override
    public void writeTofile(TreeTraversalI result) {

        try {

            bw.write("Total number of characters : " + result.getTotalChar()
                    + "\nTotal number of unique words : " + result.getTotalUniqueWords()
                    + "\nTotal number of words : " + result.getTotalNumberOfWords());

        } catch (IOException ex) {
            System.err.println("IOException while writting to file");
            System.exit(0);
        } finally {

        }
    }

    
    /**
     * writing tree inorder to the opened file
     * @param root 
     */
    @Override
    public void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.getLeftChild());
            try {
                bw.write("word : " + root.getValue() + " count " + root.getWordOccurences() + "\n");
            } catch (IOException ex) {
                System.err.println("IOException while writting to file");
                System.exit(0);
            }
            printInOrder(root.getRightChild());
        }
    }

    @Override
    public String toString() {
        return "FileProcessor{" + "in_file=" + in_file + ", reader=" + reader + '}';
    }

}
