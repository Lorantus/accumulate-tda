package org.rd.developpement.accumulate;

public class IndicateurCommunCompatible {
    private final IndicateurCommun indicateurCommun;
    private final String critere;

    IndicateurCommunCompatible(String indicateur, String reference, String critere) {
        this.indicateurCommun = new IndicateurCommun(indicateur, reference);
        this.critere = critere;
    }

    public String getIndicateur() {
        return indicateurCommun.getIndicateur();
    }

    public String getReference() {
        return indicateurCommun.getReference();
    }

    public String getCritere() {
        return critere;
    }
}
