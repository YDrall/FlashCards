package ydrall.flashcards.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import ydrall.flashcards.R;
import ydrall.flashcards.Utils.Constants;
import ydrall.flashcards.model.FlashCard;
import ydrall.flashcards.ui.ExpandedCardActivity;

public class FlashCardsAdapter extends PagerAdapter {

    private Activity activity;
    private ArrayList<FlashCard> cardsList;

    public FlashCardsAdapter(Activity activity, ArrayList<FlashCard> cards) {

        this.activity = activity;
        this.cardsList = cards;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, final int position) {
        LayoutInflater inflater = LayoutInflater.from(activity);
        View view = inflater.inflate(R.layout.item_main_coverflow,collection,false);
        final TextView frontText = (TextView)view.findViewById(R.id.item_mainCoverflow_textView_front);
        frontText.setText(cardsList.get(position).frontText());
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent expandCardIntent = new Intent(activity, ExpandedCardActivity.class);
                expandCardIntent.putExtra(Constants.ExapndCardActivityConstants.DATA_FLASH_CARD,cardsList.get(position));
                activity.startActivity(expandCardIntent);
            }
        });
        collection.addView(view);
        return view;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup collection, int position, Object view) {
        collection.removeView((View) view);
    }

    @Override
    public int getCount() {
        return cardsList.size();
    }

    public void addCards(ArrayList<FlashCard> cards) {
        cardsList = cards;
        notifyDataSetChanged();
    }
}
