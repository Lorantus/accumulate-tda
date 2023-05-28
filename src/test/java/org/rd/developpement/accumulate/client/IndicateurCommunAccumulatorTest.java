package org.rd.developpement.accumulate.client;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rd.developpement.accumulate.*;
import org.rd.developpement.accumulate.ChoixCommun;
import org.rd.developpement.accumulate.IndicateurCommun;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;
import static org.rd.developpement.accumulate.IndicateurReferenceFactory.INDICATEUR_REFERENCE_FACTORY;

class IndicateurCommunAccumulatorTest {
    private Set<IndicateurCommun> addIndicateurCommun;
    private Set<ChoixCommun> addChoixCommun;
    private Set<String> removeIndicateurCommun;

    private IndicateurCommunAccumulator accumulator;

    @BeforeEach
    void setUp() {
        addIndicateurCommun = new HashSet<>();
        removeIndicateurCommun = new HashSet<>();
        addChoixCommun = new HashSet<>();

        accumulator = new ClientIndicateurCommunAccumulator(addIndicateurCommun::addAll, removeIndicateurCommun::addAll, addChoixCommun::addAll);
    }

    @Test
    void ajouteUneReferenceLorsDeLAccumulation() {
        // ARRANGE
        IndicateurReference indicateurReference = INDICATEUR_REFERENCE_FACTORY
            .create("indicateur", "reference", Set.of("choix", "autre-choix"));

        indicateurReference.accumulate(accumulator);

        // ACT
        accumulator.metAJour();

        // ASSERT
        assertThat(addIndicateurCommun)
            .extracting(IndicateurCommun::getIndicateur, IndicateurCommun::getReference)
            .containsExactly(tuple("indicateur", "reference"));

        assertThat(addChoixCommun)
            .extracting(ChoixCommun::getIndicateur, ChoixCommun::getChoix, ChoixCommun::getReferenceChoix)
            .containsExactlyInAnyOrder(
                tuple("indicateur", "reference", "choix"),
                tuple("indicateur", "reference", "autre-choix"));

        assertThat(removeIndicateurCommun).isEmpty();
    }

    @Test
    void supprimeUneReferenceLorsDeLAccumulation() {
        // ARRANGE
        IndicateurReference indicateurReference = INDICATEUR_REFERENCE_FACTORY
            .create("indicateur", "", Set.of("choix", "autre-choix"));

        indicateurReference.accumulate(accumulator);

        // ACT
        accumulator.metAJour();

        // ASSERT
        assertThat(addIndicateurCommun).isEmpty();

        assertThat(addChoixCommun).isEmpty();

        assertThat(removeIndicateurCommun)
            .containsExactly("indicateur");
    }
}