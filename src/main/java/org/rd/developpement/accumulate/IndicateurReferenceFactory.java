package org.rd.developpement.accumulate;

import java.util.Set;

public enum IndicateurReferenceFactory {
    INSTANCE;

    public IndicateurReference create(String indicateurId, String referenceId, Set<String> referenceChoix, String critere) {
        return referenceId.isBlank() ?
            new RemoveIndicateurReference(indicateurId) :
            new AddIndicateurReference(indicateurId, referenceId, referenceChoix, critere);
    }
}
