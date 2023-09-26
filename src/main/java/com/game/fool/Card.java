package com.game.fool;

/**
 *
 * @author geos
 */
public class Card implements ICard {
    private int suit;
    private int weight;
    
    Card(int suit, int weight) {
        this.suit = suit;
        this.weight = weight;
    }

    @Override
    public String getSuit() {
        return ICard.SUITS[this.suit];
    }

    @Override
    public String getWeight() {
        return ICard.WEIGHTS[this.weight];
    }

    @Override
    public int getSuitCode() {
        return this.suit;
    }

    @Override
    public int getWeightCode() {
        return this.weight;
    }
    
    @Override
    public String toString() {
        return "\"" + this.getWeight() + " " + this.getSuit() + "\"";
    }
    
//    @Override
//    public int compareTo(Card o) {
//        if(this.weight != o.getWeight()) {
//            return this.weight - o.getWeight();
//        }
//        return this.suit - o.getSuit();   
//    }
}
