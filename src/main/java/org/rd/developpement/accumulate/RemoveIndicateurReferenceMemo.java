package org.rd.developpement.accumulate;

import java.util.Set;

class RemoveIndicateurReferenceMemo implements Memo {
    private final String indicateurId;

    public RemoveIndicateurReferenceMemo(String indicateurId) {
        this.indicateurId = indicateurId;
    }

    @Override
    public void allocate(Set<IndicateurCommun> indicateurToPut, Set<ChoixCommun> addChoixCommun) {
    }

    @Override
    public void release(Set<String> indicateurToRemove) {
        indicateurToRemove.add(indicateurId);
    }
}
