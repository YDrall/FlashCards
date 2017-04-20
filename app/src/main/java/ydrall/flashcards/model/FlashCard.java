package ydrall.flashcards.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class FlashCard implements Parcelable {

    public abstract int id();
    public abstract String frontText();
    public abstract String backText();
    public abstract String createdAt();

    public static FlashCard create(int id, String frontText, String backText, String createAt) {
        return new AutoValue_FlashCard(id,frontText,backText,createAt);
    }
}
