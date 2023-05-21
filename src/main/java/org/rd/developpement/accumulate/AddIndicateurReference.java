package org.rd.developpement.accumulate;

import java.util.Set;

class AddIndicateurReference implements IndicateurReference {
    private final String indicateurId;
    private final String referenceId;
    private final Set<String> referenceChoix;

    AddIndicateurReference(String indicateurId, String referenceId, Set<String> referenceChoix) {
        this.indicateurId = indicateurId;
        this.referenceId = referenceId;
        this.referenceChoix = referenceChoix;
    }

    @Override
    public void accumulate(IndicateurCommunAccumulator accumulator) {
        accumulator.add(new AddIndicateurReferenceMemo(indicateurId, referenceId, referenceChoix));
    }
}
