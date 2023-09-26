package com.game.fool;

/**
 *
 * @author geos
 */
public interface ICard extends Comparable<ICard>{
    String[] SUITS = {"Червы", "Бубны", "Трефы", "Пики"};
    String[] WEIGHTS = {"6", "7", "8", "9", "10", "В", "Д", "К", "Т"};
    
    String getSuit();
    String getWeight();
    int getSuitCode();
    int getWeightCode();
    @Override
    String toString();
    @Override
    int compareTo(ICard o);
}
