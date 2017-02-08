/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadMgmt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import store.StdoutDisplayInterface;
import util.FileProcessor;
import util.Logger.DebugLevel;
import util.StudentRegistrationInterface;

/**
 *
 * @author abhi2
 */
public class Worker implements Runnable {

    private FileProcessor fp = null;
    private String line = null;
    private StudentRegistrationInterface sr = null;
    private List<String> item_lines;
    private StdoutDisplayInterface results = null;

    public Worker(FileProcessor fileProcessorIn, StdoutDisplayInterface resultsIn, StudentRegistrationInterface studentRegistrationIn) {
        util.Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                util.Logger.DebugLevel.CONSTRUCTOR);
        fp = fileProcessorIn;
        sr = studentRegistrationIn;
        item_lines = new ArrayList<String>();
        results = resultsIn;

    }

    
    /**
     * To run all the created threads to process  
     */
    @Override
    public synchronized void run() {
        util.Logger.writeMessage("Thread " + Thread.currentThread().getName() + " entered run() method", DebugLevel.RUN);
        try {

            while ((line = fp.readByLine()) != null) {
                // line = fp.readByLine();
                item_lines.add(line);

                results.insert(sr.registerStudents(line));

            }

        } catch (IOException ex) {
            System.err.println("Error occured in run method");
            ex.printStackTrace();
        } finally {

        }
    }

}
