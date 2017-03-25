package ydrall.flashcards.model;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import ydrall.flashcards.Utils.Utils;

public class DataBase {

    private SQLiteDatabase database;
    private DbHelper dbHelper;
    private String[] FlashCardColumns = {
            DatabaseContract.FlashCardsEntry._ID,
            DatabaseContract.FlashCardsEntry.COLUMN_BACK_TEXT,
            DatabaseContract.FlashCardsEntry.COLUMN_FRONT_TEXT,
            DatabaseContract.FlashCardsEntry.COLUMN_CREATED_AT
    };

    public DataBase(Context context) {
        this.dbHelper = new DbHelper(context);
    }

    public void open() {
        this.database = dbHelper.getWritableDatabase();
    }

    public void close() {
        this.database = null;
        this.dbHelper.close();
    }

    public void clear() {
        database.delete(DatabaseContract.EnvelopeEntry.TABLE_NAME,null,null);
        database.delete(DatabaseContract.FlashCardsEntry.TABLE_NAME,null,null);
    }

    public long addEnvelope(String envelopeTitle, int envelopeColor) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.EnvelopeEntry.COLUMN_ENVELOPE_TITLE,envelopeTitle);
        values.put(DatabaseContract.EnvelopeEntry.COLUMN_CARDS_COUNT,0);
        values.put(DatabaseContract.EnvelopeEntry.COLUMN_LAST_UPDATED, Utils.getCurrentDateTime());
        values.put(DatabaseContract.EnvelopeEntry.COLUMN_ENVELOPE_COLOR,envelopeColor);

        return database.insert(DatabaseContract.EnvelopeEntry.TABLE_NAME,null,values);
    }

    public long addFlashCard(long envelopeId, String frontText, String backText) {
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.FlashCardsEntry.COLUMN_ENVELOPE_ID,envelopeId);
        values.put(DatabaseContract.FlashCardsEntry.COLUMN_FRONT_TEXT,frontText);
        values.put(DatabaseContract.FlashCardsEntry.COLUMN_BACK_TEXT,backText);

        return database.insert(DatabaseContract.FlashCardsEntry.TABLE_NAME,null,values);
    }


    public ArrayList<FlashCard> getAllFlashCards(long EnvelopeId) {
        ArrayList<FlashCard> cards = new ArrayList<>();
        Cursor cursor = database.query(DatabaseContract.FlashCardsEntry.TABLE_NAME,
                FlashCardColumns,
                DatabaseContract.FlashCardsEntry.COLUMN_ENVELOPE_ID +" = " +EnvelopeId,
                null,null,null,null);
        while(cursor.moveToNext()) {
            cards.add(FlashCard.create(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.FlashCardsEntry._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FlashCardsEntry.COLUMN_FRONT_TEXT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FlashCardsEntry.COLUMN_BACK_TEXT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FlashCardsEntry.COLUMN_CREATED_AT))
                    ));
        }
        cursor.close();
        return cards;
    }

    public ArrayList<FlashCard> getAllFlashCards() {
        ArrayList<FlashCard> cards = new ArrayList<>();
        Cursor cursor = database.query(DatabaseContract.FlashCardsEntry.TABLE_NAME,
                FlashCardColumns,
                null,null,null,null,null);
        while(cursor.moveToNext()) {
            cards.add(FlashCard.create(cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseContract.FlashCardsEntry._ID)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FlashCardsEntry.COLUMN_FRONT_TEXT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FlashCardsEntry.COLUMN_BACK_TEXT)),
                    cursor.getString(cursor.getColumnIndexOrThrow(DatabaseContract.FlashCardsEntry.COLUMN_CREATED_AT))
            ));
        }
        cursor.close();
        return cards;
    }

}
