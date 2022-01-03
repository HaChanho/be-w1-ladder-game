package ladder;

import ladder.domain.GameResult;
import ladder.domain.GameSimulator;
import ladder.domain.Ladder;
import ladder.domain.RandomLadderBuilder;
import ladder.view.CommandScanner;
import ladder.view.GameInfoScanner;
import ladder.view.GameResultPrinter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class LadderGame {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String SPACE = " ";
    private static final String END_COMMAND = "춘식이";
    private static final String ALL_COMMAND = "all";

    private final List<String> userList;
    private final List<String> resultList;

    public LadderGame(List<String> userList, List<String> resultList) {
        this.userList = userList;
        this.resultList = resultList;
    }

    public static void main(String[] args) {
        GameInfoScanner gameInfoScanner = new GameInfoScanner();
        List<String> userList = new ArrayList<>(gameInfoScanner.getUserInfo());
        List<String> resultList = new ArrayList<>(gameInfoScanner.getResults(userList));
        int ladderHeight = gameInfoScanner.getLadderHeight();

        LadderGame ladderGame = new LadderGame(userList, resultList);
        RandomLadderBuilder randomLadderBuilder = new RandomLadderBuilder();
        Ladder ladder = new Ladder(randomLadderBuilder.getRandomLadder(userList.size(), ladderHeight));
        ladderGame.run(ladder);
    }

    private void run(Ladder ladder) {
        GameSimulator gameSimulator = new GameSimulator();
        GameResult gameResult = new GameResult(gameSimulator.getLadderGameResultList(this, ladder));
        GameResultPrinter gameResultPrinter = new GameResultPrinter();
        gameResultPrinter.printLadderGame(this, ladder);

        boolean continued = true;
        while (continued) {
            continued = processCommand(gameResultPrinter, gameResult);
        }
        gameResultPrinter.printGameEnd();
    }

    private boolean processCommand(GameResultPrinter gameResultPrinter, GameResult gameResult) {
        String command = new CommandScanner().getCommand();
        if (isEndCommand(command)) {
            return false;
        }
        System.out.println("\n실행 결과");
        if (isAllCommand(command)) {
            gameResultPrinter.printResultAll(userList, gameResult);
            return true;
        }

        gameResultPrinter.printResultOne(userList, gameResult, command);
        return true;
    }

    private boolean isEndCommand(String command) {
        return command.equals(END_COMMAND);
    }

    private boolean isAllCommand(String command) {
        return command.equals(ALL_COMMAND);
    }

    public List<String> getUserList() {
        return Collections.unmodifiableList(userList);
    }

    public List<String> getResultList() {
        return Collections.unmodifiableList(resultList);
    }
}
