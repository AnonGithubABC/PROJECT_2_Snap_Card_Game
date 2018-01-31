package com.roberthenderson.snap;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
            public void onClick(View rulesButton) {
                Intent intent = new Intent(MainActivity.this, RulesActivity.class);
                startActivity(intent); // startActivity allow you to move
                    }
                });

        playButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View playButton) {
                Intent intent = new Intent(MainActivity.this, PlayActivity.class);
                startActivity(intent); // startActivity allow you to move
                    }
                });
    }

}


