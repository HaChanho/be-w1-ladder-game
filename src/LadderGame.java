import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        List<String> userList = new ArrayList<>(ui.inputUserInfo());
        int numPeople = userList.size();
        int ladderHeight = ui.inputLadderHeight();

        Ladder ladder = new Ladder(numPeople, ladderHeight);
        ui.printLadderGame(userList, ladder);
    }
}
