package ladder.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class UserInterfaceTest {
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
        final UserInterface ui = new UserInterface();
        List<String> users = new ArrayList<>() {
            {
                add("TalkServer");
                add("Messaging");
                add("OpenTalk");
                add("Kakao");
            }
        };

        // when
        Runnable c = () -> ui.printUserInfo(users);
        c.run();
        String[] userNames = outputStreamCaptor.toString().split(UserInterface.SPACE);

        // then
        assertThat(Arrays.stream(userNames).allMatch(name -> name.length() <= UserInterface.MAX_NUM_STRING)).isTrue();
    }
}