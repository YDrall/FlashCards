package ydrall.flashcards.async;

import android.os.AsyncTask;

import java.util.ArrayList;

import ydrall.flashcards.FlashCardsApp;
import ydrall.flashcards.model.FlashCard;


public class AsyncCards extends AsyncTask<String, Integer, String> {

    private AsyncCardsListener listener;
    private ArrayList<FlashCard> cards;
    public AsyncCards(AsyncCardsListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(String... params) {
        // first open your database
        FlashCardsApp.dataBase.open();
        // then execute your queries
        cards = FlashCardsApp.dataBase.getAllFlashCards();
        // always remember to close database
        FlashCardsApp.dataBase.close();
        return "success";
    }

    @Override
    protected void onPostExecute(String s) {
        listener.onCardsFetched(cards);
    }

    public interface AsyncCardsListener {
        void onCardsFetched(ArrayList<FlashCard> flashCards);
    }
}
