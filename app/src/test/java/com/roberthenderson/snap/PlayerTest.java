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
        card1 = new Card(Suit.SPADES, Rank.FIVE);
        card2 = new Card(Suit.SPADES, Rank.TEN);
        player1.takeCard(card1);
        player1.takeCard(card2);
    }

    @Test
    public void getHandValue(){
        assertEquals(15, player1.getHandValue());
    }

   @Test
   public void getHandSize(){
        dealer.dealAllCards(deck, player1, player2);
        assertEquals(26, player1.getNumberOfCards());
   }

}
