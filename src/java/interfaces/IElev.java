/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Fag;

public interface IElev {

    Fag getForstePrio1();

    void setForstePrio1(Fag forstePrio1);

    Fag getForstePrio2();

    void setForstePrio2(Fag forstePrio2);

    Fag getAndenPrio1();

    void setAndenPrio1(Fag andenPrio1);

    Fag getAndenPrio2();

    void setAndenPrio2(Fag andenPrio2);

    String getNavn();

    void setNavn(String navn);
    
    void setTilfredshed(int til);
    
    int getTilfredshed(); 
}
