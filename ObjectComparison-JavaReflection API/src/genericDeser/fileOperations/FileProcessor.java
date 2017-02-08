/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericDeser.fileOperations;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author abhi2
 */
public class FileProcessor implements FileProcessorI {

    private String in_file = null;
    private String out_file = null;
    FileReader fileReader = null;
    private BufferedReader reader = null;

    public FileProcessor(String inputfileIn) throws FileNotFoundException, IOException {
        genericDeser.util.Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                genericDeser.util.Logger.DebugLevel.CONSTRUCTOR);
        try {
            in_file = inputfileIn;
            fileReader = new FileReader(in_file);
            reader = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found.");
            System.exit(1);
        }

    }

    /**
     * reads and returns one line at a time
     *
     * @return null 
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

    public String getIn_file() {
        return in_file;
    }

    public void setIn_file(String in_file) {
        this.in_file = in_file;
    }

    @Override
    public String toString() {
        return "FileProcessor{" + "in_file=" + in_file + ", reader=" + reader + '}';
    }

}
