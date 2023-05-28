package org.rd.developpement.accumulate;

class RemoveIndicateurCompatibleReference implements IndicateurCompatibleReference {
    private final String indicateur;

    RemoveIndicateurCompatibleReference(String indicateur) {
        this.indicateur = indicateur;
    }

    @Override
    public void accumulate(IndicateurCommunCompatibleAccumulator accumulator) {
        accumulator.remove(new RemoveIndicateurCompatibleReferenceMemo(indicateur));
    }
}
