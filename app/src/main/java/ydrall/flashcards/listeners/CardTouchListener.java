package ydrall.flashcards.listeners;

import android.view.MotionEvent;
import android.view.View;

/**
 * Created by me on 3/28/17.
 */

public class CardTouchListener implements View.OnTouchListener {

    private float lasty = 0;
    private final float SWIPE_MIN_Y=400;
    private final String LOG_TAG = this.getClass().getName();
//    View view;

    /*public CardTouchListener(View view) {
        this.view = view;
    }*/

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lasty = event.getY();
                return true;

            case MotionEvent.ACTION_MOVE:
                float deltaY = Math.abs(lasty - v.getY());
                if(deltaY > SWIPE_MIN_Y) {
                    onSwipeY();
                    return true;
                }
                return false;
            default:
                return false;

        }
    }

    public void onSwipeY() {
//        view.animate().rotationY(180).setDuration(100).start();
    }
}
