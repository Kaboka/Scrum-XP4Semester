/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Course;

public interface IStudent {

    Course getFirstPrio1();

    void setFirstPrio1(Course forstePrio1);

    Course getFirstPrio2();

    void setFirstPrio2(Course forstePrio2);

    Course getSecondPrio1();

    void setSecondPrio1(Course andenPrio1);

    Course getSecondPrio2();

    void setSecondPrio2(Course andenPrio2);

    String getName();

    void setName(String name);
    
    void setSatifaction(int til);
    
    int getSatifaction(); 
}
