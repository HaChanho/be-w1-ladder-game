import java.util.Random;
import java.util.StringJoiner;

public class Ladder {
    private static final int WIDTH_CORRECTION = 1;

    private final int width;
    private final int height;
    private final boolean[][] bridges;

    public Ladder(int numPeople, int ladderHeight) {
        this.width = numPeople - WIDTH_CORRECTION;
        this.height = ladderHeight;
        this.bridges = new boolean[height][width];
        initializeBridge();
    }

    private void initializeBridge() {
        for (int h = 0; h < height; h++) {
            initializeRow(h);
        }
    }

    private void initializeRow(int rowIdx) {
        final Random RANDOM = new Random();

        for (int w = 0; w < width; w++) {
            bridges[rowIdx][w] = RANDOM.nextBoolean();
        }
    }

    @Override
    public String toString() {
        StringBuilder ladder = new StringBuilder();
        for (int h = 0; h < height; h++) {
            ladder.append(buildRow(h)).append("\n");
        }
        return ladder.toString();
    }

    private String buildRow(int rowIdx) {
        StringJoiner row = new StringJoiner("|", "|", "|");
        for (int w = 0; w < width; w++) {
            row.add(bridges[rowIdx][w] ? "-" : " ");
        }
        return row.toString();
    }
}
