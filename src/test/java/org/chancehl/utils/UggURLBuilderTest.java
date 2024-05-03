package org.chancehl.utils;


import org.chancehl.models.Champion;
import org.chancehl.models.Lane;
import org.chancehl.models.Rank;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class UggURLBuilderTest {
    @Test
    public void testCreateURL_NoRankNoLane() {
        Champion champion = Champion.builder()
                .name("Aatrox")
                .rank(Optional.empty())
                .lane(Optional.empty())
                .build();
        String expected = "https://u.gg/lol/champions/Aatrox/build";
        assertEquals(expected, UggURLBuilder.create(champion));
    }

    @Test
    public void testCreateURL_WithRankNoLane() {
        Champion champion = Champion.builder()
                .name("Aatrox")
                .rank(Optional.of(Rank.DIAMOND))
                .lane(Optional.empty())
                .build();
        String expected = "https://u.gg/lol/champions/Aatrox/build?rank=diamond";
        assertEquals(expected, UggURLBuilder.create(champion));
    }

    @Test
    public void testCreateURL_NoRankWithLane() {
        Champion champion = Champion.builder()
                .name("Aatrox")
                .rank(Optional.empty())
                .lane(Optional.of(Lane.TOP))
                .build();
        String expected = "https://u.gg/lol/champions/Aatrox/build/top";
        assertEquals(expected, UggURLBuilder.create(champion));
    }

    @Test
    public void testCreateURL_WithRankWithLane() {
        Champion champion = Champion.builder()
                .name("Aatrox")
                .rank(Optional.of(Rank.DIAMOND))
                .lane(Optional.of(Lane.TOP))
                .build();
        String expected = "https://u.gg/lol/champions/Aatrox/build/top?rank=diamond";
        assertEquals(expected, UggURLBuilder.create(champion));
    }
}
