package com.roberthenderson.snap;

import java.util.ArrayList;

/**
 * Created by user on 28/01/2018.
 */

public class Game {

    private ArrayList<Card> table;
    Player player1;
    Player player2;
    Deck deck;
    Dealer dealer;

    public Game(Player player1, Player player2, Deck deck, Dealer dealer) {
        table = new ArrayList<>();
        this.player1 = player1;
        this.player2 = player2;
        this.deck = deck;
        this.dealer = dealer;

    }

    public void gameStart(){
    dealer.dealAllCards(deck, player1, player2);
    }

    public ArrayList<Card> getTable() {
        return table;
    }

    public int getNumberOfCardsInTable(){
        return table.size();
    }

    public void tableAcceptsCard(Card card) {
        table.add(card);
    }

    public void player1Plays(){

    }

    public void player2Plays(){

    }

}
