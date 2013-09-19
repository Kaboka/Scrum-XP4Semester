
package classes;

public class Elev {
    Fag forstePrio1;
    Fag forstePrio2;
    Fag andenPrio1;
    Fag andenPrio2;
    String navn;
    int tilfredshed;
    
    public Elev(String navn){
        this.navn = navn;       
    };

    public Fag getForstePrio1() {
        return forstePrio1;
    }

    public void setForstePrio1(Fag forstePrio1) {
        this.forstePrio1 = forstePrio1;
    }

    public Fag getForstePrio2() {
        return forstePrio2;
    }

    public void setForstePrio2(Fag forstePrio2) {
        this.forstePrio2 = forstePrio2;
    }

    public Fag getAndenPrio1() {
        return andenPrio1;
    }

    public void setAndenPrio1(Fag andenPrio1) {
        this.andenPrio1 = andenPrio1;
    }

    public Fag getAndenPrio2() {
        return andenPrio2;
    }

    public void setAndenPrio2(Fag andenPrio2) {
        this.andenPrio2 = andenPrio2;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }
    
    public void setTilfredshed(int til){
        tilfredshed = til;
    }
    public int getTilfredshed(){
        return tilfredshed;
    }
    

    
}
