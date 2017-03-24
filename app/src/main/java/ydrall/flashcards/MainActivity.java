package ydrall.flashcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import ydrall.flashcards.model.DataBase;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_main_dbs)
    RecyclerView dbList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBase dataBase = new DataBase(getApplicationContext());

        System.out.println(dataBase.getAllFlashCards());
    }
}
