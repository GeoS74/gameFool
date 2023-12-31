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
    private final Deque<ICard> cards;
    private ICard trumpCard;
    
    CardDeck() {
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
    public ICard getTrumpCard() {
        return this.trumpCard;
    }
    
    @Override
    public void setTrumpCard() {
        ICard c = this.getFirstCard();
        this.trumpCard = c;
        this.cards.addLast(c);
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
