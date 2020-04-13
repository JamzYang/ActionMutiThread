package yang.patterns.command;

/**
 * @author yang
 * Date 2020/4/13 8:35
 */
public class InputHandler {
    private Command jump;
    private Command fire;

    public InputHandler() {
        this.jump = new JumpCommand();
        this.fire = new FireCommand();
    }

    public static final String ACTION_JUMP="k";
    public static final String ACTION_FIRE="j";

    public void handleInput(String input){
        if(ACTION_JUMP.equals(input)){
            jump.execute();
        }else if(ACTION_FIRE.equals(input)){
            fire.execute();
        }
    }

}
