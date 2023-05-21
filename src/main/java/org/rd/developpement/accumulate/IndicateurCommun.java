package org.rd.developpement.accumulate;

public class IndicateurCommun {
    private final String indicateurId;
    private final String referenceId;
    private final String critere;

    IndicateurCommun(String indicateurId, String referenceId, String critere) {
        this.indicateurId = indicateurId;
        this.referenceId = referenceId;
        this.critere = critere;
    }

    public String getIndicateurId() {
        return indicateurId;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public String getCritere() {
        return critere;
    }
}
