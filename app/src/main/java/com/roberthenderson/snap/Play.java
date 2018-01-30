package com.roberthenderson.snap;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Play extends AppCompatActivity {

    Button player1Button;
    Button player2Button;
    TextView textView;
    Player player1;
    Player player2;
    Deck deck;
    Dealer dealer;
    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);


        player1Button = findViewById(R.id.player1Button);
        player2Button = findViewById(R.id.player2Button);
        textView = findViewById(R.id.textView);
        player1 = new Player();
        player2 = new Player();
        deck = new Deck();
        dealer = new Dealer();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        game = new Game(players, deck, dealer);
        game.gameStart();



        String player1cards = String.valueOf(player1.getNumberOfCards());
        Log.d("Game Created", "player1 has " + player1cards + " cards");


    player1Button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player1Button) {
            Intent intent = new Intent(Play.this, Play.class);
            startActivity(intent);
            }
        });


    player2Button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View player2Button) {
                Intent intent = new Intent(Play.this, Play.class);
                startActivity(intent);
            }
        });
    }
}
