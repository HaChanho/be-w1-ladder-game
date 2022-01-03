package ladder.domain;

import java.util.Collections;
import java.util.List;

public class LadderRow {
    private final List<Boolean> row;

    public LadderRow(List<Boolean> row) {
        this.row = row;
    }

    public List<Boolean> getLadderRow() {
        return Collections.unmodifiableList(row);
    }

    public boolean isExistBridge(int rowIdx) {
        return row.get(rowIdx);
    }
}
