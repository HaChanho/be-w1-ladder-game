package ladder.view;

import ladder.domain.Ladder;
import ladder.domain.LadderRow;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UserInterface {
    static final int MAX_NUM_STRING = 5;
    static final String SPACE = " ";

    private static final String SEPARATOR = ",";

    private static final String PILLAR = "|";
    private static final String EMPTY_BRIDGE = "     ";
    private static final String BRIDGE = "-----";
    
    private static final String NULL_SPACE = "";
    private static final String EMPTY_SPACE = "  ";
    private static final String NEW_LINE = "\n";

    Scanner scanner = new Scanner(System.in);

    public List<String> getUserInfoFromScanner() {
        try {
            System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
            String[] users = scanner.nextLine().split(SEPARATOR);

            checkUserNames(users);

            return Arrays.asList(users);
        } catch (IllegalArgumentException iae) {
            System.out.println("이름은 " + MAX_NUM_STRING + "글자를 넘어갈 수 없습니다.");
            return getUserInfoFromScanner();
        }
    }

    private void checkUserNames(String[] users) {
        if (Arrays.stream(users).anyMatch(user -> user.length() > MAX_NUM_STRING))
            throw new IllegalArgumentException();
    }

    public int getLadderHeight() {
        try {
            System.out.println("최대 사다리 높이는 몇 개인가요?");
            return getPositiveIntFromScanner();
        } catch (IllegalArgumentException iae) {
            System.out.println("사다리 높이는 양의 정수여야 합니다.");
            return getLadderHeight();
        }
    }

    private int getPositiveIntFromScanner() {
        int value = scanner.nextInt();
        if (value <= 0) {
            throw new IllegalArgumentException();
        }
        return value;
    }

    public void printLadderGame(List<String> userList, Ladder ladder) {
        printUserInfo(userList);
        System.out.println();
        System.out.println(buildLadder(ladder));
    }

    void printUserInfo(List<String> userList) {
        try {
            checkUserNames(userList.toArray(String[]::new));
        } catch (IllegalArgumentException iae) {
            userList = userList.stream()
                    .map(user -> user.length() > MAX_NUM_STRING ? user.substring(0, MAX_NUM_STRING) : user)
                    .collect(Collectors.toList());
        }
        userList.forEach(user -> System.out.printf("%-" + MAX_NUM_STRING + "s" + SPACE, user));
    }

    private String buildLadder(Ladder ladder) {
        return ladder.getLadder().stream()
                .map(this::buildLadderRow)
                .collect(Collectors.joining(NEW_LINE + EMPTY_SPACE, EMPTY_SPACE, NULL_SPACE));
    }

    private String buildLadderRow(LadderRow ladderRow) {
        return ladderRow.getLadderRow().stream()
                .map(bridge -> bridge ? BRIDGE : EMPTY_BRIDGE)
                .collect(Collectors.joining(PILLAR, PILLAR, PILLAR));
    }
}
