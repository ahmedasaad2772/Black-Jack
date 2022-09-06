
package blackjack;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author vip b
 */
public class Game {
    GUI gui = new GUI();

    Scanner input = new Scanner(System.in);
    private final Player[] arrOfPlayers = new Player[4]; // Array of 4 players
    private final Card[] arrOfAllCards = new Card[52]; // Array of cards for the card deck
    private int maxScore; // A variable that keeps track of the existing VALID high score of all players
    private int indexMaxScore; // Variable to put in which the player has the high score

    // default constructor
    public Game() {
        maxScore = 0;
        indexMaxScore = -1;
    }

    public Player[] getArrOfPlayers() {
        return arrOfPlayers;
    }

    public Card[] getArrOfAllCards() {
        return arrOfAllCards;
    }

    public int getMaxScore() {
        return maxScore;
    }

    // A function that generates the card deck array
    public void generation() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                int rank, value, suit;
                rank = j;
                if (rank >= 9)
                    value = 10;
                else
                    value = rank + 1;
                suit = i;
                arrOfAllCards[j + (i * 13)] = new Card(rank, value, suit);
            }
        }
    }

    // A function that draws a card randomly from the card deck array
    public Card drawCard() {
        Random random = new Random();
        int rand = random.nextInt(52);
        if (arrOfAllCards[rand] == null) {
            return drawCard();
        } else {
            Card card = arrOfAllCards[rand];
            arrOfAllCards[rand] = null;
            return card;
        }

    }

    /*
     * A function that sets the information of the players (take names from the user
     * and draw 2 random cards for each player) at the beginning of the game
     */
    public void setInfoOfPlayers() {
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter The Name Of The Player Number " + (i + 1) + " :");
            String name = input.nextLine();
            arrOfPlayers[i] = new Player(name);
            for (int j = 0; j < 2; j++) {
                arrOfPlayers[i].addCard(drawCard());
                gui.updatePlayerHand(arrOfPlayers[i].getArrOfCards()[arrOfPlayers[i].getNumOfCards() - 1], i);

            }
        }
        String name = "delar";
        arrOfPlayers[3] = new Player(name);
        for (int j = 0; j < 2; j++) {
            arrOfPlayers[3].addCard(drawCard());
            gui.updateDealerHand(arrOfPlayers[3].getArrOfCards()[arrOfPlayers[3].getNumOfCards() - 1], arrOfAllCards);
        }

    }

    /*
     * A function to update the game maximum score of all players after any player
     * draw a card to his hand.
     */
    public void updateMaxScore(int score, int index) {
        maxScore = score;
        indexMaxScore = index;
    }

    public void play() {
        // play for 3 players
        for (int i = 0; i < 3; i++) {
            System.out.println("The Name Of Player To Play : " + arrOfPlayers[i].getName());
            System.out.println("His Score is : " + arrOfPlayers[i].getScore());

            char choice;
            System.out.println("1-Hit\t2-Stand");
            choice = input.next().charAt(0);
            while (choice == '1') {
                arrOfPlayers[i].addCard(drawCard());
                gui.updatePlayerHand(arrOfPlayers[i].getArrOfCards()[arrOfPlayers[i].getNumOfCards() - 1], i);

                System.out.println("His Score Is : " + arrOfPlayers[i].getScore());
                if (arrOfPlayers[i].isBasted() == true || arrOfPlayers[i].isBlackJack() == true)
                    break;
                System.out.println("1-Hit\t2-Stand");
                choice = input.next().charAt(0);

            }
            if ((arrOfPlayers[i].getScore() > maxScore && arrOfPlayers[i].isBasted() == false)
                    || (arrOfPlayers[i].isBlackJack() == true))
                updateMaxScore(arrOfPlayers[i].getScore(), i);

            if (arrOfPlayers[i].isBasted() == true)
                System.out.println(arrOfPlayers[i].getName() + " is Basted");
            else if (arrOfPlayers[i].isBlackJack() == true)
                System.out.println(arrOfPlayers[i].getName() + " get BlackJack");
            System.out.println("------------------------------------");

        }
        // play for dealer
        System.out.println("The " + arrOfPlayers[3].getName() + " Will Play");
        System.out.println("His Score is : " + arrOfPlayers[3].getScore());
        while (arrOfPlayers[3].isBlackJack() == false && arrOfPlayers[3].isBasted() == false
                && arrOfPlayers[3].getScore() <= maxScore)

        {
            arrOfPlayers[3].addCard(drawCard());
            gui.updateDealerHand(arrOfPlayers[3].getArrOfCards()[arrOfPlayers[3].getNumOfCards() - 1], arrOfAllCards);

            System.out.println("His Score Is : " + arrOfPlayers[3].getScore());
        }
        if ((arrOfPlayers[3].getScore() > maxScore && arrOfPlayers[3].isBasted() == false)
                || (arrOfPlayers[3].isBlackJack() == true))
            updateMaxScore(arrOfPlayers[3].getScore(), 3);
        if (arrOfPlayers[3].isBasted() == true)
            System.out.println(arrOfPlayers[3].getName() + " is Basted");
        else if (arrOfPlayers[3].isBlackJack() == true)
            System.out.println(arrOfPlayers[3].getName() + " get BlackJack");
        System.out.println("------------------------------------");

    }

    // A function to decide Who in the game won or it’s a PUSH.
    public void finalResult() {
        int x = 0;
        for (int i = 0; i < 4; i++) {
            if (arrOfPlayers[i].getScore() == maxScore)
                x++;
        }
        if (x == 1)
            System.out.println("The Winner is " + arrOfPlayers[indexMaxScore].getName());
        else
            System.out.println("PUSH");
    }

}
