package ladder;

import ladder.domain.GameSimulator;
import ladder.domain.Ladder;
import ladder.domain.RandomLadderBuilder;
import ladder.view.CommandScanner;
import ladder.view.GameInfoScanner;
import ladder.view.GameResultPrinter;

import java.util.*;

public class LadderGame {
    public static final int MAX_NAME_LENGTH = 5;
    public static final String SPACE = " ";

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
        GameSimulator gameSimulator = new GameSimulator(ladder);
        Map<String, String> resultMap = gameSimulator.getLadderResultMap(userList, resultList);
        GameResultPrinter gameResultPrinter = new GameResultPrinter();
        gameResultPrinter.printLadderGame(this, ladder);

        boolean continued = true;
        while (continued) {
            CommandScanner commandScanner = new CommandScanner();
            String command = commandScanner.getCommand();
            continued = gameResultPrinter.printGameResult(resultMap, command);
        }
    }

    public List<String> getUserList() {
        return Collections.unmodifiableList(userList);
    }

    public List<String> getResultList() {
        return Collections.unmodifiableList(resultList);
    }
}
