package yang.patterns.command;

/**
 * @author yang
 * Date 2020/4/13 8:33
 */
public class FireCommand implements Command {
    @Override
    public void execute() {
        System.out.println("fire");
    }
}
