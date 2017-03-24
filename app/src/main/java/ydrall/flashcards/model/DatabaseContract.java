package ydrall.flashcards.model;

import android.provider.BaseColumns;

public final class DatabaseContract {
    private DatabaseContract() {}

    public class EnvelopeEntry implements BaseColumns {
        public static final String TABLE_NAME = "ENVELOPES";
        public static final String COLUMN_ENVELOPE_TITLE = "TITLE";
        public static final String COLUMN_CREATED_AT = "TIMESTAMP";
        public static final String COLUMN_LAST_UPDATED = "LAST_UPDATED";
        public static final String COLUMN_CARDS_COUNT = "CARDS_COUNT";
        public static final String COLUMN_ENVELOPE_COLOR = "ENVELOPE_COLOR";
    }

    public class FlashCardsEntry implements BaseColumns {
        public static final String TABLE_NAME = "FLASH_CARDS";
        public static final String COLUMN_FRONT_TEXT = "FRONT";
        public static final String COLUMN_BACK_TEXT = "BACK";
        public static final String COLUMN_CREATED_AT = "CREATED_AT";
        public static final String COLUMN_ENVELOPE_ID = "ENVELOPE_ID";
    }
}
