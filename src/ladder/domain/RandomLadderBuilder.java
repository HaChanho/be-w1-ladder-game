package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomLadderBuilder {
    private static final int WIDTH_CORRECTION = 1;
    private static boolean preBridge = false;

    boolean getPreBridge() {
        return preBridge;
    }

    public List<LadderRow> getRandomLadder(int numPeople, int ladderHeight) {
        return Stream.generate(() -> new LadderRow(getRandomLadderRow(numPeople - WIDTH_CORRECTION)))
                .limit(ladderHeight)
                .collect(Collectors.toList());
    }

    List<Boolean> getRandomLadderRow(int width) {
        return Stream.generate(this::getRandomBridge)
                .limit(width)
                .collect(Collectors.toList());
    }

    synchronized boolean getRandomBridge() {
        final Random random = new Random();
        preBridge = !preBridge && random.nextBoolean();
        return preBridge;
    }
}
