 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import util.FileProcessor;
import util.Logger.DebugLevel;
import util.Students;

/**
 *
 * @author abhi2
 */
public class Results implements StdoutDisplayInterface, FileDisplayInterface {

    private Students[] studentsDisplay=null;
    private int i = 0;
    private FileProcessor fp=null;
    private float totalPrefCount, averagePrefCount;

    public Results(Students[] studentsDisplayIn, FileProcessor fpIn) {
        util.Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                util.Logger.DebugLevel.CONSTRUCTOR);
        studentsDisplay = studentsDisplayIn;
        fp = fpIn;
        totalPrefCount = 0;
        averagePrefCount = 0;

    }

    /**
     * prints the results on the output screen
     */
    @Override
    public void writeSchedulesToScreen() {
        util.Logger.writeResultMessage("PRINTING RESULT TO SCREEN : ", DebugLevel.RESULT);
        System.out.println();
        for (int i = 0; i < 80; i++) {
            util.Logger.writeMessage("Contents of the Result DataStructure has record for " + studentsDisplay[i].getName(), DebugLevel.CONTENTS);
            util.Logger.writeResultMessage(studentsDisplay[i].getName() + " ", DebugLevel.RESULT);
            for (int j = 0; j < 5; j++) {
                util.Logger.writeResultMessage(studentsDisplay[i].course[j] + " ", DebugLevel.RESULT);

            }

            util.Logger.writeResultMessage(Integer.toString(studentsDisplay[i].getPrefCount()), DebugLevel.RESULT);
            totalPrefCount = totalPrefCount + studentsDisplay[i].getPrefCount();
            util.Logger.writeResultMessage("\n", DebugLevel.RESULT);
        }
        averagePrefCount = totalPrefCount / 80;
        util.Logger.writeResultMessage("\n", DebugLevel.RESULT);
        util.Logger.writeResultMessage("The AVERAGE PREFERENCE COUNT IS :" + averagePrefCount, DebugLevel.RESULT);
    }

    /**
     * writes the results to the file 
     * @param outputFile 
     */
    @Override
    public void writeSchedulesToFile(String outputFile) {

        fp.writeTofile(studentsDisplay, outputFile);

    }

    /**
     * inserts student records to the Students data structure
     * @param registerStudents 
     */
    @Override
    public synchronized void insert(Students registerStudents) {
        studentsDisplay[i] = registerStudents;
        util.Logger.writeMessage("Record for " + studentsDisplay[i].getName() + " is added to the result", DebugLevel.ENTRY);
        i++;
    }

    @Override
    public String toString() {
        return "Results{" + "studentsDisplay=" + studentsDisplay + ", i=" + i + ", fp=" + fp + ", totalPrefCount=" + totalPrefCount + ", averagePrefCount=" + averagePrefCount + '}';
    }

}
