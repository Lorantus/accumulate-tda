package org.rd.developpement.accumulate;

import java.util.Set;

class AddIndicateurReference implements IndicateurReference {
    private final String indicateur;
    private final String reference;
    private final Set<String> referenceChoix;

    AddIndicateurReference(String indicateur, String reference, Set<String> referenceChoix) {
        this.indicateur = indicateur;
        this.reference = reference;
        this.referenceChoix = referenceChoix;
    }

    @Override
    public void accumulate(IndicateurCommunAccumulator accumulator) {
        accumulator.add(new AddIndicateurReferenceMemo(indicateur, reference, referenceChoix));
    }
}
