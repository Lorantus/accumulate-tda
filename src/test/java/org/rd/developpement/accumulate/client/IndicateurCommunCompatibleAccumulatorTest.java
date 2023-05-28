package org.rd.developpement.accumulate.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rd.developpement.accumulate.*;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

class IndicateurCommunCompatibleAccumulatorTest {
    private Set<IndicateurCommunCompatible> indicateurCommunCompatibles;
    private Set<ChoixCommun> addChoixCommun;
    private Set<String> removeIndicateurCommunCompatibles;

    private IndicateurCommunCompatibleAccumulator accumulator;

    @BeforeEach
    void setUp() {
        indicateurCommunCompatibles = new HashSet<>();
        removeIndicateurCommunCompatibles = new HashSet<>();
        addChoixCommun = new HashSet<>();

        accumulator = new IndicateurCommunCompatibleAccumulator(indicateurCommunCompatibles::addAll, removeIndicateurCommunCompatibles::addAll, addChoixCommun::addAll);
    }

    @Test
    void ajouteUneReferenceLorsDeLAccumulation() {
        // ARRANGE
        IndicateurCompatibleReference indicateurCompatibleReference = IndicateurCompatibleReferenceFactory.INSTANCE
            .create("indicateur", "reference", Set.of("choix", "autre-choix"), "critere");

        indicateurCompatibleReference.accumulate(accumulator);

        // ACT
        accumulator.metAJour();

        // ASSERT
        assertThat(indicateurCommunCompatibles)
            .extracting(IndicateurCommunCompatible::getIndicateur, IndicateurCommunCompatible::getReference)
            .containsExactly(tuple("indicateur", "reference"));

        assertThat(addChoixCommun)
            .extracting(ChoixCommun::getIndicateur, ChoixCommun::getChoixId, ChoixCommun::getReferenceChoix)
            .containsExactlyInAnyOrder(
                tuple("indicateur", "reference", "choix"),
                tuple("indicateur", "reference", "autre-choix"));

        assertThat(removeIndicateurCommunCompatibles).isEmpty();
    }

    @Test
    void supprimeUneReferenceLorsDeLAccumulation() {
        // ARRANGE
        IndicateurCompatibleReference indicateurCompatibleReference = IndicateurCompatibleReferenceFactory.INSTANCE
            .create("indicateur", "", Set.of("choix", "autre-choix"), "critere");

        indicateurCompatibleReference.accumulate(accumulator);

        // ACT
        accumulator.metAJour();

        // ASSERT
        assertThat(indicateurCommunCompatibles).isEmpty();

        assertThat(addChoixCommun).isEmpty();

        assertThat(removeIndicateurCommunCompatibles)
            .containsExactly("indicateur");
    }
}