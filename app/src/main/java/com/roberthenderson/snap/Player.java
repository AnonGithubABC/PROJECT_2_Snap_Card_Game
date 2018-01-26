package com.roberthenderson.snap;


import java.util.ArrayList;

public class Player {

    private ArrayList<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }


    public int getNumberOfCards() {
        return hand.size();
    }

    public void takeCard(Card card) {
        hand.add(card);
    }

    public int getHandValue() {
        int totalHandValue = 0;
        for(Card card: this.hand){
            int valueOfCard = card.getRank().getValue();
            totalHandValue += valueOfCard;
        }
        return totalHandValue;
    }
}