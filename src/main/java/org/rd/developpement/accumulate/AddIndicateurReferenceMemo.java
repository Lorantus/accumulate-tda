package org.rd.developpement.accumulate;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

class AddIndicateurReferenceMemo implements IndicateurCommunMemo {
    private final String indicateur;
    private final String reference;
    private final Set<String> referenceChoix;

    public AddIndicateurReferenceMemo(String indicateur, String reference, Set<String> referenceChoix) {
        this.indicateur = indicateur;
        this.reference = reference;
        this.referenceChoix = referenceChoix;
    }

    @Override
    public void allocate(Set<IndicateurCommun> indicateurToPut, Set<ChoixCommun> addChoixCommun) {
        indicateurToPut.add(new IndicateurCommun(indicateur, reference));
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
