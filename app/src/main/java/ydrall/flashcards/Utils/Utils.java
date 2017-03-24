package ydrall.flashcards.Utils;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Utils {

    public static String getCurrentDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
