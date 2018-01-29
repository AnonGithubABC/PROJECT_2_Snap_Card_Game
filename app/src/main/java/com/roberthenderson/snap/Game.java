package com.roberthenderson.snap;

import java.util.ArrayList;

/**
 * Created by user on 28/01/2018.
 */

public class Game {

    private ArrayList<Card> table;
    ArrayList<Player> players;
    Deck deck;
    Dealer dealer;
    Card card1;

    public Game(ArrayList<Player> players, Deck deck, Dealer dealer) {
        table = new ArrayList<>();
        this.players = players;
        this.deck = deck;
        this.dealer = dealer;
        this.card1 = card1;

    }

    public void gameStart(){
    dealer.dealAllCards(deck, players);
    }

    public ArrayList<Card> getTable() {
        return table;
    }

    public void tableAcceptsCard(Card card) {
        table.add(card);
    }

    public void playerPlays(Player player){
        Card card = player.removeCard();
        if (card != null) tableAcceptsCard(card);
    }


}
