package org.chancehl.parsers;

import org.chancehl.models.Lane;
import picocli.CommandLine;

public class LaneParser implements CommandLine.ITypeConverter<Lane> {
    @Override
    public Lane convert(String s) throws Exception {
        return Lane.fromString(s);
    }
}