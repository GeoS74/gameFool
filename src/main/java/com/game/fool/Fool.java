/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.game.fool;

/**
 *
 * @author geos
 */
public class Fool {
    public static void main(String[] args) {
         Game game = new Game();
    }
}

class Game {
    int trump;
    IPlayer[] players = {new User(), new Bot()};
    int active = 0;
    
    {
        System.out.println("start new game");
        ICardDeck cardDeck = new CardDeck();
        for(int i = 0; i < this.players.length * 6; i++) {
            if(i % 2 == 0) {
                this.players[0].upCard(cardDeck.getFirstCard());
                continue;
            }
            this.players[1].upCard(cardDeck.getFirstCard());
        }
        
        this.players[0].showCards();
    }
}
