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
    
    public static ArrayList<Istudent> sort(ArrayList<Istudent> students){
        
        ArrayList<Istudent> temp1 = new ArrayList<Istudent>();
        ArrayList<Istudent> temp2 = new ArrayList<Istudent>();
        ArrayList<Istudent> temp3 = new ArrayList<Istudent>();
        ArrayList<Istudent> temp4 = new ArrayList<Istudent>();
        ArrayList<Istudent> tempResult = new ArrayList<Istudent>();
        
        
        for(Istudent student : students){
            int rank = student.getRank(); 
            if(rank == 1){
                temp1.add(student);
            }else if(rank == 2){
                temp2.add(student);
            }else if(rank == 3){
                temp3.add(student);
            }else if(rank == 4){
                temp4.add(student);
            }
        }
        
        tempResult.addAll(temp1);
        tempResult.addAll(temp2);
        tempResult.addAll(temp3);
        tempResult.addAll(temp4);
        
        
        return tempResult;
    }
}
