/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store;

import util.Students;

/**
 *
 * @author abhi2
 */
public interface StdoutDisplayInterface {

    public void writeSchedulesToScreen();

    public void insert(Students registerStudents);
}