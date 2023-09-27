package com.game.fool;

import java.util.ArrayList;

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
        ArrayList<ICard[]> table = new ArrayList<>();
        
        if(this.active == 0) {
                System.out.println("твой ход");
            }
        else {
            System.out.println("бот ходит");
        }
            
            
        int guardIdx = this.active == this.players.length ? 0 : 1;
            
        while(true) {
            ICard card_1 = this.players[this.active].getCard();
            if(card_1 == null) {
                System.out.println("всё, отбился");
                table.clear();
                return 0;
            }
            
            System.out.print(card_1);
            
            ICard card_2 = this.players[guardIdx]
                    .coverCard(card_1, this.cards.getTrumpCard().getSuitCode());
            
            if(card_2 == null) {
                System.out.println("не смог покрыться");
                table.clear();
                return 0;
            }
            System.out.println(card_2);
            
            ICard[]  couple = {card_1, card_2};
            table.add(couple);
        }
    }
}
