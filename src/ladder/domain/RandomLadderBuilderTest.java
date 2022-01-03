package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomLadderBuilderTest {

    @Test
    void getRandomBridge() {
        // given
        final RandomLadderBuilder randomBridgeBuilder = new RandomLadderBuilder();
        final boolean preBridge = randomBridgeBuilder.getPreBridge();

        // when
        final boolean curBridge = randomBridgeBuilder.getRandomBridge();

        // then
        assertThat(preBridge != curBridge).isTrue();
    }
}