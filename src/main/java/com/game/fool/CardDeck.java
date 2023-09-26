package com.game.fool;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

/**
 *
 * @author geos
 */
public class CardDeck implements ICardDeck {
    private Deque<ICard> cards;
    
    {
        ArrayList<Card> c = new ArrayList<>(36);
        
        for(int s = 0; s < ICard.SUITS.length; s++) {
            for(int w = 0; w < ICard.WEIGHTS.length; w++) {
                c.add(new Card(s, w));
            }
        }
        Collections.shuffle(c);
        this.cards = new ArrayDeque<>(c);
    }

    @Override
    public ICard getFirstCard() {
        return this.cards.pollFirst();
    }

    @Override
    public Deque<ICard> getCards() {
        return this.cards;
    }

    @Override
    public int size() {
        return this.cards.size();
    } 
}
