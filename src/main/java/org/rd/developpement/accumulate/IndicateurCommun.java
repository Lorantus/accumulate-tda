package org.rd.developpement.accumulate;

public class IndicateurCommun {
    private final String indicateur;
    private final String reference;

    IndicateurCommun(String indicateur, String reference) {
        this.indicateur = indicateur;
        this.reference = reference;
    }

    // Test only
    public String getIndicateur() {
        return indicateur;
    }

    // Test only
    public String getReference() {
        return reference;
    }
}
