/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import classes.Course;
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
                int rank = student.getSatifaction();
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

    public static Collection<Course> convertToCourse(String string) throws IllegalArgumentException {
        Collection<Course> courseList = new ArrayList<>();

        if (!string.isEmpty()) {
            string = string.replaceAll("\"", "");
            string = string.substring(1, string.length() - 1);

            String[] courseArray = string.split(",");

            for (int i = 0; i < courseArray.length; i++) {
                Course course = new Course(courseArray[i]);
                courseList.add(course);
            }
        } else {
            throw new IllegalArgumentException("Utilities.convetToCourse - This is empty");
        }
        return courseList;
    }
    
    public static void calculateSatifaction(Collection<IStudent> students, Collection<Course> poolA, Collection<Course> poolB) {
        int poolACourse[] = new int[4];
        int poolBCourse[] = new int[4];

        if (!students.isEmpty() || !poolA.isEmpty() || !poolB.isEmpty()) {
            for (IStudent e : students) {
                poolACourse = new int[4];
                poolBCourse = new int[4];

                for (Course f : poolA) {
                    if (e.getFirstPrio1().getName().equals(f.getName())) {
                        poolACourse[0] += 1;
                    } else if (e.getFirstPrio2().getName().equals(f.getName())) {
                        poolACourse[1] += 1;
                    } else if (e.getSecondPrio1().getName().equals(f.getName())) {
                        poolACourse[2] += 1;
                    } else if (e.getSecondPrio2().getName().equals(f.getName())) {
                        poolACourse[3] += 1;
                    }
                }

                for (Course f : poolB) {
                    if (e.getFirstPrio1().getName().equals(f.getName())) {
                        poolBCourse[0] += 1;
                    } else if (e.getFirstPrio2().getName().equals(f.getName())) {
                        poolBCourse[1] += 1;
                    } else if (e.getSecondPrio1().getName().equals(f.getName())) {
                        poolBCourse[2] += 1;
                    } else if (e.getSecondPrio2().getName().equals(f.getName())) {
                        poolBCourse[3] += 1;
                    }
                }

                if (poolACourse[0] == 1 || poolACourse[1] == 1) {
                    if (poolBCourse[0] == 1 || poolBCourse[1] == 1) {

                        e.setSatifaction(4);
                    } else if (poolBCourse[2] == 1 || poolBCourse[3] == 1) {
                        e.setSatifaction(3);
                    } else {
                        e.setSatifaction(1);
                    }
                } else if (poolACourse[2] == 1 || poolACourse[3] == 1) {
                    if (poolBCourse[0] == 1 || poolBCourse[1] == 1) {
                        e.setSatifaction(3);
                    } else if (poolBCourse[2] == 1 || poolBCourse[3] == 1) {
                        e.setSatifaction(2);
                    } else {
                        e.setSatifaction(1);
                    }
                } else {
                    e.setSatifaction(1);
                }
            }
        }else{
            throw new IllegalArgumentException("Utilities.calculateSatifaction - A argument is empty");
        }
    }
}
