package org.rd.developpement.accumulate;

import java.util.Set;

public interface IndicateurCommunMemo {
    void allocate(Set<IndicateurCommun> indicateurToPut, Set<ChoixCommun> addChoixCommun);

    void release(Set<String> indicateurToRemove);
}
