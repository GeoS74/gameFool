package com.game.fool;

import java.util.List;

/**
 *
 * @author geos
 */
public class User implements IPlayer {
    private final ICardHand cards;

    public User() {
        this.cards = new CardHand();
    }

    @Override
    public ICard getCard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ICard coverCard(ICard card) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            System.out.print((i+1) + ": " + this.cards.getCards().get(i) + " ");
        }
    }
}
