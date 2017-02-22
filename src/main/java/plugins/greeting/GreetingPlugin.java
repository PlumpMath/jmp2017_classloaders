package plugins.greeting;

import app.IPlugin;

/**
 * Created by Ihar_Rubanovich on 2/22/2017.
 */
public class GreetingPlugin extends Utils implements IPlugin {

    GreetingPlugin() {
        super();
    }

    public void doAction() {
        super.show();
    }
}
