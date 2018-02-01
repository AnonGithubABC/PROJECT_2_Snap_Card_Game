package com.roberthenderson.snap;

import android.animation.ValueAnimator;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewAnimator;

import java.util.ArrayList;

public class PlayActivity extends AppCompatActivity {

    Button player1Button;
    Button player2Button;
    TextView textView3;
    TextView textViewWinner;
    Button player1SnapButton;
    Button player2SnapButton;
    TextView player1CardCount;
    TextView player2CardCount;
    ImageView player1Card;
    ImageView player2Card;
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
        textView3 = findViewById(R.id.playNextRound);
        textViewWinner = findViewById(R.id.playerWins);
        player1SnapButton = findViewById(R.id.player1SnapButton);
        player2SnapButton = findViewById(R.id.player2SnapButton);
        player1CardCount = findViewById(R.id.player1CardCount);
        player2CardCount = findViewById(R.id.player2CardCount);
        player1Card = findViewById(R.id.player1Card);
        player2Card = findViewById(R.id.player2Card);
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
                textView3.setText("");

                Context context = player1Card.getContext();
                int id = context.getResources().getIdentifier(cardPlayed.setCardNameAsFileName(), "drawable", context.getPackageName());
                player1Card.setImageResource(id);

                player1Card.setVisibility(View.VISIBLE);
                player2Card.setVisibility(View.VISIBLE);

                if (game.gameIsADraw(player1, player2) != false){
                    textViewWinner.setText("GAME IS A DRAW");
                    player1Card.setVisibility(View.INVISIBLE);
                    player2Card.setVisibility(View.INVISIBLE);
                }

                if (game.checkWinner() != null){
//                    String winningPlayer = game.checkWinner().toString();
                    textViewWinner.setText("PLAYER 2 WINS");
                    player1Card.setVisibility(View.INVISIBLE);
                    player2Card.setVisibility(View.INVISIBLE);

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
                textView3.setText("");

                Context context = player2Card.getContext();
                int id = context.getResources().getIdentifier(cardPlayed.setCardNameAsFileName(), "drawable", context.getPackageName());
                player2Card.setImageResource(id);

                player1Card.setVisibility(View.VISIBLE);
                player2Card.setVisibility(View.VISIBLE);

                if (game.gameIsADraw(player1, player2) != null){
                    textViewWinner.setText("GAME IS A DRAW");
                    player1Card.setVisibility(View.INVISIBLE);
                    player2Card.setVisibility(View.INVISIBLE);
                }

                if (game.checkWinner() != null){
//                    String winningPlayer = game.checkWinner().toString();
                    textViewWinner.setText("PLAYER 1 WINS");
                    player1Card.setVisibility(View.INVISIBLE);
                    player2Card.setVisibility(View.INVISIBLE);
                }
            }
        }
        });

    player1SnapButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player1SnapButton) {
            String result = game.callSnap(player1);
            player1CardCount.setText(String.valueOf(player1.getNumberOfCards()) + " cards left!");
//            textView1.setText("");
//            textView2.setText("");

            player1Card.setVisibility(View.INVISIBLE);
            player2Card.setVisibility(View.INVISIBLE);
            textView3.setText(result);


        }
    });

    player2SnapButton.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View player2SnapButton) {
            String result = game.callSnap(player2);
            player2CardCount.setText(String.valueOf(player2.getNumberOfCards()) + " cards left!");
//            textView1.setText("");
//            textView2.setText("");

            player1Card.setVisibility(View.INVISIBLE);
            player2Card.setVisibility(View.INVISIBLE);
            textView3.setText(result);

        }
    });

    }






}
