package fr.wcs.pong;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView ball = findViewById(R.id.ball);
        ObjectAnimator animation = ObjectAnimator.ofFloat(ball, "translationY", 100f);
        animation.setDuration(2000);
        animation.start();
    }
}
