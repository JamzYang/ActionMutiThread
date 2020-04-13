package yang.patterns.command;

import java.util.Scanner;

/**
 * @author yang
 * Date 2020/4/13 8:33
 */
public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InputHandler inputHandler = new InputHandler();
        while (true){
            String input = sc.next();
            inputHandler.handleInput(input);
        }
    }
}
