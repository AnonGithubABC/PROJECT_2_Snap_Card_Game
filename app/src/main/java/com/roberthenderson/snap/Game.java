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
        this.table = new ArrayList<>();
        this.players = players;
        this.deck = deck;
        this.dealer = dealer;
        this.card1 = card1;

    }

    public void gameStart() {
        dealer.dealAllCards(deck, players);
    }

    public ArrayList<Card> getTable() {
        return table;
    }

    public void tableAcceptsCard(Card card) {
        table.add(card);
    }


    public void removeCardFromTable(Card card) {
        this.table.remove(card);
    }


    public void playerPlays(Player player) {
        Card card = player.removeCard();
        if (card != null) tableAcceptsCard(card);
    }


    public Boolean checksWhenRanksMatch() {
        int lastIndex = this.table.size() - 1;
        int secondLastIndex = this.table.size() - 2;
        if (this.table.get(lastIndex).getRank() == this.table.get(secondLastIndex).getRank()) {
            return true;
        }
        return false;
    }


    public void callSnap(Player player) {
        while (checksWhenRanksMatch() == true && this.table.size() > 0) {
                Card card = this.table.remove(card);
            if (card != null) player.takeCard(card);
            }


        }


}



