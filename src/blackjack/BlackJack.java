/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

/**
 *
 * @author vip b
 */

public class BlackJack {

    static Game  g = new Game();
    public static void main(String[] args) {
        GUI gui=new GUI();
        
        g.generation();
        g.setInfoOfPlayers();
        gui.runGUI(g.getArrOfAllCards(), g.getArrOfPlayers()[0].getArrOfCards(),g.getArrOfPlayers()[1].getArrOfCards(),g.getArrOfPlayers()[2].getArrOfCards(), g.getArrOfPlayers()[3].getArrOfCards());
        g.play();
        g.finalResult();
        
    }

}
