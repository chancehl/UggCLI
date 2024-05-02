package org.chancehl.models;

public enum Rank {
    IRON,
    BRONZE,
    SILVER,
    GOLD,
    PLATINUM,
    EMERALD,
    DIAMOND,
    MASTER,
    GRANDMASTER,
    CHALLENGER,
    OVERALL,
    MASTER_PLUS,
    DIAMOND_2_PLUS,
    DIAMOND_PLUS,
    EMERALD_PLUS,
    PLATINUM_PLUS;

    public static Rank fromString(String value) {
        for (Rank rank : Rank.values()) {
            if (rank.name().equalsIgnoreCase(value)) {
                return rank;
            }
        }
        throw new IllegalArgumentException("Invalid rank value: " + value);
    }
}

