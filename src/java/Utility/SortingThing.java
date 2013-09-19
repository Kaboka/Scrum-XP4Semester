/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import RenameLaterInterfaces.Istudent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Mathias
 */
public class SortingThing {
    
    static void sort(ArrayList<Istudent> students){
        
        int size = students.size();
        Istudent temp;
        for(int i = 0; i < size; i++){
            for(int y = 1; y <(size-i);y++){
                if(students.get(y-1).getRank() > students.get(i).getRank()){
                    temp = students.get(y-1);
                    students.set(y-1, students.get(i));
                    students.set(i, temp);
                    
                }
            }
        }
    }
}
