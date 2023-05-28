package org.rd.developpement.accumulate;

import java.util.Set;

public enum IndicateurCompatibleReferenceFactory {
    INDICATEUR_COMPATIBLE_REFERENCE_FACTORY;

    public IndicateurCompatibleReferenceFactory getInstance() {
        return INDICATEUR_COMPATIBLE_REFERENCE_FACTORY;
    }

    public IndicateurCompatibleReference create(String indicateur, String reference, Set<String> referenceChoix, String critere) {
        return reference.isBlank() ?
            new RemoveIndicateurCompatibleReference(indicateur) :
            new AddIndicateurCompatibleReference(indicateur, reference, referenceChoix, critere);
    }
}
