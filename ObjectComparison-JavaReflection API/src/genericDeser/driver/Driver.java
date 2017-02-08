/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package genericDeser.driver;

import genericDeser.fileOperations.FileProcessor;
import genericDeser.fileOperations.FileProcessorI;
import genericDeser.util.Logger;
import genericDeser.util.PopulateObjects;
import genericDeser.util.PopulateObjectsI;
import java.io.IOException;

/**
 *
 * @author abhi2
 */
public class Driver {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        String inputFile = args[0];
        int debugVal = 0;
        
        
        //checking bounbdry condition
         if (args.length != 2) {
            System.err.println("Please enter arguments as (inputfile_name)(debug val)");
            System.exit(0);
        }
        if (isNumber(args[1])) {
            debugVal = Integer.parseInt(args[1]);
        }

        
        Logger.setDebugValue(debugVal);
        FileProcessorI fp = new FileProcessor(inputFile);
        PopulateObjectsI populate = new PopulateObjects(fp);
        populate.deserObjects();
        populate.printDetails();

    }

    /**
     * 
     * @param str
     * @return boolean (true if it is number or else false)
     */
    private static boolean isNumber(String str) {
        try {
            int number = Integer.parseInt(str);
        } catch (NumberFormatException exception) {
            System.err.println("INVALID FORMAT: Argument debugVal should be in Number format !!");
            System.exit(1);
        }
        return true;
    }
}
