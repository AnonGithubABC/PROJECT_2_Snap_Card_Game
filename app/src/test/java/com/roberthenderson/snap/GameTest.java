package com.roberthenderson.snap;

import android.support.v4.widget.TextViewCompat;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 28/01/2018.
 */

public class GameTest {

    Game game;
    Deck deck;
    Player player1;
    Player player2;
    Dealer dealer;
    Card card1;
    ArrayList<Player> players;


    @Before
    public void before(){
        players = new ArrayList<>();
        player1 = new Player();
        player2 = new Player();
        deck = new Deck();
        dealer = new Dealer();
        card1 = new Card(Suit.SPADES, Rank.FIVE);
        players.add(player1);
        players.add(player2);
        game = new Game(players, deck, dealer);

    }

    @Test
    public void canStartGame(){
        game.gameStart();
        assertEquals(26, player1.getNumberOfCards());
        assertEquals(26, player2.getNumberOfCards());
    }

    @Test
    public void cardsInTableStartsAtZero(){
        assertEquals(0, game.getTable().size());
    }

    @Test
    public void canAddCardsToTable(){
        game.tableAcceptsCard(card1);
        assertEquals(1, game.getTable().size());
    }

    @Test
    public void cardLeavesPlayerHandAndGoesOntoTable(){
        game.gameStart();
        game.playerPlays(player1);
        assertEquals(1, game.getTable().size());
        assertEquals(25, player1.getNumberOfCards());
        game.playerPlays(player2);
        assertEquals(25, player2.getNumberOfCards());
        assertEquals(2, game.getTable().size());

    }

    @Test
    public void playerCantPlayMoreCardsThanInHand(){
        game.gameStart();
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        game.playerPlays(player2);
        assertEquals(0, player2.getNumberOfCards());
    }
}
