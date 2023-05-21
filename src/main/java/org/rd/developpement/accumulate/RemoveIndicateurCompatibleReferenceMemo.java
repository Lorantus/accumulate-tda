package org.rd.developpement.accumulate;

import java.util.Set;

class RemoveIndicateurCompatibleReferenceMemo implements IndicateurCommunCompatibleMemo {
    private final String indicateurId;

    public RemoveIndicateurCompatibleReferenceMemo(String indicateurId) {
        this.indicateurId = indicateurId;
    }

    @Override
    public void allocate(Set<IndicateurCommunCompatible> indicateurToPut, Set<ChoixCommun> addChoixCommun) {
    }

    @Override
    public void release(Set<String> indicateurToRemove) {
        indicateurToRemove.add(indicateurId);
    }
}
