package app.utils;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


/**
 * Created by Ihar_Rubanovich on 2/24/2017.
 */
public class ProppertiesInit {
    private static Map<String, String> PROPS_MAP = new HashMap<String, String>();

    public void intialize(ResourceBundle properties) {
        Enumeration<String> keys = properties.getKeys();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            PROPS_MAP.put(key, properties.getString(key));
        }
    }

    public static Map<String, String> getPropsMap() {
        return PROPS_MAP;
    }
}
