package com.roberthenderson.snap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class WinningPlayerActivity extends AppCompatActivity {

    Button playAgain;
    TextView playerWins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_winning_player);

        playAgain = findViewById(R.id.playAgain);
        playerWins = findViewById(R.id.playerWins);


//        playerWins.setText(String.);
        playAgain.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View playButton) {
                Intent intent = new Intent(WinningPlayerActivity.this, PlayActivity.class);
                startActivity(intent); // startActivity allow you to move
            }
        });
    }
}
