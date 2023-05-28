package org.rd.developpement.accumulate;

public class IndicateurCommunCompatible {
    private final String indicateur;
    private final String reference;
    private final String critere;

    IndicateurCommunCompatible(String indicateur, String reference, String critere) {
        this.indicateur = indicateur;
        this.reference = reference;
        this.critere = critere;
    }

    public String getIndicateur() {
        return indicateur;
    }

    public String getReference() {
        return reference;
    }

    public String getCritere() {
        return critere;
    }
}
