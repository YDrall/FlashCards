package ydrall.flashcards.ui;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ydrall.flashcards.R;

public class AddCardActivity extends AppCompatActivity implements AddCardFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
