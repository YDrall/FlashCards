package ydrall.flashcards.model;

import android.graphics.Color;

import com.google.auto.value.AutoValue;

import java.util.Date;

@AutoValue
public abstract class Envelope {

    public abstract int id();
    public abstract String title();
    public abstract Date timeStamp();
    public abstract Date lastUpdated();
    public abstract int cardsCount();
    public abstract Color cardColor();

    public static Envelope create(int id, String title, Date timeStamp, Date lastUpdated, int cardsCount, Color cardColor) {
        return new AutoValue_Envelope(id,title,timeStamp,lastUpdated,cardsCount,cardColor);
    }
}
