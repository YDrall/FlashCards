package ydrall.flashcards;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

import ydrall.flashcards.Adapters.FlashCardsAdapter;
import ydrall.flashcards.Animation.CoverflowPageTransformer;
import ydrall.flashcards.Utils.Utils;
import ydrall.flashcards.model.FlashCard;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = (ViewPager) findViewById(R.id.viewpager_main);
        pager.setPageTransformer(true, new CoverflowPageTransformer(0.1f,0f,0f,0f));

        ArrayList<FlashCard> cards = new ArrayList<>();
        for(int i=0;i<10;i++)
            cards.add(FlashCard.create(i,"","", Utils.getCurrentDateTime()));

        FlashCardsAdapter cardsAdapter = new FlashCardsAdapter(getApplicationContext(),cards);
        pager.setAdapter(cardsAdapter);

        pager.setOffscreenPageLimit(cardsAdapter.getCount());
        pager.setClipChildren(false);
    }
}
