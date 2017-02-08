/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author abhi2
 */
public class FileProcessor {

    private String in_file=null;
    private BufferedReader reader = null;

    public FileProcessor(String inputfileIn) throws FileNotFoundException {
        util.Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                util.Logger.DebugLevel.CONSTRUCTOR);
        try {
            in_file = inputfileIn;
            FileReader fileReader
                    = new FileReader(in_file);
            reader = new BufferedReader(fileReader);
        } catch (FileNotFoundException ex) {
            System.err.println("File Not Found.");
            ex.printStackTrace();
            System.exit(1);
        }

    }

    
    /**
     * reads and returns one line at a time
     * @return
     * @throws IOException 
     */
    public synchronized String readByLine() throws IOException {
        try {
            return reader.readLine();
        } catch (IOException e) {
            System.err.println("Error reading file");
            System.exit(1);
        }
        return null;
    }

    public void closeReader() {
        try {
            reader.close();
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
     * 
     * @param studentsDisplay
     * @param outputFile
     * Writes the result from the Students array to the file
     */
    public void writeTofile(Students[] studentsDisplay, String outputFile) {
        FileWriter writer = null;
        float totalPrefCount=0;
        float averagePrefCount=0;
        try {

            writer = new FileWriter(outputFile, true);

            for (int i = 0; i < 80; i++) {

                writer.write(studentsDisplay[i].getName() + " ");
                for (int j = 0; j < 5; j++) {
                    writer.write(studentsDisplay[i].course[j] + " ");

                }

                writer.write(Integer.toString(studentsDisplay[i].getPrefCount()));
                totalPrefCount = totalPrefCount + studentsDisplay[i].getPrefCount();
                writer.write("\n");
            }
             averagePrefCount = totalPrefCount / 80;
             writer.write("\n The AVERAGE PREFERENCE COUNT IS :"+averagePrefCount);

            writer.close();
        } catch (IOException ex) {
            System.err.println("IOException while writting to file");
            ex.printStackTrace();
            System.exit(0);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
                System.exit(0);
            }
        }
    }

    @Override
    public String toString() {
        return "FileProcessor{" + "in_file=" + in_file + ", reader=" + reader + '}';
    }

 
    
}
