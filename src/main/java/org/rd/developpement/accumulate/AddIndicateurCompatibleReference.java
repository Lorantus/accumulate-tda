package org.rd.developpement.accumulate;

import java.util.Set;

class AddIndicateurCompatibleReference implements IndicateurCompatibleReference {
    private final String indicateurId;
    private final String referenceId;
    private final Set<String> referenceChoix;
    private final String critere;

    AddIndicateurCompatibleReference(String indicateurId, String referenceId, Set<String> referenceChoix, String critere) {
        this.indicateurId = indicateurId;
        this.referenceId = referenceId;
        this.referenceChoix = referenceChoix;
        this.critere = critere;
    }

    @Override
    public void accumulate(IndicateurCommunCompatibleAccumulator accumulator) {
        accumulator.add(new AddIndicateurCompatibleReferenceMemo(indicateurId, referenceId, referenceChoix, critere));
    }
}
