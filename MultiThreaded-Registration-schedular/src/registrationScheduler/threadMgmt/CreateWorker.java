/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threadMgmt;

import java.util.ArrayList;
import java.util.List;
import store.StdoutDisplayInterface;
import util.FileProcessor;
import util.Logger;
import util.Logger.DebugLevel;
import util.StudentRegistrationInterface;

/**
 *
 * @author abhi2
 */
public class CreateWorker {

   private FileProcessor fp=null;
   private StdoutDisplayInterface r=null;
   private StudentRegistrationInterface sr=null;

    public CreateWorker(FileProcessor fileProcessorIn, StdoutDisplayInterface resultsIn, StudentRegistrationInterface studentRegistrationIn) throws InterruptedException {
       Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
				DebugLevel.CONSTRUCTOR);
        fp = fileProcessorIn;
        r = resultsIn;
        sr = studentRegistrationIn;

    }

    
    /**
     * 
     * @param num_threads
     * creates and starts specified number of threads
     */
    public final void startworker(int num_threads) {
        List<Thread> threads = new ArrayList<Thread>();
        for (int count = 0; count < num_threads; count++) {
            Worker worker = new Worker(fp, r, sr);
            Thread t = new Thread(worker, String.valueOf(count));
            t.start();
            threads.add(t);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException exception) {
                System.err.println("Error in joining thread !!");
                exception.printStackTrace();
                System.exit(1);
            }
        }
    }
}
