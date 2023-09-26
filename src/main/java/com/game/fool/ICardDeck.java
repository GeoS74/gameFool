package com.game.fool;

import java.util.Deque;

/**
 *
 * @author geos
 */
public interface ICardDeck extends ICardList {
    ICard getFirstCard();
    Deque<ICard> getCards();
}
