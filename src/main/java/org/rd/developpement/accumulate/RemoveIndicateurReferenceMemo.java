package org.rd.developpement.accumulate;

import java.util.Set;

class RemoveIndicateurReferenceMemo implements IndicateurCommunMemo {
    private final String indicateur;

    public RemoveIndicateurReferenceMemo(String indicateur) {
        this.indicateur = indicateur;
    }

    @Override
    public void allocate(Set<IndicateurCommun> indicateurToPut, Set<ChoixCommun> addChoixCommun) {
    }

    @Override
    public void release(Set<String> indicateurToRemove) {
        indicateurToRemove.add(indicateur);
    }
}
