package ydrall.flashcards.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

import ydrall.flashcards.Adapters.FlashCardsAdapter;
import ydrall.flashcards.Animation.CoverflowPageTransformer;
import ydrall.flashcards.R;
import ydrall.flashcards.async.AsyncCards;
import ydrall.flashcards.model.FlashCard;

public class MainActivity extends AppCompatActivity implements AsyncCards.AsyncCardsListener {

    private VelocityViewPager pager;
    private FlashCardsAdapter cardsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        pager = (VelocityViewPager) findViewById(R.id.viewpager_main);
        pager.setPageTransformer(true, new CoverflowPageTransformer(0.1f,0f,0f,0f));

        ArrayList<FlashCard> cards = new ArrayList<>();
        cardsAdapter = new FlashCardsAdapter(this,cards);
        pager.setAdapter(cardsAdapter);
        pager.setOffscreenPageLimit(3);
        pager.setClipChildren(false);

    }

    @Override
    protected void onResume() {
        super.onResume();
        new AsyncCards(this).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public void onCardsFetched(ArrayList<FlashCard> flashCards) {
        cardsAdapter.addCards(flashCards);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_item_add_card:
                Intent addCardActivityIntent = new Intent(this,AddCardActivity.class);
                startActivity(addCardActivityIntent);
                return true;
            case R.id.menu_item_setting:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
