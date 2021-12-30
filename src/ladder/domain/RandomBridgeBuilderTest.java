package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomBridgeBuilderTest {

    @Test
    void getRandomBridge() {
        // given
        final boolean preBridge = RandomBridgeBuilder.preBridge;
        final RandomBridgeBuilder randomBridgeBuilder = new RandomBridgeBuilder();

        // when
        final boolean curBridge = randomBridgeBuilder.getRandomBridge();

        // then
        assertThat(preBridge != curBridge).isTrue();
    }
}