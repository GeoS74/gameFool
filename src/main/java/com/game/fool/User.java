package com.game.fool;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author geos
 */
public class User extends Player implements IPlayer {

    @Override
    public ICard getCard(List<ICard> cards) {
        if(this.cards.getCards().size() == 0) {
            return null;
        }
        
        int index = this.listen();
        
        if(index == -1) {
            System.out.println("game over");
            System.exit(0);
        }
        
        if(index == 0) {
            return null;
        }
        
        ICard card = this.cards.getCards().get(index-1);
        
        if(cards.size() == 0) {
            this.cards.delCard(card);
            return card;
        }
        
        for(ICard c: cards) {
            if(card.getWeightCode() == c.getWeightCode()) {
                this.cards.delCard(card);
                return card;
            }
        }
        System.out.println("так ходить нельзя");
        return this.getCard(cards); // recursive
    }

    @Override
    public ICard coverCard(ICard card, int suitCode) {
        int index = this.listen();
        
        if(index == -1) {
            System.out.println("game over");
            System.exit(0);
        }
        
        if(index == 0) {
            return null;
        }
        
        ICard c = this.cards.getCards().get(index-1);
        if(this.compareCards(card, c, suitCode)){
            this.cards.delCard(c);
            return c;
        }
        
        return this.coverCard(card, suitCode); // recursive
    }
    
    private int listen() {
        int res = -1;
        Scanner scan = new Scanner(System.in, "Windows-1251");

            while(true) {
                String str = scan.nextLine();
                
                if("q".equals(str) || "quit".equals(str)) {
                    break;
                }
                
                if("".equals(str)) {
                    res = 0;
                    break;
                }
                

                try {
                    int numberCard = Integer.parseInt(str, 10);
                    
                    if(numberCard <= this.cards.size()) {
                        res = numberCard;
                        break;
                    }
                }
                catch(NumberFormatException e) {}
            }
            
        return res;
    }
}
