package org.rd.developpement.accumulate;

import java.util.Set;

class AddIndicateurCompatibleReference implements IndicateurCompatibleReference {
    private final String indicateur;
    private final String reference;
    private final Set<String> referenceChoix;
    private final String critere;

    AddIndicateurCompatibleReference(String indicateur, String reference, Set<String> referenceChoix, String critere) {
        this.indicateur = indicateur;
        this.reference = reference;
        this.referenceChoix = referenceChoix;
        this.critere = critere;
    }

    @Override
    public void accumulate(IndicateurCommunCompatibleAccumulator accumulator) {
        accumulator.add(new AddIndicateurCompatibleReferenceMemo(indicateur, reference, referenceChoix, critere));
    }
}
