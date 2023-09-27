package com.game.fool;

import java.util.List;

/**
 *
 * @author geos
 */
public interface IPlayer {
    ICard getCard();
    ICard coverCard(ICard card, int suitCode);
    void upCard(List<ICard> cards);
    void upCard(ICard card);
    void showCards();
}

