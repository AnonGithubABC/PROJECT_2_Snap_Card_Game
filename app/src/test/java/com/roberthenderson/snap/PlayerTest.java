package com.roberthenderson.snap;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerTest {

    Dealer dealer;
    Player player1;
    Player player2;
    Card card1;
    Card card2;
    Deck deck;


    @Before
    public void before(){
        player1 = new Player();
        player2 = new Player();
        dealer = new Dealer();
        deck = new Deck();
        card1 = new Card(Suit.SPADES, Rank.FIVE);
        card2 = new Card(Suit.SPADES, Rank.TEN);
//        player1.takeCard(card1);
//        player1.takeCard(card2);
        dealer.dealAllCards(deck, player1, player2);
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



}
