package org.rd.developpement.accumulate;

class RemoveIndicateurCompatibleReference implements IndicateurCompatibleReference {
    private final String indicateurId;

    RemoveIndicateurCompatibleReference(String indicateurId) {
        this.indicateurId = indicateurId;
    }

    @Override
    public void accumulate(IndicateurCommunCompatibleAccumulator accumulator) {
        accumulator.remove(new RemoveIndicateurCompatibleReferenceMemo(indicateurId));
    }
}
