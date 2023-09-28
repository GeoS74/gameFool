package com.game.fool;

import java.util.List;

/**
 *
 * @author geos
 */
public interface IPlayer {
    int countCards();
    ICard getCard(List<ICard> cards);
    ICard coverCard(ICard card, int suitCode);
    void upCard(List<ICard> cards);
    void upCard(ICard card);
    void showCards();
    boolean hasCard(ICard card);
}

