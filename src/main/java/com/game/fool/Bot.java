package com.game.fool;

/**
 *
 * @author geos
 */
public class Bot extends Player implements IPlayer {

    @Override
    public ICard getCard() {
        if(this.cards.getCards().size() == 0) {
            return null;
        }
        
        int index = Bot.rnd(0, this.cards.getCards().size()-1);
        return this.cards.getCards().get(index);
    }

    @Override
    public ICard coverCard(ICard card, int suitCode) {
        for(ICard c: this.cards.getCards()) {
            if(this.compareCards(card, c, suitCode)){
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
