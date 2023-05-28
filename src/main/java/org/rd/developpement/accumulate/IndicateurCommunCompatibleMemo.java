package org.rd.developpement.accumulate;

import java.util.Set;

public interface IndicateurCommunCompatibleMemo {
    void allocate(Set<IndicateurCommunCompatible> indicateurToPut, IndicateurCommunAccumulator indicateurCommunAccumulator);

    void release(Set<String> indicateurToRemove, IndicateurCommunAccumulator indicateurCommunAccumulator);
}
