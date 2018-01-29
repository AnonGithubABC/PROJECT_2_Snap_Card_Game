package com.roberthenderson.snap;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {

    Dealer dealer;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Deck deck;
    ArrayList<Player> players;


    @Before
    public void before(){
        players = new ArrayList<>();
        player1 = new Player();
        player2 = new Player();
        dealer = new Dealer();
        deck = new Deck();
        card1 = new Card(Suit.SPADES, Rank.FIVE);
        card2 = new Card(Suit.SPADES, Rank.TEN);
//        player1.takeCard(card1);
//        player1.takeCard(card2);
        players.add(player1);
        players.add(player2);
        dealer.dealAllCards(deck, players);
    }

//    @Test
//    public void getHandValue(){
//        assertEquals(15, player1.getHandValue());
//    }

   @Test
   public void getHandSizeStartOfGame(){
//        dealer.dealAllCards(deck, player1, player2);
        assertEquals(26, player1.getNumberOfCards());
        assertEquals(26, player2.getNumberOfCards());
   }

   @Test
    public void canRemoveCardFromHand() {
       player1.removeCard();
       assertEquals(25, player1.getNumberOfCards());
   }

}
