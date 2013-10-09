
package classes;

import interfaces.IStudent;

public class Student implements IStudent{
    Course firstPrio1;
    Course firstPrio2;
    Course secondPrio1;
    Course secondPrio2;
    String name;
    int satifaction;

    public Student(String name, Course firstPrio1, Course firstPrio2, Course secondPrio1, Course secondPrio2) {
        this.firstPrio1 = firstPrio1;
        this.firstPrio2 = firstPrio2;
        this.secondPrio1 = secondPrio1;
        this.secondPrio2 = secondPrio2;
        this.name = name;
        this.satifaction = 1;
    }
    

    @Override
    public Course getFirstPrio1() {
        return firstPrio1;
    }

    @Override
    public void setFirstPrio1(Course forstePrio1) {
        this.firstPrio1 = forstePrio1;
    }

    @Override
    public Course getFirstPrio2() {
        return firstPrio2;
    }

 
    @Override
    public void setFirstPrio2(Course forstePrio2) {
        this.firstPrio2 = forstePrio2;
    }

    @Override
    public Course getSecondPrio1() {
        return secondPrio1;
    }

    @Override
    public void setSecondPrio1(Course andenPrio1) {
        this.secondPrio1 = andenPrio1;
    }

    @Override
    public Course getSecondPrio2() {
        return secondPrio2;
    }

    @Override
    public void setSecondPrio2(Course secondPrio2) {
        this.secondPrio2 = secondPrio2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public void setSatifaction(int newSatifaction){
        satifaction = newSatifaction;
    }
    @Override
    public int getSatifaction(){
        return satifaction;
    }
    

    
}
