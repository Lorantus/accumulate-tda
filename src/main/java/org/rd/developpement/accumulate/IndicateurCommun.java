package org.rd.developpement.accumulate;

public class IndicateurCommun {
    private final String indicateur;
    private final String reference;

    IndicateurCommun(String indicateur, String reference) {
        this.indicateur = indicateur;
        this.reference = reference;
    }

    public String getIndicateur() {
        return indicateur;
    }

    public String getReference() {
        return reference;
    }
}
