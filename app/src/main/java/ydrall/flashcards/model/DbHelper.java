package ydrall.flashcards.model;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "CARDS.db";
    private static final int DATABASE_VERSION = 1;

    private static final String CREATE_TABLE_ENVELOPE = "CREATE TABLE " + DatabaseContract.EnvelopeEntry.TABLE_NAME
            + " ( "
            + DatabaseContract.EnvelopeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.EnvelopeEntry.COLUMN_ENVELOPE_TITLE + " TEXT, "
            + DatabaseContract.EnvelopeEntry.COLUMN_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
            + DatabaseContract.EnvelopeEntry.COLUMN_CARDS_COUNT + " INTEGER, "
            + DatabaseContract.EnvelopeEntry.COLUMN_ENVELOPE_COLOR + " INTEGER, "
            + DatabaseContract.EnvelopeEntry.COLUMN_LAST_UPDATED + " DATETIME"
            + " );";

    private static final String CREATE_TABLE_FLASHCARDS = "CREATE TABLE " + DatabaseContract.FlashCardsEntry.TABLE_NAME
            + " ( "
            + DatabaseContract.FlashCardsEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + DatabaseContract.FlashCardsEntry.COLUMN_FRONT_TEXT + " TEXT, "
            + DatabaseContract.FlashCardsEntry.COLUMN_BACK_TEXT + " TEXT, "
            + DatabaseContract.FlashCardsEntry.COLUMN_CREATED_AT + " DATETIME DEFAULT CURRENT_TIMESTAMP, "
            + DatabaseContract.FlashCardsEntry.COLUMN_ENVELOPE_ID + " INTEGER, "
            + "FOREIGN KEY(" + DatabaseContract.FlashCardsEntry.COLUMN_ENVELOPE_ID +") "
            +" REFERENCES "+ DatabaseContract.EnvelopeEntry.TABLE_NAME+"("+ DatabaseContract.EnvelopeEntry._ID+")"
            + " );";

    private static final String DELETE_TABLE_ENVELOPE = "DROP TABLE IF EXISTS " + DatabaseContract.EnvelopeEntry.TABLE_NAME;
    private static final String DELETE_TABLE_FALSHCARDS = "DROP TABLE IF EXISTS" + DatabaseContract.FlashCardsEntry.TABLE_NAME;


    public DbHelper(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_ENVELOPE);
        db.execSQL(CREATE_TABLE_FLASHCARDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }

}
