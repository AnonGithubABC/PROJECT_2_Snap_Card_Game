package com.roberthenderson.snap;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by user on 26/01/2018.
 */

class Dealer {


    public void dealCard(Deck deck, Player player) {
        Card card = deck.removeCard();
        player.takeCard(card);
    }

    public void dealAllCards(Deck deck, ArrayList<Player> players) {
//        for (Player player : players){
//            for (int cardsDealt = 0; cardsDealt < 26; cardsDealt +=1) {
//                Card card = deck.removeCard();
//                player.takeCard(card);

        while(deck.getSize() > 0){
            Card card1 = deck.removeCard();
            Card card2 = deck.removeCard();
            players.get(0).takeCard(card1);
            players.get(1).takeCard(card2);
        }



        }




    }


//
//
//        // make a player take the card
//    }

