package org.rd.developpement.accumulate;

import java.util.Set;

public enum IndicateurCompatibleReferenceFactory {
    INSTANCE;

    public IndicateurCompatibleReference create(String indicateurId, String referenceId, Set<String> referenceChoix, String critere) {
        return referenceId.isBlank() ?
            new RemoveIndicateurCompatibleReference(indicateurId) :
            new AddIndicateurCompatibleReference(indicateurId, referenceId, referenceChoix, critere);
    }
}
