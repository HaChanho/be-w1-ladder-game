import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.StringJoiner;

public class LadderRow {
    private static final int FIRST_INDEX = 0;
    private static final String PILLAR = "|";
    private static final String EMPTY = "     ";
    private static final String BRIDGE = "-----";

    private final List<Boolean> row = new ArrayList<>();

    public LadderRow(int width) {
        final Random random = new Random();

        for (int w = 0; w < width; w++) {
            boolean bridge = isPossiblePutBridge(w) && random.nextBoolean();
            row.add(bridge);
        }
    }

    private boolean isPossiblePutBridge(int idx) {
        return idx == FIRST_INDEX || !row.get(idx - 1);
    }

    @Override
    public String toString() {
        StringJoiner line = new StringJoiner(PILLAR, PILLAR, PILLAR);
        for (Boolean bridge : row) {
            line.add(bridge ? BRIDGE : EMPTY);
        }
        return line.toString();
    }
}
