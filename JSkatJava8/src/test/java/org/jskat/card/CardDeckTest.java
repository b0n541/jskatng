package org.jskat.card;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;

public class CardDeckTest {

	@Test
	public void testSize() {
		assertThat(new CardDeck().getCards().size()).as("Size of card deck").isEqualTo(32);
	}

	@Test
	public void testShuffle() {
		final CardDeck deck = new CardDeck();
		final List<Card> unShuffeled = deck.getCards();
		deck.shuffle();
		final List<Card> shuffeled = deck.getCards();

		assertThat(shuffeled)
				.as("Shuffled cards should contain all cards")
				.containsAll(unShuffeled)
				.as("Shuffeled cards should have different order")
				.doesNotContainSequence(unShuffeled);
	}

	@Test
	public void testCut() {
		final CardDeck deck = new CardDeck();
		final List<Card> unCut = deck.getCards();
		deck.cut();
		final List<Card> cut = deck.getCards();

		assertThat(cut)
				.as("Cut cards should contain all cards")
				.containsAll(unCut)
				.as("Cut cards should contain sequence")
				.containsSequence(Card.DJ, Card.D9, Card.D8, Card.D7, Card.CA, Card.CT, Card.CK, Card.CQ);
	}

	@Test
	public void testShuffleAndCut() {
		final CardDeck deck = new CardDeck();
		final List<Card> unShuffeled = deck.getCards();
		deck.shuffle();
		final List<Card> shuffeled = deck.getCards();
		deck.cut();
		final List<Card> cut = deck.getCards();

		assertThat(cut)
				.as("Cut cards should contain all cards")
				.containsAll(unShuffeled)
				.as("Cut cards should contain all cards")
				.containsAll(shuffeled)
				.as("Cut cards should have different order")
				.doesNotContainSequence(unShuffeled)
				.as("Cut cards should have different order")
				.doesNotContainSequence(shuffeled);
	}
}