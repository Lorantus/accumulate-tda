package org.rd.developpement.accumulate;

import java.util.Set;

import static org.rd.developpement.accumulate.IndicateurReferenceFactory.INDICATEUR_REFERENCE_FACTORY;

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
    public void allocate(Set<IndicateurCommunCompatible> indicateurCompatibleToPut, IndicateurCommunAccumulator indicateurCommunAccumulator) {
        IndicateurReference indicateurReference = INDICATEUR_REFERENCE_FACTORY.create(indicateur, reference, referenceChoix);
        indicateurReference.accumulate(indicateurCommunAccumulator);

        indicateurCompatibleToPut.add(new IndicateurCommunCompatible(indicateur, reference, critere));
    }

    @Override
    public void release(Set<String> indicateurToRemove, IndicateurCommunAccumulator indicateurCommunAccumulator) {
        // Noop
    }
}
