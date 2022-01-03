package ladder.view;

import java.util.Scanner;

public class CommandScanner {
    Scanner scanner = new Scanner(System.in);

    public String getCommand() {
        System.out.println("결과를 보고 싶은 사람은?");
        return scanner.nextLine().trim();
    }
}
