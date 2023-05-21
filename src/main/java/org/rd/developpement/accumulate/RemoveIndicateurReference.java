package org.rd.developpement.accumulate;

class RemoveIndicateurReference implements IndicateurReference {
    private final String indicateurId;

    RemoveIndicateurReference(String indicateurId) {
        this.indicateurId = indicateurId;
    }

    @Override
    public void accumulate(IndicateurCommunAccumulator accumulator) {
        accumulator.remove(new RemoveIndicateurReferenceMemo(indicateurId));
    }
}
