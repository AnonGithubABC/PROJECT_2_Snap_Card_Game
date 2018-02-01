package com.roberthenderson.snap;


import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class CardTest {

    Card card;

    @Before
    public void before(){
        card = new Card(Suit.HEARTS, Rank.KING);
    }

    @Test
    public void canGetSuit(){
        assertEquals(Suit.HEARTS,card.getSuit());
    }

    @Test
    public void canGetRank(){
        assertEquals(Rank.KING, card.getRank());}

    @Test
    public void jackValueIs11() {
        card = new Card(Suit.CLUBS, Rank.JACK);
        int value = card.getRank().getValue();
        assertEquals(11, value);
    }

    @Test
    public void canGetCardAsString(){
        assertEquals("KING HEARTS", card.cardName());
    }

    @Test
    public void canGetCardAsFileName() {
        assertEquals("king_of_hearts", card.cardNameAsFileName());
    }
}
