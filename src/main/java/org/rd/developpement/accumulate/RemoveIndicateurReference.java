package org.rd.developpement.accumulate;

class RemoveIndicateurReference implements IndicateurReference {
    private final String indicateur;

    RemoveIndicateurReference(String indicateur) {
        this.indicateur = indicateur;
    }

    @Override
    public void accumulate(IndicateurCommunAccumulator accumulator) {
        accumulator.remove(new RemoveIndicateurReferenceMemo(indicateur));
    }
}
