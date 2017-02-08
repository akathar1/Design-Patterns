package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abhi2
 */
public class Students  {

    public String[] course;
    public String my_course;
    public String name;
    public int prefCount;

    public Students() {
       //  Logger.writeMessage(this.getClass().getSimpleName() + " Constructor called",
	//			Logger.DebugLevel.CONSTRUCTOR);
        this.course = new String[5];
    }

    public Students(String[] course, String name, int prefCount) {
        this.course = course;
        this.name = name;
        this.prefCount = prefCount;
    }

    public String[] getCourse() {
        return course;
    }

    public void setCourse(String[] course) {
        this.course = course;
    }

    public int getPrefCount() {
        return prefCount;
    }

    public void setPrefCount(int prefCount) {
        this.prefCount = prefCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMy_course() {
        return my_course;
    }

    public void setMy_course(String my_course) {
        this.my_course = my_course;
    }

    @Override
    public String toString() {
        return "Students{" + "course=" + course + ", name=" + name + ", prefCount=" + prefCount + '}';
    }

}
