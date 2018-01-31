package com.roberthenderson.snap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    Button player1Button;
    Button player2Button;
    TextView textView1;
    TextView textView2;
    TextView textViewWinner;
    Button player1SnapButton;
    Button player2SnapButton;
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
        textView1 = findViewById(R.id.player1TextView);
        textView2 = findViewById(R.id.player2TextView);
        textViewWinner = findViewById(R.id.playerWins);
        player1SnapButton = findViewById(R.id.player1SnapButton);
        player2SnapButton = findViewById(R.id.player2SnapButton);
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
            game.playerPlays(player1);
            Card cardPlayed = game.lastCardPlayedOnTable();
            textView1.setText(cardPlayed.cardName());
        }
        });


    player2Button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player2Button) {
            game.playerPlays(player2);
            Card cardPlayed = game.lastCardPlayedOnTable();
            textView2.setText(cardPlayed.cardName());
        }
        });

    player1SnapButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player1SnapButton) {
            game.callSnap(player1);
            game.checksWhenRanksMatch();
            game.checkWinner();
            String winningPlayer = game.checkWinner().toString();
            textViewWinner.setText(winningPlayer);

        }
        });

    player2SnapButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player2SnapButton) {
            game.callSnap(player2);
            game.checksWhenRanksMatch();
            game.checkWinner();
            String winningPlayer = game.checkWinner().toString();
            textViewWinner.setText(winningPlayer);

        }
        });

    }




}
