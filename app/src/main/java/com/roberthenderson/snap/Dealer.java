package com.roberthenderson.snap;

/**
 * Created by user on 26/01/2018.
 */

class Dealer {

    public void dealCard(Deck deck, Player player) {
        Card card = deck.removeCard();
        player.takeCard(card);
    }

    public void shuffleDeck(Deck deck) {
        deck.randomOrder();
    }

    public void dealAllCards(Deck deck, Player player1, Player player2) {
        for (int cardsDealt = 0; cardsDealt < 26; cardsDealt +=1){
            Card card = deck.removeCard();
            player1.takeCard(card);
            player2.takeCard(card);

        }

    }
}
