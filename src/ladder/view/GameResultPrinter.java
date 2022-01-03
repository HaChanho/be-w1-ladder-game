package ladder.view;

import ladder.LadderGame;
import ladder.domain.Ladder;
import ladder.domain.LadderRow;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static ladder.LadderGame.MAX_NAME_LENGTH;
import static ladder.LadderGame.SPACE;

public class GameResultPrinter {
    private static final String PILLAR = "|";
    private static final String EMPTY_BRIDGE = "     ";
    private static final String BRIDGE = "-----";

    private static final String NULL_SPACE = "";
    private static final String EMPTY_SPACE = "  ";
    private static final String NEW_LINE = "\n";

    private static final String END_COMMAND = "춘식이";
    private static final String ALL_COMMAND = "all";

    public void printLadderGame(LadderGame ladderGame, Ladder ladder) {
        System.out.println("\n사다리 결과\n");
        printUserInfo(ladderGame.getUserList());
        printLadder(ladder);
        printResults(ladderGame.getResultList());
    }

    void printUserInfo(List<String> userList) {
        try {
            ValidationChecker.checkUserNames(userList.toArray(String[]::new));
        } catch (IllegalArgumentException iae) {
            userList = userList.stream()
                    .map(user -> user.length() > MAX_NAME_LENGTH ? user.substring(0, MAX_NAME_LENGTH) : user)
                    .collect(Collectors.toList());
        }
        userList.forEach(user -> System.out.printf("%-" + MAX_NAME_LENGTH + "s" + SPACE, user));
        System.out.println();
    }

    void printLadder(Ladder ladder) {
        System.out.println(buildLadder(ladder));
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

    void printResults(List<String> resultList) {
        resultList.forEach(result -> System.out.printf("%-" + MAX_NAME_LENGTH + "s" + SPACE, result));
        System.out.println("\n");
    }

    public boolean printGameResult(Map<String, String> resultMap, String command) {
        if (command.equals(END_COMMAND)) {
            System.out.println("\n게임을 종료합니다.");
            return false;
        } else if (command.equals(ALL_COMMAND)) {
            printResultAll(resultMap);
            return true;
        }

        System.out.println("\n실행 결과\n" + resultMap.getOrDefault(command, "") + "\n");
        return true;
    }

    private void printResultAll(Map<String, String> resultMap) {
        System.out.println("\n실행 결과");
        resultMap.forEach((user, result) -> System.out.println(user + " : " + result));
        System.out.println();
    }
}
