package classes;

import interfaces.IElev;
import interfaces.TilfredshedInterface;
import java.util.Collection;

public class Tilfredshed implements TilfredshedInterface {

    @Override
    public void udregnTilfredshed(Collection<IElev> elever, Collection<Fag> poolA, Collection<Fag> poolB) {
        for(Fag f : poolA){
            System.out.println("A " + f.getName());
        }
        for(Fag f1 : poolB){
            System.out.println("B " + f1.getName());
        }
        int poolAFag[] = new int[4];
        int poolBFag[] = new int[4];
        int rank = 0;


        for (IElev e : elever) {

            poolAFag = new int[4];
            poolBFag = new int[4];

            for (Fag f : poolA) {
                if (e.getForstePrio1().getName().equals(f.getName())) {
                    poolAFag[0] = 1;
                } else if (e.getForstePrio2().getName().equals(f.getName())) {
                    poolAFag[1] = 1;
                } else if (e.getAndenPrio1().getName().equals(f.getName())) {
                    poolAFag[2] = 1;
                } else if (e.getAndenPrio2().getName().equals(f.getName())) {
                    poolAFag[3] = 1;

                }
            }

            for (Fag f : poolB) {
                if (e.getForstePrio1().getName().equals(f.getName())) {
                    poolBFag[0] = 1;
                } else if (e.getForstePrio2().getName().equals(f.getName())) {
                    poolBFag[1] = 1;
                } else if (e.getAndenPrio1().getName().equals(f.getName())) {
                    poolBFag[2] = 1;
                } else if (e.getAndenPrio2().getName().equals(f.getName())) {
                    poolBFag[3] = 1;

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


/*           if (!(poolA.contains(elev.getForstePrio1()) || poolA.contains(elev.getForstePrio2())
                    || poolA.contains(elev.getAndenPrio1()) || poolA.contains(elev.getAndenPrio2()))
                    || !(poolB.contains(elev.getForstePrio1()) || poolB.contains(elev.getForstePrio2())
                    || poolB.contains(elev.getAndenPrio1()) || poolB.contains(elev.getAndenPrio2()))) {
                elev.setTilfredshed(1);
            } else if ((poolA.contains(elev.getForstePrio1()) || poolA.contains(elev.getForstePrio2()))
                    && (poolB.contains(elev.getForstePrio1()) || poolB.contains(elev.getForstePrio2()))) {
                elev.setTilfredshed(4);
            } else if ((poolA.contains(elev.getForstePrio1()) || poolA.contains(elev.getForstePrio2())
                    && poolB.contains(elev.getAndenPrio1()) || poolB.contains(elev.getAndenPrio2()))
                    || (poolB.contains(elev.getForstePrio1()) || poolB.contains(elev.getForstePrio2())
                    && poolA.contains(elev.getAndenPrio1()) || poolA.contains(elev.getAndenPrio2()))) {
                elev.setTilfredshed(3);
            } else if ((poolA.contains(elev.getAndenPrio1()) || poolA.contains(elev.getAndenPrio2()))
                    && (poolB.contains(elev.getAndenPrio1()) || poolB.contains(elev.getAndenPrio2()))) {
                elev.setTilfredshed(2);
            }*/
        }
    }
}
