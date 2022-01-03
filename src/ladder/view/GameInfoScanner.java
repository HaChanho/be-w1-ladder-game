package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static ladder.LadderGame.MAX_NAME_LENGTH;

public class GameInfoScanner {
    private static final String SEPARATOR = ",";

    Scanner scanner = new Scanner(System.in);

    public List<String> getUserInfo() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String[] users = scanner.nextLine().split(SEPARATOR);

            ValidationChecker.checkUserNames(users);

            return Arrays.asList(users);
        } catch (IllegalArgumentException iae) {
            System.out.println("이름은 " + MAX_NAME_LENGTH + "글자를 넘어갈 수 없습니다.");
            return getUserInfo();
        }
    }

    public List<String> getResults(List<String> userList) {
        try {
            System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
            String[] results = scanner.nextLine().split(SEPARATOR);
            List<String> resultList = Arrays.asList(results);

            ValidationChecker.checkGameResults(userList, resultList);

            return Arrays.asList(results);
        } catch (IllegalArgumentException iae) {
            System.out.println("실행 결과의 수는 참여하는 사람의 수와 같아야 합니다.");
            return getResults(userList);
        }
    }

    public int getLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return getPositiveInt();
        } catch (IllegalArgumentException iae) {
            System.out.println("사다리 높이는 양의 정수여야 합니다.");
            return getLadderHeight();
        }
    }

    private int getPositiveInt() {
        int value = scanner.nextInt();
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }
}
