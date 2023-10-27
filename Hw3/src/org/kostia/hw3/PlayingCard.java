package org.kostia.hw3;

import java.util.Comparator;

public record PlayingCard(Rank rank, Suit suit) implements Comparable<PlayingCard> {

    public PlayingCard {
        if( rank == null){
            throw new IllegalArgumentException("null 'rank' detected");
        }

        if( suit == null){
            throw new IllegalArgumentException("null 'suit' detected");
        }
    }

    /**
     * cards are sorted after suit and rank.
     */
    @Override
    public int compareTo(PlayingCard other) {
       int cmp = suit.compareTo(other.suit);

       if( cmp != 0 ){
           return cmp;
       }

       return rank.compareTo(other.rank);

//        return Comparator.comparing(PlayingCard::suit)
//                .thenComparing(PlayingCard::rank)
//                .compare(this, other);
    }


    @Override
    public String toString() {
        return String.valueOf(rank) + suit;
    }
}
