package com.roberthenderson.snap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by user on 28/01/2018.
 */

public class Game {

    private ArrayList<Card> table;
    ArrayList<Player> players;
    Deck deck;
    Dealer dealer;
    Card card1;
    int cardsToBeWon;
    Player activePlayer;

    public Game(ArrayList<Player> players, Deck deck, Dealer dealer) {
        this.table = new ArrayList<>();
        this.players = players;
        this.deck = deck;
        this.dealer = dealer;
        this.card1 = card1;
        this.cardsToBeWon = deck.getSize();
    }

    // TODO: 31/01/2018 Set up game to have an active player - switch players in array to change them

    public Player getActivePlayer(){
        return this.players.get(0);
    }

    public void swapActivePlayer(){
        Collections.swap(this.players, 0,  1);
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


    public Card playerPlays(Player player) {
        Card card = player.removeCard();
        if (card != null) tableAcceptsCard(card);
        swapActivePlayer();
        // TODO: 31/01/2018 switch active players here
        return card;
    }


    public Boolean checksWhenRanksMatch() {
        if (this.table.size() < 2)
            return false;
        int lastIndex = this.table.size() - 1;
        int secondLastIndex = this.table.size() - 2;
        if (this.table.get(lastIndex).getRank() == this.table.get(secondLastIndex).getRank()) {
            return true;
        }
        return false;
    }

    public void callSnap(Player player) {
        if (checksWhenRanksMatch()) {
            player.winCards(this.table);
            this.table.clear();
        }
    }

    public String gameIsADraw(Player player1, Player player2) {
        if (player1.getNumberOfCards() < 1 && player2.getNumberOfCards() < 1) {
            return "Game is a draw";
        }
        return null;
    }


    public Player checkWinner(){
        Player winner = null;
        for (Player player : players){
            if (player.getNumberOfCards() == cardsToBeWon){
                winner = player;
            }
            else if (player.getNumberOfCards() == 0 && checksWhenRanksMatch() == false) {
                winner = players.get(0);
            }
        }
        return winner;
    }

    public Card lastCardPlayedOnTable(){
        int index = this.table.size() -1;
        Card lastCard = this.table.get(index);
        return lastCard;
    }
}



