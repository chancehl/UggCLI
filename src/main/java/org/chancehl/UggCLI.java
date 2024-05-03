package org.chancehl;

import org.chancehl.models.Champion;
import org.chancehl.models.Lane;
import org.chancehl.models.Rank;
import org.chancehl.parsers.LaneParser;
import org.chancehl.parsers.RankParser;
import org.chancehl.utils.BrowserOpener;
import org.chancehl.utils.UggURLBuilder;
import picocli.CommandLine;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Optional;

@CommandLine.Command(name = "ugg", version = "UggCLI 0.1", mixinStandardHelpOptions = true)
public class UggCLI implements Runnable {
    @CommandLine.Parameters(paramLabel = "<championName>", description = "The name of the champion")
    private String championName;

    @CommandLine.Option(names = {"-r", "--rank"}, description = "The rank", converter = RankParser.class)
    private Rank rank;

    @CommandLine.Option(names = {"-l", "--lane"}, description = "The lane", converter = LaneParser.class)
    private Lane lane;

    @Override
    public void run() {
        Champion champion = Champion.builder()
                .name(championName)
                .rank(Optional.ofNullable(rank))
                .lane(Optional.ofNullable(lane))
                .build();

        String url = UggURLBuilder.create(champion);

        try {
            BrowserOpener.open(url);
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new UggCLI()).execute(args);

        System.exit(exitCode);
    }
}

