package com.game.fool;

import java.util.List;

/**
 *
 * @author geos
 */
abstract public class Player implements IPlayer {
    final ICardHand cards;

    public Player() {
        this.cards = new CardHand();
    }

    @Override
    abstract public ICard getCard(List<ICard> cards);

    @Override
    abstract public ICard coverCard(ICard card, int suitCode);
    
    @Override
    public int countCards() {
        return this.cards.size();
    }

    @Override
    public void upCard(List<ICard> cards) {
        this.cards.addCard(cards);
    }
    
    @Override
    public void upCard(ICard card) {
        this.cards.addCard(card);
    }
    
    @Override
    public void showCards() {
        for(int i = 0; i < this.cards.getCards().size(); i++) {
            System.out.print("(" + (i+1) + ") " + this.cards.getCards().get(i) + " ");
        }
        System.out.print("\n");
    }
    
    protected boolean compareCards(ICard card_1, ICard card_2, int suitCode) {
        if(card_1.getSuitCode() == card_2.getSuitCode()) {
            return card_1.getWeightCode() < card_2.getWeightCode();
        }
        
        return card_2.getSuitCode() == suitCode;
    }
}
