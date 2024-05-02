package org.chancehl.utils;

import org.chancehl.models.Champion;

public class UggURLBuilder {
    private static final String BASE_URL = "https://u.gg/lol/champions";

    public static String create(Champion champion) {
        String url = String.format("%s/%s/build", BASE_URL, champion.name);

        if (champion.lane.isPresent()) {
            url += String.format("/%s", champion.lane.get().toString().toLowerCase());
        }

        if (champion.rank.isPresent()) {
            url += String.format("?rank=%s", champion.rank.get().toString().toLowerCase());
        }

        return url;
    }
}
