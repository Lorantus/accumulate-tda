package org.rd.developpement.accumulate;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class IndicateurCommunAccumulator {
    private final Set<IndicateurCommun> indicateurToPut = new HashSet<>();
    private final Set<ChoixCommun> choixCommunToPut = new HashSet<>();
    private final Set<String> indicateurToRemove = new HashSet<>();

    private final Consumer<Set<IndicateurCommun>> addIndicateurCommun;
    private final Consumer<Set<String>> removeIndicateurCommun;
    private final Consumer<Set<ChoixCommun>> addChoixCommun;

    public IndicateurCommunAccumulator(Consumer<Set<IndicateurCommun>> addIndicateurCommun,
                                       Consumer<Set<String>> removeIndicateurCommun,
                                       Consumer<Set<ChoixCommun>> addChoixCommun) {
        this.addIndicateurCommun = addIndicateurCommun;
        this.removeIndicateurCommun = removeIndicateurCommun;
        this.addChoixCommun = addChoixCommun;
    }

    public void add(Memo memo) {
        memo.allocate(indicateurToPut, choixCommunToPut);
    }

    public void remove(Memo memo) {
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
