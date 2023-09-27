package com.game.fool;

import java.util.List;

/**
 *
 * @author geos
 */
public class Bot extends Player implements IPlayer {

    @Override
    public ICard getCard(List<ICard> stack) {
        if(this.cards.getCards().size() == 0) {
            return null;
        }
        
        if(stack.size() == 0) {
            int index = Bot.rnd(0, this.cards.getCards().size()-1);
            ICard card = this.cards.getCards().get(index);
            this.cards.delCard(card);
            return card;
        }
        
        for(ICard c: this.cards.getCards()) {
            for(ICard s: stack) {
                if(s.getWeightCode() == c.getWeightCode()) {
                    this.cards.delCard(c);
                    return c;
                }
            }
        }
        
        return null;
    }

    @Override
    public ICard coverCard(ICard card, int suitCode) {
        for(ICard c: this.cards.getCards()) {
            if(this.compareCards(card, c, suitCode)){
                this.cards.delCard(c);
                return c;
            }
        }
        return null;
    }
    
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
}
