package ladder.view;

import java.util.Arrays;
import java.util.List;

import static ladder.LadderGame.MAX_NAME_LENGTH;

public class ValidationChecker {
    static boolean checkUserNames(String[] users) {
        try {
            if (Arrays.stream(users).anyMatch(user -> user.length() > MAX_NAME_LENGTH))
                throw new IllegalArgumentException();
        } catch (IllegalArgumentException iae) {
            System.out.println("이름은 " + MAX_NAME_LENGTH + "글자를 넘어갈 수 없습니다.");
            return false;
        }
        return true;
    }

    static boolean checkGameResults(List<String> userList, List<String> resultList) {
        try {
            if (userList.size() != resultList.size()) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException iae) {
            System.out.println("실행 결과의 수는 참여하는 사람의 수와 같아야 합니다.");
            return false;
        }
        return true;
    }
}
