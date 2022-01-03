package ladder.domain;

import java.util.Collections;
import java.util.List;

public class Ladder {
    private static final int FIRST_INDEX = 0;

    private final List<LadderRow> ladder;

    public Ladder(List<LadderRow> ladder) {
        this.ladder = ladder;
    }

    public List<LadderRow> getLadder() {
        return Collections.unmodifiableList(ladder);
    }

    public int getLadderHeight() {
        return ladder.size();
    }

    public boolean isPossibleMovingLeft(int row, int col) {
        if (col == FIRST_INDEX) {
            return false;
        }
        return ladder.get(row).isExistBridge(col - 1);
    }

    public boolean isPossibleMovingRight(int row, int col) {
        if (col == ladder.get(row).getLadderRow().size()) {
            return false;
        }
        return ladder.get(row).isExistBridge(col);
    }
}
