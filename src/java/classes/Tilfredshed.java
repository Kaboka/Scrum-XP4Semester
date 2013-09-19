package classes;

import interfaces.IElev;
import interfaces.TilfredshedInterface;
import java.util.Collection;


public class Tilfredshed implements TilfredshedInterface{

    
    @Override
    public void udregnTilfredshed(Collection<IElev> elever, Collection<Fag> poolA, Collection<Fag> poolB) {
        for(IElev elev : elever){
            if(!(poolA.contains(elev.getForstePrio1()) || poolA.contains(elev.getForstePrio2()) || 
                    poolA.contains(elev.getAndenPrio1()) || poolA.contains(elev.getAndenPrio2()))
                    || !(poolB.contains(elev.getForstePrio1()) || poolB.contains(elev.getForstePrio2()) || 
                    poolB.contains(elev.getAndenPrio1()) || poolB.contains(elev.getAndenPrio2()))){
                elev.setTilfredshed(1);
            }else if((poolA.contains(elev.getForstePrio1()) || poolA.contains(elev.getForstePrio2()))
                    && (poolB.contains(elev.getForstePrio1()) || poolB.contains(elev.getForstePrio2()))){
                elev.setTilfredshed(4);
            }else if((poolA.contains(elev.getForstePrio1()) || poolA.contains(elev.getForstePrio2()) && 
                    poolB.contains(elev.getAndenPrio1()) || poolB.contains(elev.getAndenPrio2()))
                    || (poolB.contains(elev.getForstePrio1()) || poolB.contains(elev.getForstePrio2()) && 
                    poolA.contains(elev.getAndenPrio1()) || poolA.contains(elev.getAndenPrio2()))){
                elev.setTilfredshed(3);
            }else if((poolA.contains(elev.getAndenPrio1()) || poolA.contains(elev.getAndenPrio2())) && 
                    (poolB.contains(elev.getAndenPrio1()) || poolB.contains(elev.getAndenPrio2()))){
                elev.setTilfredshed(2);
            }
        }
    }
    
}
