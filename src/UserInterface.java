import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static final int MAX_NUM_STRING = 5;

    Scanner scanner = new Scanner(System.in);

    public List<String> inputUserInfo() {
        System.out.println("참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)");
        String[] users = scanner.nextLine().split(",");

        return Arrays.asList(users);
    }

    public int inputLadderHeight() {
        System.out.println("최대 사다리 높이는 몇 개인가요?");
        return scanner.nextInt();
    }

    public void printLadderGame(List<String> userList, Ladder ladder) {
        printUsers(userList);
        printLadder(ladder);
    }

    private void printUsers(List<String> userList) {
        for (String user : userList) {
            System.out.printf("%" + MAX_NUM_STRING + "s ", user);
        }
        System.out.println();
    }

    private void printLadder(Ladder ladder) {
        System.out.println(ladder);
    }
}
