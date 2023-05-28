package org.rd.developpement.accumulate;

public class ChoixCommun {
    private final String indicateur;
    private final String choix;
    private final String referenceChoix;

    ChoixCommun(String indicateur, String choix, String referenceChoix) {
        this.indicateur = indicateur;
        this.choix = choix;
        this.referenceChoix = referenceChoix;
    }

    // Test only
    public String getIndicateur() {
        return indicateur;
    }

    // Test only
    public String getChoix() {
        return choix;
    }

    // Test only
    public String getReferenceChoix() {
        return referenceChoix;
    }
}
