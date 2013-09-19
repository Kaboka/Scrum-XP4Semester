/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import classes.Elev;
import classes.Fag;
import java.util.Collection;

public interface TilfredshedInterface {
    public void udregnTilfredshed(Collection<Elev> elever, Collection<Fag> poolA, Collection<Fag> poolB);
}
