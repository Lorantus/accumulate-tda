package org.rd.developpement.accumulate;

public class IndicateurCommun {
    private final String indicateurId;
    private final String referenceId;

    IndicateurCommun(String indicateurId, String referenceId) {
        this.indicateurId = indicateurId;
        this.referenceId = referenceId;
    }

    public String getIndicateurId() {
        return indicateurId;
    }

    public String getReferenceId() {
        return referenceId;
    }
}
