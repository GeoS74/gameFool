package com.game.fool;

import java.util.ArrayList;

/**
 *
 * @author geos
 */
public interface ICardHand extends ICardList {
    void sort();
    void addCard(ICard card);
    ArrayList<ICard> getCards();
}
