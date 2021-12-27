import java.util.Random;

public class Ladder {
    private final int width;
    private final int height;
    private final boolean[][] bridge;

    private static final int WIDTH_CORRECTION = 1;

    public Ladder(int numPeople, int ladderHeight) {
        this.width = numPeople - WIDTH_CORRECTION;
        this.height = ladderHeight;
        this.bridge = new boolean[height][width];
        initializeBridge();
    }

    private void initializeBridge() {
        final Random RANDOM = new Random();

        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                bridge[h][w] = RANDOM.nextBoolean();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder ladder = new StringBuilder();
        for (int h = 0; h < height; h++) {
            ladder.append("|");
            for (int w = 0; w < width; w++) {
                ladder.append(bridge[h][w] ? "-" : " ").append("|");
            }
            ladder.append("\n");
        }
        return ladder.toString();
    }
}
