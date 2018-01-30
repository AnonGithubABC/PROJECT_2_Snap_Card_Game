package com.roberthenderson.snap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class Play extends AppCompatActivity {

    Button player1Button;
    Button player2Button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        player1Button = findViewById(R.id.player1Button);
        player2Button = findViewById(R.id.player2Button);
        textView = findViewById(R.id.textView);
    }


}
