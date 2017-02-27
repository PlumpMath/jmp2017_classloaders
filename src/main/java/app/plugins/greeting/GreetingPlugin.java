package app.plugins.greeting;

import app.IPlugin;

/**
 * Created by Ihar_Rubanovich on 2/22/2017.
 */
public class GreetingPlugin extends AUtils implements IPlugin {
    public void doAction() {
        AUtils ut= new AUtils();
        ut.show();
    }
}
