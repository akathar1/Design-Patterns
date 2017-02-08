/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author abhi2
 */
public abstract class ObjectPool {
    static int countA, countB, countC, countD, countE, countF, countG;

    public static void init() {
        countA = 60;
        countB = 60;
        countC = 60;
        countD = 60;
        countE = 60;
        countF = 60;
        countG = 60;
    }

    
    /**
     * 
     * @param rem_courses
     * 
     * takes the courses which are not allocated to the student
     * returns the max available course
     * @return 
     */
    public static String borrowObject(List<String> rem_courses) {
        String my_course = null;
        int i = 0;
        Map<String, Integer> hashmap = new HashMap<String, Integer>();
        i = rem_courses.size();
        int max_no = 0;
        i--;
        while (i >= 0) {
            if (rem_courses.get(i).equals("A")) {
                //   counts.add(this.getCountA());
                hashmap.put("A", getCountA());
            }
            if (rem_courses.get(i).equals("B")) {
                hashmap.put("B", getCountB());
            }
            if (rem_courses.get(i).equals("C")) {
                hashmap.put("C", getCountC());
            }
            if (rem_courses.get(i).equals("D")) {
                hashmap.put("D", getCountD());
            }
            if (rem_courses.get(i).equals("E")) {
                hashmap.put("E", getCountE());
            }
            if (rem_courses.get(i).equals("F")) {
                hashmap.put("F", getCountF());
            }
            if (rem_courses.get(i).equals("G")) {
                hashmap.put("G", getCountG());
            }
            i--;
        }

        max_no = Collections.max(hashmap.values());
        for (Map.Entry<String, Integer> entry : hashmap.entrySet()) {  // Ietrate through hashmap
            if (entry.getValue() == max_no) {
                my_course = entry.getKey();
                break;
            }
        }

        return my_course;
    }

    
    /**
     * 
     * @param my_course
     * keep track of allocated courses
     */
    public static synchronized void getnumActive(String my_course) {
        if (my_course.equals("A")) {
            countA--;
        }
        if (my_course.equals("B")) {
            countB--;
        }
        if (my_course.equals("C")) {
            countC--;
        }
        if (my_course.equals("D")) {
            countD--;
        }
        if (my_course.equals("E")) {
            countE--;
        }
        if (my_course.equals("F")) {
            countF--;
        }
        if (my_course.equals("G")) {
            countG--;
        }
    }

   

    public static int getCountA() {
        return countA;
    }

    public static void setCountA(int countA) {
        ObjectPool.countA = countA;
    }

    public static int getCountB() {
        return countB;
    }

    public static void setCountB(int countB) {
        ObjectPool.countB = countB;
    }

    public static int getCountC() {
        return countC;
    }

    public static void setCountC(int countC) {
        ObjectPool.countC = countC;
    }

    public static int getCountD() {
        return countD;
    }

    public static void setCountD(int countD) {
        ObjectPool.countD = countD;
    }

    public static int getCountE() {
        return countE;
    }

    public static void setCountE(int countE) {
        ObjectPool.countE = countE;
    }

    public static int getCountF() {
        return countF;
    }

    public static void setCountF(int countF) {
        ObjectPool.countF = countF;
    }

    public static int getCountG() {
        return countG;
    }

    public static void setCountG(int countG) {
        ObjectPool.countG = countG;
    }

}
