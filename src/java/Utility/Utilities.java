/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import classes.Fag;
import interfaces.IStudent;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author
 * Mathias
 */
public class Utilities {

    public static ArrayList<IStudent> sort(ArrayList<IStudent> students) throws IllegalArgumentException {
        ArrayList<IStudent> temp1 = new ArrayList<>();
        ArrayList<IStudent> temp2 = new ArrayList<>();
        ArrayList<IStudent> temp3 = new ArrayList<>();
        ArrayList<IStudent> temp4 = new ArrayList<>();
        ArrayList<IStudent> tempResult = new ArrayList<>();

        if (!students.isEmpty()) {
            for (IStudent student : students) {
                int rank = student.getTilfredshed();
                if (rank == 1) {
                    temp1.add(student);
                } else if (rank == 2) {
                    temp2.add(student);
                } else if (rank == 3) {
                    temp3.add(student);
                } else if (rank == 4) {
                    temp4.add(student);
                }
            }

            tempResult.addAll(temp1);
            tempResult.addAll(temp2);
            tempResult.addAll(temp3);
            tempResult.addAll(temp4);
        } else {
            throw new IllegalArgumentException("Utilities.sort - ArrayList is empty");
        }

        return tempResult;
    }

    static Collection<Fag> convertToFag(String string) throws IllegalArgumentException {
        Collection<Fag> fagListe = new ArrayList<>();

        if (!string.isEmpty()) {
            string = string.replaceAll("\"", "");
            string = string.substring(1, string.length() - 1);

            String[] fagArray = string.split(",");

            for (int i = 0; i < fagArray.length; i++) {
                Fag fag = new Fag(fagArray[i]);
                fagListe.add(fag);
                System.out.println("Fag nr:" + i + ", navn: " + fag.getName());
            }
        } else {
            throw new IllegalArgumentException("Utilities.convetToFag - This is empty");
        }
        return fagListe;
    }
    
    public static void udregnTilfredshed(Collection<IStudent> elever, Collection<Fag> poolA, Collection<Fag> poolB) {
        int poolAFag[] = new int[4];
        int poolBFag[] = new int[4];

        if (!elever.isEmpty() || !poolA.isEmpty() || !poolB.isEmpty()) {
            for (IStudent e : elever) {
                poolAFag = new int[4];
                poolBFag = new int[4];

                for (Fag f : poolA) {
                    if (e.getForstePrio1().getName().equals(f.getName())) {
                        poolAFag[0] += 1;
                        System.out.println("Plads 0 A");
                    } else if (e.getForstePrio2().getName().equals(f.getName())) {
                        poolAFag[1] += 1;
                        System.out.println("Plads 1 A");
                    } else if (e.getAndenPrio1().getName().equals(f.getName())) {
                        poolAFag[2] += 1;
                    } else if (e.getAndenPrio2().getName().equals(f.getName())) {
                        poolAFag[3] += 1;
                    }
                }

                for (Fag f : poolB) {
                    if (e.getForstePrio1().getName().equals(f.getName())) {
                        poolBFag[0] += 1;
                    } else if (e.getForstePrio2().getName().equals(f.getName())) {
                        poolBFag[1] += 1;
                    } else if (e.getAndenPrio1().getName().equals(f.getName())) {
                        poolBFag[2] += 1;
                    } else if (e.getAndenPrio2().getName().equals(f.getName())) {
                        poolBFag[3] += 1;
                    }
                }

                if (poolAFag[0] == 1 || poolAFag[1] == 1) {
                    if (poolBFag[0] == 1 || poolBFag[1] == 1) {

                        e.setTilfredshed(4);
                    } else if (poolBFag[2] == 1 || poolBFag[3] == 1) {
                        e.setTilfredshed(3);
                    } else {
                        e.setTilfredshed(1);
                    }
                } else if (poolAFag[2] == 1 || poolAFag[3] == 1) {
                    if (poolBFag[0] == 1 || poolBFag[1] == 1) {
                        e.setTilfredshed(3);
                    } else if (poolBFag[2] == 1 || poolBFag[3] == 1) {
                        e.setTilfredshed(2);
                    } else {
                        e.setTilfredshed(1);
                    }
                } else {
                    e.setTilfredshed(1);
                }
            }
        }else{
            throw new IllegalArgumentException("Utilities.udregnTilfredshed - A argument is empty");
        }
    }
}
