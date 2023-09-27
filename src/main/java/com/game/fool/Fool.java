package com.game.fool;

/**
 *
 * @author geos
 */
public class Fool {
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
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
    }
    
    public void run() {
        this.round();
//        while(true) {
//            break;
//        }
    }
    
    private int round() {
        while(true) {
            if(this.active == 0) {
                System.out.println("твой ход");
            }
            System.out.println("бот ходит");
            
            
            int guardIdx = this.active == this.players.length ? 0 : 1;
            
            ICard card_1 = this.players[this.active].getCard();
//            ICard card_2 = this.players[guardIdx].getCard();
            
            break;
        }
        
        return 0;
    }
}
