package ladder.domain;

import java.util.List;

public class LadderRow {
    private final List<Boolean> row;

    public LadderRow(List<Boolean> row) {
        this.row = row;
    }

    public List<Boolean> getLadderRow() {
        return row;
    }
}
