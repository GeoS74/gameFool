package com.game.fool;

/**
 *
 * @author geos
 */
public class Fool {
    public static void main(String[] args) {
        System.out.println("start new game");
        Game game = new Game();
    }
}

class Game {
    int trump;
    IPlayer[] players = {new User(), new Bot()};
    int active = 0;
    
    Game() {
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
