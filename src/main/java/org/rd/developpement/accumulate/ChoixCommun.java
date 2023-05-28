package org.rd.developpement.accumulate;

public class ChoixCommun {
    private final String indicateur;
    private final String choixId;
    private final String referenceChoix;

    ChoixCommun(String indicateur, String choixId, String referenceChoix) {
        this.indicateur = indicateur;
        this.choixId = choixId;
        this.referenceChoix = referenceChoix;
    }

    public String getIndicateur() {
        return indicateur;
    }

    public String getChoixId() {
        return choixId;
    }

    public String getReferenceChoix() {
        return referenceChoix;
    }
}
