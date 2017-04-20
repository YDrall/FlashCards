package ydrall.flashcards;

import android.app.Application;

import com.facebook.stetho.Stetho;

import ydrall.flashcards.model.DataBase;

public class FlashCardsApp extends Application {

    public static DataBase dataBase;
    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(getApplicationContext());
        dataBase = new DataBase(getApplicationContext());
    }

}
