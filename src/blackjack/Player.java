/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author vip b
 */
public class Player {

    private final String name; // name of player
    private int score; // score of player
    private int numOfCards; // number of cards the player have
    private final Card[] arrOfCards = new Card[11];
    private boolean blackJack;
    private boolean basted;

    // Parameterized constructor that sets the name of player
    // and give him score and number of cards equal zero
    public Player(String name) {
        this.name = name;
        numOfCards = score = 0;
    }

    // A funciont to update the score of player
    public void updateScore(Card c) {
        score += c.getValue();
    }

    // A function to get the player one card
    public void addCard(Card c) {
        arrOfCards[numOfCards] = c;
        updateScore(c);
        if (score == 21)
            blackJack = true;
        else if (score > 21)
            basted = true;
        numOfCards++;
    }

    public void setBlackJack() {
        blackJack = true;
    }

    public void setBasted() {
        basted = true;
    }

    // Getters for the attributes

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getNumOfCards() {
        return numOfCards;
    }

    public Card[] getArrOfCards() {
        return arrOfCards;
    }

    public boolean isBlackJack() {
        return blackJack;
    }

    public boolean isBasted() {
        return basted;
    }

}
