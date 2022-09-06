/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author vip b
 */
public class Card {

    private final int rank;
    private final int value;
    private final int suit;

    // Parameterized constructor that sets all the attributes
    public Card(int rank, int value, int suit) {
        this.rank = rank;
        this.value = value;
        this.suit = suit;
    }

    // Copy constructor
    public Card(Card card) {
        this.rank = card.rank;
        this.value = card.value;
        this.suit = card.suit;
    }

    // Getters for the attributes

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

}
