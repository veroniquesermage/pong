package fr.wcs.pong;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {

    public static final int DURATION = 1000;

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView ball = findViewById(R.id.ball);
        final ImageView barTop = findViewById(R.id.barTop);
        final ImageView barBottom = findViewById(R.id.barBottom);
        final RelativeLayout layout = findViewById(R.id.layout);

        //ball animation
        final ObjectAnimator animationStart = ObjectAnimator.ofFloat(ball, "translationY", -900f);
        animationStart.setDuration(2000);
        animationStart.start();



        animationStart.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            boolean isReadyToReverse;
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float test = barTop.getY();

                if (ball.getY()<barTop.getY()){
                    animation.cancel();
                }

                System.out.println("bidule est content --------------------------------------------------- " + test);
                System.out.println("bidule est content ùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùùù " + ball.getY());

            }
        });



        // bar animation on touch
        layout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                final int height = layout.getHeight(); // add here because in the onCreate the view isn't created
                boolean isOnTop = event.getY()<height/2;
                ImageView theBar = isOnTop ? barTop : barBottom;
                ObjectAnimator animation = ObjectAnimator.ofFloat(theBar,
                        "x",event.getX());
                animation.setDuration(DURATION);
                animation.start();
                return false;
            }
        });

    }

}
