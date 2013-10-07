/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import RenameLaterInterfaces.Istudent;
import classes.Elev;
import interfaces.IElev;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author Mathias
 */
public class SortingThing {
    
    public static ArrayList<IElev> sort(ArrayList<IElev> students){
        
        ArrayList<IElev> temp1 = new ArrayList<>();
        ArrayList<IElev> temp2 = new ArrayList<>();
        ArrayList<IElev> temp3 = new ArrayList<>();
        ArrayList<IElev> temp4 = new ArrayList<>();
        ArrayList<IElev> tempResult = new ArrayList<>();
        
        
        for(IElev student : students){
            int rank = student.getTilfredshed(); 
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
