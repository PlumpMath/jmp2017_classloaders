package plugins.currenttime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;


/**
 * Created by Ihar_Rubanovich on 2/22/2017.
 */
public class Utils {
    public void show() {
        System.out.println("Current DateTime: " + getCurrentTime());
    }

    private String getCurrentTime() {
        LocalDateTime currentTime = LocalDateTime.now();
        return currentTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
    }
}
