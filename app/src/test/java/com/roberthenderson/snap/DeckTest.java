package com.roberthenderson.snap;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 26/01/2018.
 */

public class DeckTest {

    Deck deck;
    Player player1;
    Player player2;


    @Before
    public void before(){
        deck = new Deck();
        player1 = new Player();
        player2 = new Player();
    }

    @Test
    public void deckHas52Cards(){
        assertEquals(52, deck.getSize());
    }

//    @Test
//    public void lastCardInDeckIsKingOfDiamonds() {
//        Card card = deck.findSpecificCard(51);
//        assertEquals(Suit.DIAMONDS, card.getSuit());
//        assertEquals(Rank.KING, card.getRank());
//    }

    @Test
    public void canRemoveCardsFromDeck(){
        deck.removeCard();
        assertEquals(51, deck.getSize());
    }


}
