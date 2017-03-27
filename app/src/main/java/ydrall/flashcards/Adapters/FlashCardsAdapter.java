package ydrall.flashcards.Adapters;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import ydrall.flashcards.R;
import ydrall.flashcards.model.FlashCard;

public class FlashCardsAdapter extends PagerAdapter {

    private Context mContext;
    private ArrayList<FlashCard> cardsList;

    public FlashCardsAdapter(Context context, ArrayList<FlashCard> cards) {
        this.mContext = context;
        this.cardsList = cards;
    }

    @Override
    public Object instantiateItem(ViewGroup collection, int position) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_main_coverflow,collection,false);
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

}
