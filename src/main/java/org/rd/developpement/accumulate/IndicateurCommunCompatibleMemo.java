package org.rd.developpement.accumulate;

import java.util.Set;

public interface IndicateurCommunCompatibleMemo {
    void allocate(Set<IndicateurCommunCompatible> indicateurToPut, Set<ChoixCommun> addChoixCommun);

    void release(Set<String> indicateurToRemove);
}
