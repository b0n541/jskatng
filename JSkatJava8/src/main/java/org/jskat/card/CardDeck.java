package org.jskat.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Random;

/**
 * Card deck
 */
public class CardDeck {

	private final Random random = new Random();
	private final List<Card> cards = new ArrayList<>(EnumSet.allOf(Card.class));

	/**
	 * Gets the cards of the deck.
	 *
	 * @return Cards of the deck
	 */
	public List<Card> getCards() {
		return new ArrayList<>(cards);
	}

	/**
	 * Shuffles the {@link CardDeck}.
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * Cuts the {@link CardDeck}.
	 *
	 * There must be at least four cards lifted up or left on the table.
	 */
	public void cut() {
		final int minCutIndex = 4;
		final int maxCutIndex = 28;
		final int cut = minCutIndex + random.nextInt(maxCutIndex - minCutIndex + 1);
		final List<Card> liftUp = new ArrayList<>(cards.subList(0, cut));
		final List<Card> leftOnTable = new ArrayList<>(cards.subList(cut, cards.size()));
		cards.clear();
		cards.addAll(leftOnTable);
		cards.addAll(liftUp);
	}

	@Override
	public String toString() {
		return "CardDeck [cards=" + cards + "]";
	}
}
