package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Ladder {
    private static final int WIDTH_CORRECTION = 1;

    private final List<LadderRow> bridges;

    public Ladder(int numPeople, int ladderHeight) {
        RandomBridgeBuilder randomBridgeBuilder = new RandomBridgeBuilder();
        bridges = Stream.generate(() -> new LadderRow(randomBridgeBuilder.getRandomLadderRow(numPeople - WIDTH_CORRECTION)))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    public List<LadderRow> getLadder() {
        return bridges;
    }
}
