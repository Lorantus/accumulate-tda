package org.rd.developpement.accumulate;

public class ChoixCommun {
    private final String indicateurId;
    private final String choixId;
    private final String referenceChoix;

    ChoixCommun(String indicateurId, String choixId, String referenceChoix) {
        this.indicateurId = indicateurId;
        this.choixId = choixId;
        this.referenceChoix = referenceChoix;
    }

    public String getIndicateurId() {
        return indicateurId;
    }

    public String getChoixId() {
        return choixId;
    }

    public String getReferenceChoix() {
        return referenceChoix;
    }
}
