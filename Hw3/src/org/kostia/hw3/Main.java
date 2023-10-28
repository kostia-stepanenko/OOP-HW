package org.kostia.hw3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Deck deck = newDeck();
        System.out.printf("before: %s %n", deck);

        deck.shuffle();
        System.out.printf("after shuffle: %s %n", deck);

        deck.sort();
        System.out.printf("after sorting: %s %n", deck);

        int gamesCount = 10;

        int minMoves = Integer.MAX_VALUE;
        int maxMoves = Integer.MIN_VALUE;

        int totalMovesCnt = 0;

        for (int it = 0; it < gamesCount; ++it) {
            int curMovesCount = playWarGameFor4Players();

            totalMovesCnt += curMovesCount;

            minMoves = Math.min(minMoves, curMovesCount);
            maxMoves = Math.max(maxMoves, curMovesCount);
        }

        System.out.printf("min: %d, max: %d, mean: %.1f %n",
                minMoves, maxMoves, ((double) totalMovesCnt / gamesCount));

        System.out.println("Hw3 done.");
    }

    private static int playWarGameFor4Players() {

        final int playersCount = 4;

        Deck fullDeck = newDeck();
        fullDeck.shuffle();

        int cardsPerPerPlayer = fullDeck.cardsCount() / playersCount;

        Deck[] playerDecks = new Deck[playersCount];

        for (int i = 0; i < playerDecks.length; ++i) {
            playerDecks[i] = new Deck();

            for (int j = 0; j < cardsPerPerPlayer; ++j) {
                playerDecks[i].addCard(fullDeck.removeCard());
            }
        }

        int movesCnt = 0;

        while (true) {

            if( movesCnt > 10_000){
                System.err.println("Too many iteration of a game detected. Skipping one.");
                break;
            }

            if (!allHasCards(playerDecks)) {
                break;
            }

            MoveState state = new MoveState(List.of(playerDecks[0], playerDecks[1],
                    playerDecks[2], playerDecks[3]));

            boolean firstMove = true;
            while( ! state.isFinalState() ){
                state.makeMove(firstMove);
                ++movesCnt;
                firstMove = false;
            }

            Deck stepWinner = state.getWinnerDeck();

            for( PlayingCard singleCard : state.getCardsOnTable() ){
                stepWinner.addCard(singleCard);
            }
        }

        return movesCnt;
    }

    static class MoveState {

        final List<Deck> leftDecks;
        final List<PlayingCard> cardsOnTable;

        public MoveState(List<Deck> leftDecks) {
            this.leftDecks = new ArrayList<>(leftDecks);
            this.cardsOnTable = new ArrayList<>();
        }

        boolean isFinalState(){
            if( leftDecks.size() == 0 ){
                throw new IllegalStateException("All decks empty. No winner.");
            }
            return leftDecks.size() == 1;
        }

        void makeMove(boolean firstMove){
            List<PlayingCard> cardsToCompare = new ArrayList<>();

            Iterator<Deck> deckIt1 = leftDecks.iterator();
            while( deckIt1.hasNext() ){

                Deck curDeck = deckIt1.next();

                if( firstMove ) {
                    if (curDeck.cardsCount() == 0) {
                        deckIt1.remove();
                    } else {
                        cardsToCompare.add(curDeck.removeCard());
                    }
                }
                else {
                    // WAR move started
                    /*
                     * Most descriptions of War are unclear about what happens if a player runs out of cards
                     * during a war. In some variants, that player immediately loses.
                     */
                    if (curDeck.cardsCount() == 0) {
                        deckIt1.remove();
                    }
                    else if (curDeck.cardsCount() == 1) {
                        cardsOnTable.add(curDeck.removeCard());
                        deckIt1.remove();
                    }
                    else {
                        cardsOnTable.add(curDeck.removeCard());
                        cardsToCompare.add(curDeck.removeCard());
                    }
                }
            }

            if( leftDecks.isEmpty() ){
                throw new IllegalStateException("All decks empty. No winner!!!");
            }

            cardsOnTable.addAll(cardsToCompare);

            Rank maxRank = findMaxRank(cardsToCompare);

            Iterator<Deck> deckIt2 = leftDecks.iterator();
            for(int i = 0; i < cardsToCompare.size() && deckIt2.hasNext() ; ++i){
                deckIt2.next();

                if( cardsToCompare.get(i).rank() != maxRank ){
                    deckIt2.remove();
                }
            }
        }

        private Rank findMaxRank(List<PlayingCard> newCards) {
            Rank max = newCards.get(0).rank();

            for(int i = 1; i < newCards.size(); ++i){
                PlayingCard curCard = newCards.get(i);
                if( curCard.rank().compareTo(max) > 0){
                    max = curCard.rank();
                }
            }

            return max;
        }

        List<PlayingCard> getCardsOnTable() {
            return cardsOnTable;
        }

        Deck getWinnerDeck() {
            return leftDecks.get(0);
        }
    }

    private static boolean allHasCards(Deck[] playerDecks) {
        for (Deck deck : playerDecks) {
            if (deck.cardsCount() == 0) {
                return false;
            }
        }

        return true;
    }

    private static Deck newDeck() {
        Deck deck = new Deck();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.addCard(new PlayingCard(rank, suit));
            }
        }
        return deck;
    }
}