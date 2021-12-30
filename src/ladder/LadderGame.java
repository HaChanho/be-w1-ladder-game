package ladder;

import ladder.domain.Ladder;
import ladder.view.UserInterface;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        List<String> userList = new ArrayList<>(ui.getUserInfoFromScanner());
        int numPeople = userList.size();
        int ladderHeight = ui.getLadderHeight();

        Ladder ladder = new Ladder(numPeople, ladderHeight);
        ui.printLadderGame(userList, ladder);
    }
}
