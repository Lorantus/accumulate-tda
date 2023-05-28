package org.rd.developpement.accumulate;

import java.util.Set;

public enum IndicateurReferenceFactory {
    INDICATEUR_REFERENCE_FACTORY;

    public IndicateurReference create(String indicateur, String reference, Set<String> referenceChoix) {
        return reference.isBlank() ?
            new RemoveIndicateurReference(indicateur) :
            new AddIndicateurReference(indicateur, reference, referenceChoix);
    }
}
