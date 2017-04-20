package ydrall.flashcards.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import ydrall.flashcards.R;
import ydrall.flashcards.Utils.Constants;
import ydrall.flashcards.model.FlashCard;

public class ExpandedCardActivity extends Activity {

    private TextView frontTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_card);
        FlashCard flashCard = getIntent().getExtras().getParcelable(Constants.ExapndCardActivityConstants.DATA_FLASH_CARD);
        frontTextView = (TextView) findViewById(R.id.activity_expandCard_textView_frontText);
        if (flashCard != null) {
            frontTextView.setText(flashCard.frontText());
        }
    }
}
