package com.game.fool;

import java.util.Deque;

/**
 *
 * @author geos
 */
public interface ICardDeck extends ICardList {
    ICard getFirstCard();
    ICard getTrumpCard();
    Deque<ICard> getCards();
    @Override
    int size();
}
