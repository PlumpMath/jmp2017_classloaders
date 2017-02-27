package app.plugins.greeting;

import app.constants.ConfigConstants;

import java.util.*;

/**
 * Created by Ihar_Rubanovich on 2/22/2017.
 */
public class AUtils {
    private List<String> greetingsList;

    public void show() {
        greetingsList = getRandomGreeting();
        int randomIndex = new Random().nextInt(greetingsList.size());
        getRandomGreeting().get(randomIndex);
        System.out.println(greetingsList.get(randomIndex));
    }

    private List<String> getRandomGreeting() {
        greetingsList = new ArrayList<String>();
        ResourceBundle rb = ResourceBundle.getBundle(ConfigConstants.GREETINGS_CONFIG);
        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            greetingsList.add(rb.getString(key));
        }
        return greetingsList;
    }
}
