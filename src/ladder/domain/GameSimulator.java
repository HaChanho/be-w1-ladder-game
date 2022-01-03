package ladder.domain;

import ladder.LadderGame;

import java.util.List;
import java.util.stream.Collectors;

public class GameSimulator {
    private static final int START_HEIGHT = 0;

    static class Point {
        private static final int MOVING_UNIT = 1;

        private int row;
        private int col;
        private final Ladder ladder;

        public Point(int row, int col, Ladder ladder) {
            this.row = row;
            this.col = col;
            this.ladder = ladder;
        }

        private int getRow() {
            return row;
        }

        private int getCol() {
            return col;
        }

        private void move() {
            int row = this.getRow();
            int col = this.getCol();

            if (ladder.isPossibleMovingLeft(row, col)) {
                this.moveLeft();
            } else if (ladder.isPossibleMovingRight(row, col)) {
                this.moveRight();
            }

            this.moveDown();
        }

        private void moveLeft() {
            col -= MOVING_UNIT;
        }

        private void moveRight() {
            col += MOVING_UNIT;
        }

        private void moveDown() {
            row += MOVING_UNIT;
        }

        private boolean isNotFinished(int endHeight) {
            return row != endHeight;
        }
    }

    public List<String> getLadderGameResultList(LadderGame ladderGame, Ladder ladder) {
        return ladderGame.getUserList().stream()
                .map(user -> ladderGame.getResultList().get(getResultOf(ladderGame.getUserList().indexOf(user), ladder)))
                .collect(Collectors.toList());
    }

    private int getResultOf(int colIndex, Ladder ladder) {
        Point point = new Point(START_HEIGHT, colIndex, ladder);

        while (point.isNotFinished(ladder.getLadderHeight())) {
            point.move();
        }

        return point.getCol();
    }
}
