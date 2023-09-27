package com.game.fool;

import java.util.List;

/**
 *
 * @author geos
 */
abstract public class Player implements IPlayer {
    private final ICardHand cards;

    public Player() {
        this.cards = new CardHand();
    }

    @Override
    abstract public ICard getCard();

    @Override
    abstract public ICard coverCard(ICard card);

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
}