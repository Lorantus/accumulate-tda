package org.rd.developpement.accumulate;

public interface IndicateurCommunCompatibleAccumulator {
    void add(IndicateurCommunCompatibleMemo memo);

    void remove(IndicateurCommunCompatibleMemo memo);

    void metAJour();
}
