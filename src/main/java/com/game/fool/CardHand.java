package com.game.fool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author geos
 */
public class CardHand implements ICardHand {
    private final ArrayList<ICard> cards;

    public CardHand() {
        this.cards = new ArrayList<>(6);
    }

    @Override
    public void sort() {
        Collections.sort(this.cards); 
    }

    @Override
    public void addCard(ICard card) {
        this.cards.add(card);
        this.sort();
    }

    @Override
    public void addCard(List<ICard> cards) {
        this.cards.addAll(cards);
        this.sort();
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

    @Override
    public void delCard(ICard card) {
        this.cards.remove(card);
    }
}
