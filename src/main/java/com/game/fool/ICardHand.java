package com.game.fool;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author geos
 */
public interface ICardHand extends ICardList {
    void sort();
    void addCard(ICard card);
    void addCard(List<ICard> card);
    void delCard(ICard card);
    ArrayList<ICard> getCards();
    @Override
    int size();
}
