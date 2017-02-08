/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.ArrayList;
import java.util.List;
import static util.ObjectPool.countA;
import static util.ObjectPool.countB;
import static util.ObjectPool.countC;
import static util.ObjectPool.countD;
import static util.ObjectPool.countE;
import static util.ObjectPool.countF;
import static util.ObjectPool.countG;

/**
 *
 * @author abhi2
 */
public class StudentRegistration implements StudentRegistrationInterface {

    private Students[] studentid=null;
    private Students studentRecord=null;
    private List<Students> listofStudents = null;
    private ArrayList<String> courses = null;
    private int index, pref, iterator, i, k, temp;

    private List<String> allocatedCourses;
    private List<String> remainingCourses;
    private String availableCourse;

    public StudentRegistration() {
        Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
                Logger.DebugLevel.CONSTRUCTOR);
        courses = new ArrayList<String>(3);
        courses.add("A");
        courses.add("B");
        courses.add("C");
        courses.add("D");
        courses.add("E");
        courses.add("F");
        courses.add("G");
        studentid = new Students[80];
        for (int p = 0; p < 80; p++) {
            studentid[p] = new Students();
            studentid[p].prefCount = 0;
        }

        index = 0;
        pref = 1;
        iterator = 0;
        k = 0;
        i = 0;
        listofStudents = new ArrayList<Students>();
        availableCourse = null;
        ObjectPool.init();

    }
    
    
    /**
     * 
     * @param contents
     * 
     * takes the line read from file in run method as input
     * and allocates courses depending upon the max availability and preference
     * tries to at least allocate 2 to 3 courses according to their preference
     * in case of unavailability allocates the max available course
     * @return 
     */

    @Override
    public synchronized Students registerStudents(String contents) {
        studentRecord = new Students();
        allocatedCourses = new ArrayList<String>();
        String[] parts = contents.split("\\s+");
        ArrayList<String> arrlist = new ArrayList<String>(4);
        for (int p_i = 1; p_i <= 7; p_i++) {
            arrlist.add(parts[p_i]);

        }
        studentid[i].setName(parts[0]);

        while (k < 5) {
            index = student_preference(arrlist, pref);

            if (isAvailable(courses.get(index))) {
                if (k < 2) {
                    studentid[i].course[k] = courses.get(index);
                    studentid[i].setPrefCount(studentid[i].prefCount + pref);
                    ObjectPool.getnumActive(courses.get(index));
                    allocatedCourses.add(courses.get(index));

                } else {

                    remainingCourses = new ArrayList(courses);
                    remainingCourses.removeAll(allocatedCourses);
                    availableCourse = ObjectPool.borrowObject(remainingCourses);
                    studentid[i].course[k] = availableCourse;
                    studentid[i].setPrefCount(studentid[i].prefCount + Integer.parseInt(arrlist.get(courses.indexOf(availableCourse))));
                    ObjectPool.getnumActive(availableCourse);
                    allocatedCourses.add(availableCourse);

                }
                k++;
                pref++;

            } else {
                remainingCourses = new ArrayList(courses);
                remainingCourses.removeAll(allocatedCourses);

                availableCourse = ObjectPool.borrowObject(remainingCourses);
                studentid[i].course[k] = availableCourse;
                studentid[i].setPrefCount(studentid[i].prefCount + Integer.parseInt(arrlist.get(courses.indexOf(availableCourse))));
                ObjectPool.getnumActive(availableCourse);
                allocatedCourses.add(availableCourse);
                k++;
                pref++;
            }

        }
        k = 0;
        pref = 1;
        studentRecord = studentid[i];
        i++;
        return studentRecord;

    }

    /**
     * 
     * @param arrlist
     * @param pref
     * returns the course index of the given preference
     * @return 
     */
    public synchronized int student_preference(ArrayList<String> arrlist, int pref) {
        int minIndex = 0;
        minIndex = arrlist.indexOf(Integer.toString(pref));
        return minIndex;
    }

    
    /**
     * 
     * @param courseName
     * checks the availability of each course
     * @return 
     */
    public synchronized boolean isAvailable(String courseName) {

        if (courseName.equals("A") && countA <= 0) {
            return false;
        } else if (courseName.equals("B") && countB <= 0) {
            return false;
        } else if (courseName.equals("C") && countC <= 0) {
            return false;
        } else if (courseName.equals("D") && countD <= 0) {
            return false;
        } else if (courseName.equals("E") && countE <= 0) {
            return false;
        } else if (courseName.equals("F") && countF <= 0) {
            return false;
        } else if (courseName.equals("G") && countG <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public Students[] getStudentid() {
        return studentid;
    }

    public void setStudentid(Students[] studentid) {
        this.studentid = studentid;
    }

    @Override
    public String toString() {
        return "StudentRegistration{" + "studentid=" + studentid + ", studentRecord=" + studentRecord + ", listofStudents=" + listofStudents + ", courses=" + courses + '}';
    }

}
