package org.rd.developpement.accumulate.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rd.developpement.accumulate.*;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.rd.developpement.accumulate.IndicateurCompatibleReferenceFactory.INDICATEUR_COMPATIBLE_REFERENCE_FACTORY;

class IndicateurCommunCompatibleAccumulatorTest {
    private Set<IndicateurCommunCompatible> addIndicateurCommunCompatibles;
    private Set<String> removeIndicateurCommunCompatibles;

    private Set<IndicateurCommun> addIndicateurCommuns;
    private Set<ChoixCommun> addChoixCommuns;
    private Set<String> removeIndicateurCommuns;

    private ClientIndicateurCommunCompatibleAccumulator accumulator;

    @BeforeEach
    void setUp() {
        addIndicateurCommunCompatibles = new HashSet<>();
        removeIndicateurCommunCompatibles = new HashSet<>();

        addIndicateurCommuns = new HashSet<>();
        addChoixCommuns = new HashSet<>();
        removeIndicateurCommuns = new HashSet<>();

        accumulator = new ClientIndicateurCommunCompatibleAccumulator(
            addIndicateurCommunCompatibles::addAll, removeIndicateurCommunCompatibles::addAll);
        accumulator.setIndicateurCommunAccumulator(
            new ClientIndicateurCommunAccumulator(addIndicateurCommuns::addAll, removeIndicateurCommuns::addAll, addChoixCommuns::addAll));
    }

    @Test
    void ajouteUneReferenceLorsDeLAccumulation() {
        // ARRANGE
        IndicateurCompatibleReference indicateurCompatibleReference = INDICATEUR_COMPATIBLE_REFERENCE_FACTORY.getInstance()
            .create("indicateur", "reference", Set.of("choix", "autre-choix"), "critere");

        indicateurCompatibleReference.accumulate(accumulator);

        // ACT
        accumulator.metAJour();

        // ASSERT
        assertThat(addIndicateurCommunCompatibles)
            .extracting(IndicateurCommunCompatible::getIndicateur, IndicateurCommunCompatible::getReference, IndicateurCommunCompatible::getCritere)
            .containsExactly(tuple("indicateur", "reference", "critere"));

        assertThat(removeIndicateurCommunCompatibles).isEmpty();

        assertThat(addIndicateurCommuns)
            .extracting(IndicateurCommun::getIndicateur, IndicateurCommun::getReference)
            .containsExactly(tuple("indicateur", "reference"));

        assertThat(addChoixCommuns)
            .extracting(ChoixCommun::getIndicateur, ChoixCommun::getChoix, ChoixCommun::getReferenceChoix)
            .containsExactlyInAnyOrder(
                tuple("indicateur", "reference", "choix"),
                tuple("indicateur", "reference", "autre-choix"));

        assertThat(removeIndicateurCommuns).isEmpty();
    }

    @Test
    void supprimeUneReferenceLorsDeLAccumulation() {
        // ARRANGE
        IndicateurCompatibleReference indicateurCompatibleReference = INDICATEUR_COMPATIBLE_REFERENCE_FACTORY
            .create("indicateur", "", Set.of("choix", "autre-choix"), "critere");

        indicateurCompatibleReference.accumulate(accumulator);

        // ACT
        accumulator.metAJour();

        // ASSERT
        assertThat(addIndicateurCommunCompatibles).isEmpty();

        assertThat(removeIndicateurCommunCompatibles)
            .containsExactly("indicateur");

        assertThat(addChoixCommuns).isEmpty();

        assertThat(addIndicateurCommuns).isEmpty();

        assertThat(removeIndicateurCommuns)
            .containsExactly("indicateur");
    }
}