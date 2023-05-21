package org.rd.developpement.accumulate;

import java.util.Set;

import static java.util.stream.Collectors.toSet;

class AddIndicateurReferenceMemo implements Memo {
    private final String indicateurId;
    private final String referenceId;
    private final Set<String> referenceChoix;
    private final String critere;

    public AddIndicateurReferenceMemo(String indicateurId, String referenceId, Set<String> referenceChoix, String critere) {
        this.indicateurId = indicateurId;
        this.referenceId = referenceId;
        this.referenceChoix = referenceChoix;
        this.critere = critere;
    }

    @Override
    public void allocate(Set<IndicateurCommun> indicateurToPut, Set<ChoixCommun> addChoixCommun) {
        indicateurToPut.add(new IndicateurCommun(indicateurId, referenceId, critere));
        Set<ChoixCommun> references = referenceChoix.stream()
            .map(referenceChoix -> new ChoixCommun(indicateurId, referenceId, referenceChoix))
            .collect(toSet());
        addChoixCommun.addAll(references);
    }

    @Override
    public void release(Set<String> indicateurToRemove) {
        indicateurToRemove.add(indicateurId);
    }
}
