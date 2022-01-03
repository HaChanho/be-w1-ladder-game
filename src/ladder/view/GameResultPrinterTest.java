package ladder.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static ladder.LadderGame.MAX_NAME_LENGTH;
import static ladder.LadderGame.SPACE;
import static org.assertj.core.api.Assertions.assertThat;

class GameResultPrinterTest {
    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void printUserInfo() {
        // given
        final GameResultPrinter gameResultPrinter = new GameResultPrinter();
        List<String> users = new ArrayList<>() {
            {
                add("TalkServer");
                add("Messaging");
                add("OpenTalk");
                add("Kakao");
            }
        };

        // when
        Runnable c = () -> gameResultPrinter.printUserInfo(users);
        c.run();
        String[] userNames = outputStreamCaptor.toString().split(SPACE);

        // then
        assertThat(Arrays.stream(userNames).allMatch(name -> name.length() <= MAX_NAME_LENGTH)).isTrue();
    }
}