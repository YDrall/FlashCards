package ydrall.flashcards.model;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class FlashCard {
    public abstract String frontText();
    public abstract String backText();
    public abstract String createdAt();

    public static FlashCard create(String frontText, String backText, String createAt) {
        return new AutoValue_FlashCard(frontText,backText,createAt);
    }
}
