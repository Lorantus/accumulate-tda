package org.rd.developpement.accumulate;

public interface IndicateurCommunAccumulator {
    void add(IndicateurCommunMemo indicateurCommunMemo);

    void remove(IndicateurCommunMemo indicateurCommunMemo);

    void metAJour();
}
