package com.game.fool;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geos
 */
public class CardHand implements ICardHand {
    private ArrayList<ICard> cards = new ArrayList<>(6);

    @Override
    public void sort() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addCard(ICard card) {
        this.cards.add(card);
    }

    @Override
    public void addCard(List<ICard> cards) {
        this.cards.addAll(cards);
    }

    @Override
    public ArrayList<ICard> getCards() {
        return this.cards;
    }

    @Override
    public int size() {
        return this.cards.size();
    }
    
    @Override
    public String toString() {
        return this.cards.toString();
    }
}
