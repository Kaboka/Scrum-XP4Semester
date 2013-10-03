
package classes;

import interfaces.IElev;

public class Elev implements IElev{
    Fag forstePrio1;
    Fag forstePrio2;
    Fag andenPrio1;
    Fag andenPrio2;
    String name;
    int tilfredshed;
    
    public Elev(String name){
        this.name = name;       
    };

    @Override
    public Fag getForstePrio1() {
        return forstePrio1;
    }

    @Override
    public void setForstePrio1(Fag forstePrio1) {
        this.forstePrio1 = forstePrio1;
    }

    @Override
    public Fag getForstePrio2() {
        return forstePrio2;
    }

    /**
     *
     * @param forstePrio2
     */
    @Override
    public void setForstePrio2(Fag forstePrio2) {
        this.forstePrio2 = forstePrio2;
    }

    @Override
    public Fag getAndenPrio1() {
        return andenPrio1;
    }

    @Override
    public void setAndenPrio1(Fag andenPrio1) {
        this.andenPrio1 = andenPrio1;
    }

    @Override
    public Fag getAndenPrio2() {
        return andenPrio2;
    }

    @Override
    public void setAndenPrio2(Fag andenPrio2) {
        this.andenPrio2 = andenPrio2;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     *
     * @param til
     */
    @Override
    public void setTilfredshed(int til){
        tilfredshed = til;
    }
    @Override
    public int getTilfredshed(){
        return tilfredshed;
    }
    

    
}
