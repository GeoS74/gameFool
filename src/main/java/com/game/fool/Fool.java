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
    IPlayer[] players = {new User(), new Bot()};
    int active = 0;
    ICardDeck cards;
    
    Game() {
        System.out.println("start new game\n");
        this.cards = new CardDeck();
        for(int i = 0; i < this.players.length * 6; i++) {
            if(i % 2 == 0) {
                this.players[0].upCard(this.cards.getFirstCard());
                continue;
            }
            this.players[1].upCard(this.cards.getFirstCard());
        }
        ICard t = this.cards.getFirstCard();
        this.cards.getCards().offerLast(t);
        
        System.out.println("козырь:" + this.cards.getTrumpCard() + "\n");
        this.players[0].showCards();
        this.run();
    }
    
    private void run() {
        while(true) {
            break;
        }
    }
}
