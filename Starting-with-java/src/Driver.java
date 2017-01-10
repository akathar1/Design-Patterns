/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abhi2
 */
public class Driver {

    public static int countA = 0, countB = 0, countC = 0, countD = 0;
    public static String inputFile,outputFile;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
    
    /*
    boundry condition for command line arguments
    */
    if (args.length != 2) {
            System.out.println("Insufficient Arguments...please provide two arguments for input and output files!!");
            System.exit(0);
        }
    inputFile=args[0];
    outputFile=args[1];

        
        List<String> item_lines = new ArrayList<String>();
        try {
            String itemfilename = args[0];
            Scanner initemfile = new Scanner(new File(itemfilename));

            while (initemfile.hasNextLine()) {
                item_lines.add(initemfile.nextLine());
            }
            String[] item_arr = item_lines.toArray(new String[0]);
        } catch (FileNotFoundException ex) {
            System.out.println("FILE NOT FOUND");
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        }
        
        
        int iterator = 0, k = 0, j = 1;
        /*
        Creating array of student records to store allocated subjects according to their possible preferences 
        */
        Students[] studentid = new Students[12];
        Students[] studentid1 = new Students[12];
       
       /*initializing student array 
        */
        for (int i = 0; i < 12; i++) {
            studentid[i] = new Students();
        }
       
       /*iterating over the records for course allocation
        */
        for (iterator = 0; iterator < 3; iterator++) {
            int i = 0;
            int temp = 0;
            for (String contents : item_lines) {

                String[] parts = contents.split("\\s+");
                ArrayList<String> arrlist = new ArrayList<String>(4);
                arrlist.add(parts[1]);
                arrlist.add(parts[2]);
                arrlist.add(parts[3]);
                arrlist.add(parts[4]);
                ArrayList<String> courses = new ArrayList<String>(3);
                courses.add("A");
                courses.add("B");
                courses.add("C");
                courses.add("D");

                int index = student_preference(arrlist, j);

              /*setting count of the assigned courses
              */
                if (index == 0) {
                    countA++;
                }
                if (index == 1) {
                    countB++;
                }
                if (index == 2) {
                    countC++;
                }
                if (index == 3) {
                    countD++;
                }
                
                /*checking the availability of the course
                */
                if (isAvailable(courses.get(index))) {

                    studentid[i].course[k] = courses.get(index);
                    studentid[i].setName(parts[0]);
                    studentid[i].prefCount = studentid[i].prefCount + j;

                    i++;
                }
                /*if not available assign the next preferred course 
                */
                else {
                    temp++;
                    studentid[i].setName(parts[0]);
                    index = student_preference(arrlist, j + 1);
                    if (index == 0) {
                        countA++;
                    }
                    if (index == 1) {
                        countB++;
                    }
                    if (index == 2) {
                        countC++;
                    }
                    if (index == 3) {
                        countD++;
                    }
                    studentid[i].course[k] = courses.get(index);
                    studentid[i].prefCount = studentid[i].prefCount + j + 1;
                    i++;

                }
            }
            k++;
            if (j < 4) {
                j++;
            }
        }
        /*for (int i = 0; i < 12; i++) {
            System.out.print(studentid[i].name);
            for (j = 0; j < 3; j++) {
                System.out.print(" " + studentid[i].course[j]);
            }
            System.out.print(" " + studentid[i].prefCount);
            System.out.println();
        }*/
        
        
        int totalPrefCount = 0;
        float averagePrefCount = 0;
        ArrayList<String> finalList = new ArrayList<String>(3);
        
        /*storing the records into arraylist to write to file
        */
        for (int i = 0; i < 12; i++) {
            finalList.add(studentid[i].name);
            for (j = 0; j < 3; j++) {
                finalList.add(studentid[i].course[j]);
            }
            totalPrefCount = totalPrefCount + studentid[i].prefCount;
            finalList.add(Integer.toString(studentid[i].prefCount));

            finalList.add("\n");

        }
        averagePrefCount = (float)totalPrefCount / 12;
        finalList.add("\n Average Preference count is : " + Float.toString(averagePrefCount));
        writetofile(finalList);

    }


  /*getting the index of the preferred course so as to get the course name from the course arrayList 
  * the return type is int as this method returns an integer which is used as index for identifying the course 
  */
    private static int student_preference(ArrayList<String> arrlist, int pref) {
        //System.out.println("ggg" + arrlist);
        int minIndex = 0;
        minIndex = arrlist.indexOf(Integer.toString(pref));

        return minIndex;
    }


/*method for writing the records to file
  */
    private static void writetofile(ArrayList<String> finalList) {

        FileWriter writer = null;
        try {
            writer = new FileWriter(outputFile, true);
            writer.write(" ");
            for (String str : finalList) {
                writer.write(str + " ");
                if (finalList.equals("\n")) {
                    writer.write("\n");
                }
            }
            writer.close();
        } catch (IOException ex) {
            System.out.println("IOException");
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            System.exit(0);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                System.out.println("IOException");
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
                System.exit(0);
            }
        }
    }

 /*checking the availability of the preferred course
  * return type is boolean as this method returns true if course
  * is available or false if not
  */
    private static boolean isAvailable(String courseName) {
        if (courseName.equals("A") && countA > 10) {
            return false;
        } else if (courseName.equals("B") && countB > 10) {
            return false;
        } else if (courseName.equals("C") && countC > 10) {
            return false;
        } else if (courseName.equals("D") && countD > 10) {
            return false;
        } else {
            return true;
        }

    }
}
