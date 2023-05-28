package org.rd.developpement.accumulate;

import java.util.Set;

class RemoveIndicateurCompatibleReferenceMemo implements IndicateurCommunCompatibleMemo {
    private final String indicateur;

    public RemoveIndicateurCompatibleReferenceMemo(String indicateur) {
        this.indicateur = indicateur;
    }

    @Override
    public void allocate(Set<IndicateurCommunCompatible> indicateurToPut, IndicateurCommunAccumulator indicateurCommunAccumulator) {
        // Noop
    }

    @Override
    public void release(Set<String> indicateurToRemove, IndicateurCommunAccumulator indicateurCommunAccumulator) {
        IndicateurCommunMemo indicateurCommunMemo = new RemoveIndicateurReferenceMemo(indicateur);
        indicateurCommunAccumulator.remove(indicateurCommunMemo);
        indicateurToRemove.add(indicateur);
    }
}
