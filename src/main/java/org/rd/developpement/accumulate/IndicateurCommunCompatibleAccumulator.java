package org.rd.developpement.accumulate;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class IndicateurCommunCompatibleAccumulator {
    private final Set<IndicateurCommunCompatible> indicateurToPut = new HashSet<>();
    private final Set<ChoixCommun> choixCommunToPut = new HashSet<>();
    private final Set<String> indicateurToRemove = new HashSet<>();

    private final Consumer<Set<IndicateurCommunCompatible>> addIndicateurCommun;
    private final Consumer<Set<String>> removeIndicateurCommun;
    private final Consumer<Set<ChoixCommun>> addChoixCommun;

    public IndicateurCommunCompatibleAccumulator(Consumer<Set<IndicateurCommunCompatible>> addIndicateurCommun,
                                                 Consumer<Set<String>> removeIndicateurCommun,
                                                 Consumer<Set<ChoixCommun>> addChoixCommun) {
        this.addIndicateurCommun = addIndicateurCommun;
        this.removeIndicateurCommun = removeIndicateurCommun;
        this.addChoixCommun = addChoixCommun;
    }

    public void add(IndicateurCommunCompatibleMemo memo) {
        memo.allocate(indicateurToPut, choixCommunToPut);
    }

    public void remove(IndicateurCommunCompatibleMemo memo) {
        memo.release(indicateurToRemove);
    }

    public void metAJour() {
        if(!indicateurToPut.isEmpty()) {
            addIndicateurCommun.accept(indicateurToPut);
            addChoixCommun.accept(choixCommunToPut);
        }
        if(!indicateurToRemove.isEmpty()) {
            removeIndicateurCommun.accept(indicateurToRemove);
        }
    }
}
