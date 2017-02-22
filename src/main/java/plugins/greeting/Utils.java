package plugins.greeting;

import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by Ihar_Rubanovich on 2/22/2017.
 */
public class Utils {
    final static Logger logger = Logger.getLogger(Utils.class);
    private List<String> greetingsList;

    public void show() {
        greetingsList = getRandomGreeting();
        int randomIndex = new Random().nextInt(greetingsList.size());
        getRandomGreeting().get(randomIndex);
        System.out.println(greetingsList.get(randomIndex));
        logger.info(greetingsList.get(randomIndex));
    }

    private List<String> getRandomGreeting() {
        greetingsList = new ArrayList<String>();
        ResourceBundle rb = ResourceBundle.getBundle("greetings");
        Enumeration<String> keys = rb.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            greetingsList.add(rb.getString(key));
        }
        return greetingsList;
    }
}
