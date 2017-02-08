/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import java.io.FileNotFoundException;
import store.FileDisplayInterface;
import store.Results;
import store.StdoutDisplayInterface;
import util.StudentRegistration;
import threadMgmt.CreateWorker;
import util.FileProcessor;
import util.Logger;
import util.StudentRegistrationInterface;
import util.Students;

/**
 *
 * @author abhi2
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        // TODO code application logic here

        String inputfile = "", outputfile = "", no_of_threads = "", debugVal = "";

        if (args.length != 4) {
            System.err.println("Please enter arguments as (inputfile_name)(outputfile_name)(number_of_threads)(DEBUG_LEVEL)");
            System.exit(0);
        }

        inputfile = args[0];
        outputfile = args[1];
        no_of_threads = args[2];
        debugVal = args[3];

        if (validate(no_of_threads, debugVal)) {

            Students[] studentsDisplay = new Students[80];

            Logger.setDebugValue(Integer.parseInt(debugVal));
            StudentRegistrationInterface studentRegistration = new StudentRegistration();
            FileProcessor fp = new FileProcessor(inputfile);
            FileDisplayInterface writeResults = new Results(studentsDisplay, fp);
            StdoutDisplayInterface displayResults = new Results(studentsDisplay, fp);
            CreateWorker createWorker = new CreateWorker(fp, displayResults, studentRegistration);
            createWorker.startworker(Integer.parseInt(no_of_threads));
            displayResults.writeSchedulesToScreen();
            writeResults.writeSchedulesToFile(outputfile);
        }
    }

 
    
    /**
     * 
     * @param no_of_threads
     * @param debugVal
     * Validates the command line arguments if are within the specified range or no
     * checks if debugVal is between 0 and 4
     * checks if no_of_threads is between 1 and 3
     * @return 
     */
    private static boolean validate(String no_of_threads, String debugVal) {

        if (isNumber(debugVal)) {
            if (isNumber(no_of_threads)) {
                if (Integer.parseInt(debugVal) < 0 || Integer.parseInt(debugVal) > 4) {
                    System.err.println("INVALID Range: valid range for debug value is 0-4!!");
                    System.exit(1);
                }
                if (Integer.parseInt(no_of_threads) < 1 || Integer.parseInt(no_of_threads) > 3) {
                    System.err.println("INVALID Range: valid range for no_of_threads argument is 1-3 !!");
                    System.exit(1);
                }
            }
        }
        return true;

    }

    
    /**
     * 
     * @param str
     * @return 
     * checks is debug value and no of threads are numbers(format checker)
     */
    private static boolean isNumber(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException exception) {
            System.err.println("INVALID FORMAT: Arguments no_of_threads and DebugValue should be in Number format !!");
            System.exit(1);
        }
        return true;
    }

}
