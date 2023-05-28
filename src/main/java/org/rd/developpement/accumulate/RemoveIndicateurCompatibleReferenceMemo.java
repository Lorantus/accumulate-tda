package org.rd.developpement.accumulate;

import java.util.Set;

class RemoveIndicateurCompatibleReferenceMemo implements IndicateurCommunCompatibleMemo {
    private final String indicateur;

    public RemoveIndicateurCompatibleReferenceMemo(String indicateur) {
        this.indicateur = indicateur;
    }

    @Override
    public void allocate(Set<IndicateurCommunCompatible> indicateurToPut, Set<ChoixCommun> addChoixCommun) {
    }

    @Override
    public void release(Set<String> indicateurToRemove) {
        indicateurToRemove.add(indicateur);
    }
}
