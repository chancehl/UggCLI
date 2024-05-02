package org.chancehl.models;

import lombok.Builder;

import java.util.Optional;

@Builder
public class Champion {
    public String name;

    public Optional<Rank> rank;

    public Optional<Lane> lane;
}
