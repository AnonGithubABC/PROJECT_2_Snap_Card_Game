package com.roberthenderson.snap;

import org.junit.Before;
import org.junit.Test;

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


    @Before
    public void before(){
        player1 = new Player();
        player2 = new Player();
        deck = new Deck();
        dealer = new Dealer();
        card1 = new Card(Suit.SPADES, Rank.FIVE);
        game = new Game(player1, player2, deck, dealer);

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
}
