package ladder.domain;

import java.util.List;

public class GameResult {
    private static final int INVALID_INDEX = -1;

    private final List<String> sortedResultList;

    public GameResult(List<String> sortedResultList) {
        this.sortedResultList = sortedResultList;
    }

    public String getResultOf(int index) {
        if (index == INVALID_INDEX) {
            return "";
        }
        return sortedResultList.get(index);
    }
}
