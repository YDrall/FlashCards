package ydrall.flashcards.model;

import android.graphics.Color;

import com.google.auto.value.AutoValue;

import java.util.Date;

@AutoValue
public abstract class Envelope {

    public abstract String title();
    public abstract Date timeStamp();
    public abstract Date lastUpdated();
    public abstract int cardsCount();
    public abstract Color cardColor();

    public static Envelope create(String title, Date timeStamp, Date lastUpdated, int cardsCount, Color cardColor) {
        return new AutoValue_Envelope(title,timeStamp,lastUpdated,cardsCount,cardColor);
    }
}
