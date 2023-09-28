package com.game.fool;

import java.util.ArrayList;
import java.util.Collections;

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
    int active = 1;
    ICardDeck cards;
    
    Game() {
        System.out.println("start new game\n");
        this.cards = new CardDeck();
        this.dealingCards();
        this.cards.setTrumpCard();
        int i = this.whoIsFirstStepp();
        if(i == -1) {
            System.out.println("нет козырей на руках");
        }
        this.active = i;
    }
    
    public void run() {
        while(true) {
            this.dealingCards();
            System.out.println("====================================\n");
            System.out.println("в колоде: " + this.cards.size() + " карт\n");
            System.out.println("козырь: " + this.cards.getTrumpCard() + "\n");
            
            int result = this.round();
            
            if(result == 1){
                this.active = this.active == 0 ? 1 : 0;
            }
        }
    }
    
    private int round() {
        ArrayList<ICard> stack = new ArrayList<>();
  
        int guardIdx = this.active == this.players.length-1 ? 0 : 1;
            
        while(true) {
            System.out.println("\n");
            System.out.println("у бота: " + this.players[1].countCards() + " карт\n");
            System.out.print("на руках: ");
            this.players[0].showCards();
            System.out.println("\n");
            
            if(this.active == 0) {
                System.out.print("твой ход: ");
            }
            else {
                System.out.print("бот ходит: ");
            }
            
            ICard card_1 = this.players[this.active].getCard(stack);
            if(card_1 == null) {
                System.out.println("всё, отбился");
                stack.clear();
                return 1;
            }
            
            stack.add(card_1);
            System.out.println(card_1);
            
            ICard card_2 = this.players[guardIdx]
                    .coverCard(card_1, this.cards.getTrumpCard().getSuitCode());
            
            if(card_2 == null) {
                System.out.println("не смог покрыться");
                this.players[guardIdx].upCard(stack);
                stack.clear();
                return 0;
            }
            
            stack.add(card_2);
            System.out.println(card_2);
        }
    }
    
    // кто ходит первым
    private int whoIsFirstStepp(){
        for(int i = 0; i < this.players.length; i++) {
            for(int w = 0; w < ICard.WEIGHTS.length; w++) {
                
                if(this.players[i].hasCard(new Card(this.cards.getTrumpCard().getSuitCode(), w))) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    // раздача карт
    private void dealingCards() {
        for(IPlayer p: this.players) {
            while(p.countCards() < 6) {
                ICard card = this.cards.getFirstCard();
                if(card == null) {
                    break;
                }
                p.upCard(card);
            }
        }
    }
}
