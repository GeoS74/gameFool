/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.game.fool;

/**
 *
 * @author geos
 */
public class Fool {

    public static void main(String[] args) {
        System.out.println("start new game");
        
        ICardDeck cardDeck = new CardDeck();
        
        System.out.println(cardDeck.size());
        System.out.println(cardDeck.getCards());
    }
}
