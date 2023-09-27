package com.game.fool;

import java.util.Scanner;

/**
 *
 * @author geos
 */
public class User extends Player implements IPlayer {

    @Override
    public ICard getCard() {
        if(this.cards.getCards().size() == 0) {
            return null;
        }
        
        int index = this.listen();
        
        if(index == -1) {
            System.out.println("game over");
            System.exit(0);
        }
        
        return this.cards.getCards().get(index);
    }

    @Override
    public ICard coverCard(ICard card, int suitCode) {
        int index = this.listen();
        
        if(index == -1) {
            System.out.println("game over");
            System.exit(0);
        }
        
        ICard c = this.cards.getCards().get(index);
        if(this.compareCards(card, c, suitCode)){
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

                try {
                    int numberCard = Integer.parseInt(str, 10);
                    
                    if(numberCard <= this.cards.size()) {
                        res = numberCard - 1;
                        break;
                    }
                }
                catch(NumberFormatException e) {}
            }
            
        return res;
    }
}
