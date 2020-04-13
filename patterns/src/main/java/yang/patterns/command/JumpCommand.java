package yang.patterns.command;

/**
 * @author yang
 * Date 2020/4/13 8:32
 */
public class JumpCommand implements Command {
    @Override
    public void execute() {
        System.out.println("jump");
    }
}
