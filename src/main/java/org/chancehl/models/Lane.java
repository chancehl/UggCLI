package org.chancehl.models;

public enum Lane {
    BOT,
    TOP,
    MID,
    JUNGLE,
    SUPPORT;

    public static Lane fromString(String value) {
        for (Lane lane : Lane.values()) {
            if (lane.name().equalsIgnoreCase(value)) {
                return lane;
            }
        }
        throw new IllegalArgumentException("Invalid lane value: " + value);
    }
}

