package org.kostia.hw3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    // 5, d, 1, 2, 3, 4
    // a, b, c
    private final List<PlayingCard> cards = new ArrayList<>();

    public void addCard(PlayingCard newCard){
        cards.add(0, newCard);
    }
    public PlayingCard removeCard(){
        if( cards.isEmpty() ){
            throw new IllegalStateException("Deck is empty, can't remove card");
        }

        return cards.remove(cards.size()-1);
    }
    public void shuffle(){
        Collections.shuffle(cards);
    }

    public void sort(){
        Collections.sort(cards);
    }

    public int cardsCount(){
        return cards.size();
    }

    @Override
    public String toString() {
        return String.valueOf(cards);
    }
}
