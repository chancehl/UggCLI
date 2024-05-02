package org.chancehl.parsers;

import org.chancehl.models.Rank;
import picocli.CommandLine;

public class RankParser implements CommandLine.ITypeConverter<Rank> {
    @Override
    public Rank convert(String s) throws Exception {
        return Rank.fromString(s);
    }
}
