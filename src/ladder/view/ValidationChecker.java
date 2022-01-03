package ladder.view;

import java.util.Arrays;
import java.util.List;

import static ladder.LadderGame.MAX_NAME_LENGTH;

public class ValidationChecker {
    static void checkUserNames(String[] users) {
        if (Arrays.stream(users).anyMatch(user -> user.length() > MAX_NAME_LENGTH))
            throw new IllegalArgumentException();
    }

    static void checkGameResults(List<String> userList, List<String> resultList) {
        if (userList.size() != resultList.size()) {
            throw new IllegalArgumentException();
        }
    }
}
