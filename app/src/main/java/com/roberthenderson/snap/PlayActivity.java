package com.roberthenderson.snap;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ViewAnimator;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    Button player1Button;
    Button player2Button;
    TextView textView1;
    TextView textView2;
    TextView textView3;
    TextView textViewWinner;
    Button player1SnapButton;
    Button player2SnapButton;
    TextView player1CardCount;
    TextView player2CardCount;
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
        textView3 = findViewById(R.id.playNextRound);
        textViewWinner = findViewById(R.id.playerWins);
        player1SnapButton = findViewById(R.id.player1SnapButton);
        player2SnapButton = findViewById(R.id.player2SnapButton);
        player1CardCount = findViewById(R.id.player1CardCount);
        player2CardCount = findViewById(R.id.player2CardCount);
        player1 = new Player();
        player2 = new Player();
        deck = new Deck();
        dealer = new Dealer();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        game = new Game(players, deck, dealer);
        game.gameStart();
        player1CardCount.setText(String.valueOf(player1.getNumberOfCards()) + " cards left!");
        player2CardCount.setText(String.valueOf(player2.getNumberOfCards()) + " cards left!");


        String player1cards = String.valueOf(player1.getNumberOfCards());
        Log.d("Game Created", "player1 has " + player1cards + " cards");


    player1Button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player1Button) {
            if(game.getActivePlayer() == player1){
                game.playerPlays(player1);
                player1CardCount.setText(String.valueOf(player1.getNumberOfCards()) + " cards left!");
                Card cardPlayed = game.lastCardPlayedOnTable();
                textView1.setText(cardPlayed.cardName());
                textView3.setText("");
                if (game.checkWinner() != null){
//                    String winningPlayer = game.checkWinner().toString();
                    textViewWinner.setText("PLAYER 2 WINS");
                    textView1.setText("");
                    textView2.setText("");
                }
            }
        }
        });


    player2Button.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player2Button) {
            if(game.getActivePlayer() == player2) {
                game.playerPlays(player2);
                player2CardCount.setText(String.valueOf(player2.getNumberOfCards()) + " cards left!");
                Card cardPlayed = game.lastCardPlayedOnTable();
                textView2.setText(cardPlayed.cardName());
                textView3.setText("");
                if (game.checkWinner() != null){
//                    String winningPlayer = game.checkWinner().toString();
                    textViewWinner.setText("PLAYER 1 WINS");
                    textView1.setText("");
                    textView2.setText("");
                }
            }
        }
        });

    player1SnapButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player1SnapButton) {
            String result = game.callSnap(player1);
            player1CardCount.setText(String.valueOf(player1.getNumberOfCards()) + " cards left!");
            textView1.setText("");
            textView2.setText("");
            textView3.setText(result);


        }
    });

    player2SnapButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player2SnapButton) {
            String result = game.callSnap(player2);
            player2CardCount.setText(String.valueOf(player2.getNumberOfCards()) + " cards left!");
            textView1.setText("");
            textView2.setText("");
            textView3.setText(result);

        }
    });

    }






}
