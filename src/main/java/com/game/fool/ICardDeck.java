package com.game.fool;

import java.util.Deque;

/**
 *
 * @author geos
 */
public interface ICardDeck extends ICardList {
    ICard getFirstCard();
    ICard getTrumpCard();
    void setTrumpCard();
    Deque<ICard> getCards();
    @Override
    int size();
}
