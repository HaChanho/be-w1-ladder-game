package ladder.domain;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RandomBridgeBuilder {
    static boolean preBridge = false;

    public List<Boolean> getRandomLadderRow(int width) {
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
