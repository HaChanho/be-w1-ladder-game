package ladder.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameInfoScanner {
    private static final String SEPARATOR = ",";

    Scanner scanner = new Scanner(System.in);

    public List<String> getUserInfo() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] users = scanner.nextLine().split(SEPARATOR);

        if (!ValidationChecker.checkUserNames(users)) {
            return getUserInfo();
        }
        return Arrays.asList(users);
    }

    public List<String> getResults(List<String> userList) {
        System.out.println("실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)");
        String[] results = scanner.nextLine().split(SEPARATOR);
        List<String> resultList = Arrays.asList(results);

        if (!ValidationChecker.checkGameResults(userList, resultList)) {
            return getResults(userList);
        }

        return Arrays.asList(results);
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
