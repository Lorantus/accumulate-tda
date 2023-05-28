package org.rd.developpement.accumulate.client;

import org.rd.developpement.accumulate.ChoixCommun;
import org.rd.developpement.accumulate.IndicateurCommun;
import org.rd.developpement.accumulate.IndicateurCommunAccumulator;
import org.rd.developpement.accumulate.IndicateurCommunMemo;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class ClientIndicateurCommunAccumulator implements IndicateurCommunAccumulator {
    private final Set<IndicateurCommun> indicateurToPut = new HashSet<>();
    private final Set<ChoixCommun> choixCommunToPut = new HashSet<>();
    private final Set<String> indicateurToRemove = new HashSet<>();

    private final Consumer<Set<IndicateurCommun>> addIndicateurCommun;
    private final Consumer<Set<String>> removeIndicateurCommun;
    private final Consumer<Set<ChoixCommun>> addChoixCommun;

    public ClientIndicateurCommunAccumulator(Consumer<Set<IndicateurCommun>> addIndicateurCommun,
                                             Consumer<Set<String>> removeIndicateurCommun,
                                             Consumer<Set<ChoixCommun>> addChoixCommun) {
        this.addIndicateurCommun = addIndicateurCommun;
        this.removeIndicateurCommun = removeIndicateurCommun;
        this.addChoixCommun = addChoixCommun;
    }

    @Override
    public void add(IndicateurCommunMemo indicateurCommunMemo) {
        indicateurCommunMemo.allocate(indicateurToPut, choixCommunToPut);
    }

    @Override
    public void remove(IndicateurCommunMemo indicateurCommunMemo) {
        indicateurCommunMemo.release(indicateurToRemove);
    }

    @Override
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
