package com.roberthenderson.snap;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

/**
 * Created by user on 26/01/2018.
 */

public class DeckTest {

    Deck deck;
    Deck loadedDeck;
    Player player1;
    Player player2;


    @Before
    public void before(){
        Card card1 = new Card(Suit.CLUBS, Rank.TWO);
        Card card2 = new Card(Suit.SPADES, Rank.TWO);
        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(card1);
        cards.add(card2);
        loadedDeck = new Deck(cards);
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

    @Test
    public void canCreateLoadedDeck(){
        assertEquals(Rank.TWO, loadedDeck.removeCard().getRank());
        assertEquals(Rank.TWO, loadedDeck.removeCard().getRank());
    }


}
