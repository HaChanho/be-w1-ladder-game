import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private static final int WIDTH_CORRECTION = 1;
    private static final String SPACE = "  ";
    private static final String NEW_LINE = "\n";

    private final List<LadderRow> bridges = new ArrayList<>();

    public Ladder(int numPeople, int ladderHeight) {
        for (int h = 0; h < ladderHeight; h++) {
            bridges.add(new LadderRow(numPeople - WIDTH_CORRECTION));
        }
    }

    @Override
    public String toString() {
        StringBuilder ladder = new StringBuilder();
        for (LadderRow line : bridges) {
            ladder.append(SPACE).append(line).append(NEW_LINE);
        }
        return ladder.toString();
    }
}
