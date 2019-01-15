package fr.wcs.pong;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int DURATION = 1000;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ball = findViewById(R.id.ball);
        final ImageView barTop = findViewById(R.id.barTop);
        final ImageView barBottom = findViewById(R.id.barBottom);
//        ObjectAnimator animation = ObjectAnimator.ofFloat(barTop, "translationX", 100f);
//        animation.setDuration(2000);
//        animation.start();

        final RelativeLayout layout = findViewById(R.id.layout);

        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int height = layout.getHeight(); // add here because int the onCreate, the view isn't create
                boolean isOnTop = event.getY()<height/2;
                ImageView theBar = isOnTop ? barTop : barBottom;
                theBar.setX(event.getX());
                ObjectAnimator animation = ObjectAnimator.ofFloat(theBar,
                        "x",event.getX());
                animation.setDuration(DURATION);
                animation.start();
//                Toast.makeText(getApplicationContext(),
//                        String.valueOf(event.getX())+String.valueOf(event.getY()),
//                        Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }


}
