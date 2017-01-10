/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author abhi2
 */
public class Students {

    String[] course;
    String name;
    int prefCount;

    public Students() {
        this.course = new String[4];
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

    @Override
    public String toString() {
        return "Students{" + "course=" + course + ", name=" + name + ", prefCount=" + prefCount + '}';
    }

}
