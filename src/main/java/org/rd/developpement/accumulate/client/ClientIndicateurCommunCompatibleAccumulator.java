package org.rd.developpement.accumulate.client;

import org.rd.developpement.accumulate.IndicateurCommunAccumulator;
import org.rd.developpement.accumulate.IndicateurCommunCompatible;
import org.rd.developpement.accumulate.IndicateurCommunCompatibleAccumulator;
import org.rd.developpement.accumulate.IndicateurCommunCompatibleMemo;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class ClientIndicateurCommunCompatibleAccumulator implements IndicateurCommunCompatibleAccumulator {
    private final Set<IndicateurCommunCompatible> indicateurCommunCompatiblesToPut = new HashSet<>();
    private final Set<String> indicateurToRemove = new HashSet<>();

    private final Consumer<Set<IndicateurCommunCompatible>> addIndicateurCommun;
    private final Consumer<Set<String>> removeIndicateurCommun;

    private IndicateurCommunAccumulator indicateurCommunAccumulator;

    public ClientIndicateurCommunCompatibleAccumulator(Consumer<Set<IndicateurCommunCompatible>> addIndicateurCommun,
                                                       Consumer<Set<String>> removeIndicateurCommun) {
        this.addIndicateurCommun = addIndicateurCommun;
        this.removeIndicateurCommun = removeIndicateurCommun;
    }

    public void setIndicateurCommunAccumulator(IndicateurCommunAccumulator indicateurCommunAccumulator) {
        this.indicateurCommunAccumulator = indicateurCommunAccumulator;
    }

    @Override
    public void add(IndicateurCommunCompatibleMemo memo) {
        memo.allocate(indicateurCommunCompatiblesToPut, indicateurCommunAccumulator);
    }

    @Override
    public void remove(IndicateurCommunCompatibleMemo memo) {
        memo.release(indicateurToRemove, indicateurCommunAccumulator);
    }

    @Override
    public void metAJour() {
        indicateurCommunAccumulator.metAJour();

        if(!indicateurCommunCompatiblesToPut.isEmpty()) {
            addIndicateurCommun.accept(indicateurCommunCompatiblesToPut);
        }
        if(!indicateurToRemove.isEmpty()) {
            removeIndicateurCommun.accept(indicateurToRemove);
        }
    }
}
