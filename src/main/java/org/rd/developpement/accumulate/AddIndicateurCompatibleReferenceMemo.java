package org.rd.developpement.accumulate;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

class AddIndicateurCompatibleReferenceMemo implements IndicateurCommunCompatibleMemo {
    private final String indicateur;
    private final String reference;
    private final Set<String> referenceChoix;
    private final String critere;

    public AddIndicateurCompatibleReferenceMemo(String indicateur, String reference, Set<String> referenceChoix, String critere) {
        this.indicateur = indicateur;
        this.reference = reference;
        this.referenceChoix = referenceChoix;
        this.critere = critere;
    }

    @Override
    public void allocate(Set<IndicateurCommunCompatible> indicateurToPut, Set<ChoixCommun> addChoixCommun) {
        indicateurToPut.add(new IndicateurCommunCompatible(indicateur, reference, critere));
        Set<ChoixCommun> references = referenceChoix.stream()
            .map(referenceChoix -> new ChoixCommun(indicateur, reference, referenceChoix))
            .collect(toSet());
        addChoixCommun.addAll(references);
    }

    @Override
    public void release(Set<String> indicateurToRemove) {
        indicateurToRemove.add(indicateur);
    }
}
