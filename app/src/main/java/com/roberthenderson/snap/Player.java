package com.roberthenderson.snap;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

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

    public Card removeCard(){
        if (getNumberOfCards() >= 1) return hand.remove(0);
        return null;
    }

    public int getHandValue() {
        int totalHandValue = 0;
        for(Card card: this.hand){
            int valueOfCard = card.getRank().getValue();
            totalHandValue += valueOfCard;
        }
        return totalHandValue;
    }

    public void winCards(ArrayList<Card> cards) {
        this.hand.addAll(cards);
        Collections.shuffle(this.hand);
    }
}
