package com.roberthenderson.snap;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private Button playButton;
    private Button rulesButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rulesButton = (Button) findViewById(R.id.rules);
        playButton = (Button) findViewById(R.id.play);

            rulesButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onRulesButtonClick(View rulesButton) {
            Intent intent = new Intent(MainActivity.this, Rules.class);
            startActivity(intent); // startActivity allow you to move
                }
            });

            playButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onPlayButtonClick(View playButton) {
            Intent intent = new Intent(MainActivity.this, Play.class);
            startActivity(intent); // startActivity allow you to move
                }
            });
    }

}
