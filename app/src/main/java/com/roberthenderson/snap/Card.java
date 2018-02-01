package com.roberthenderson.snap;

public class Card {

    private Suit suit;
    private Rank rank;
    private String image;

    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        this.image = setCardNameAsFileName();
    }

    public Suit getSuit() { return this.suit; }

    public Rank getRank() { return this.rank; }

    public String cardName(){
        return getRank().toString() + " " + getSuit().toString();
    }

    public String setCardNameAsFileName(){
        return getRank().toString().toLowerCase() + "_of_" + getSuit().toString().toLowerCase();
    }

    public String getCardImage(){
        return this.image;
    }
}
