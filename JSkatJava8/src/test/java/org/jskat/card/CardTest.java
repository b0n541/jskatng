package org.jskat.card;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.util.Arrays;
import java.util.List;

import org.jskat.card.Card.Rank;
import org.jskat.card.Card.Suit;
import org.junit.Test;

public class CardTest {

	@Test
	public void testNumberOfCards() {
		assertThat(Card.values())
				.hasSize(32)
				.containsExactly(
						Card.CA, Card.CT, Card.CK, Card.CQ, Card.CJ, Card.C9, Card.C8, Card.C7,
						Card.SA, Card.ST, Card.SK, Card.SQ, Card.SJ, Card.S9, Card.S8, Card.S7,
						Card.HA, Card.HT, Card.HK, Card.HQ, Card.HJ, Card.H9, Card.H8, Card.H7,
						Card.DA, Card.DT, Card.DK, Card.DQ, Card.DJ, Card.D9, Card.D8, Card.D7);
	}

	@Test
	public void testClubsCards() {
		final List<Card> clubsCards = Arrays.asList(Card.CA, Card.CT, Card.CK, Card.CQ, Card.CJ, Card.C9, Card.C8,
				Card.C7);

		assertThat(clubsCards)
				.extracting("suit", "rank")
				.containsExactly(
						tuple(Suit.CLUBS, Rank.ACE),
						tuple(Suit.CLUBS, Rank.TEN),
						tuple(Suit.CLUBS, Rank.KING),
						tuple(Suit.CLUBS, Rank.QUEEN),
						tuple(Suit.CLUBS, Rank.JACK),
						tuple(Suit.CLUBS, Rank.NINE),
						tuple(Suit.CLUBS, Rank.EIGHT),
						tuple(Suit.CLUBS, Rank.SEVEN));
		assertThat(clubsCards.stream().mapToInt(Card::getValue).sum()).isEqualTo(30);
	}

	@Test
	public void testSpadesCards() {
		final List<Card> spadesCards = Arrays.asList(Card.SA, Card.ST, Card.SK, Card.SQ, Card.SJ, Card.S9, Card.S8,
				Card.S7);

		assertThat(spadesCards)
				.extracting("suit", "rank")
				.containsExactly(
						tuple(Suit.SPADES, Rank.ACE),
						tuple(Suit.SPADES, Rank.TEN),
						tuple(Suit.SPADES, Rank.KING),
						tuple(Suit.SPADES, Rank.QUEEN),
						tuple(Suit.SPADES, Rank.JACK),
						tuple(Suit.SPADES, Rank.NINE),
						tuple(Suit.SPADES, Rank.EIGHT),
						tuple(Suit.SPADES, Rank.SEVEN));
		assertThat(spadesCards.stream().mapToInt(Card::getValue).sum()).isEqualTo(30);
	}

	@Test
	public void testHeartsCards() {
		final List<Card> heartsCards = Arrays.asList(Card.HA, Card.HT, Card.HK, Card.HQ, Card.HJ, Card.H9, Card.H8,
				Card.H7);

		assertThat(heartsCards)
				.extracting("suit", "rank")
				.containsExactly(
						tuple(Suit.HEARTS, Rank.ACE),
						tuple(Suit.HEARTS, Rank.TEN),
						tuple(Suit.HEARTS, Rank.KING),
						tuple(Suit.HEARTS, Rank.QUEEN),
						tuple(Suit.HEARTS, Rank.JACK),
						tuple(Suit.HEARTS, Rank.NINE),
						tuple(Suit.HEARTS, Rank.EIGHT),
						tuple(Suit.HEARTS, Rank.SEVEN));
		assertThat(heartsCards.stream().mapToInt(Card::getValue).sum()).isEqualTo(30);
	}

	@Test
	public void testDiamondsCards() {
		final List<Card> diamondsCards = Arrays.asList(Card.DA, Card.DT, Card.DK, Card.DQ, Card.DJ, Card.D9, Card.D8,
				Card.D7);

		assertThat(diamondsCards)
				.extracting("suit", "rank")
				.containsExactly(
						tuple(Suit.DIAMONDS, Rank.ACE),
						tuple(Suit.DIAMONDS, Rank.TEN),
						tuple(Suit.DIAMONDS, Rank.KING),
						tuple(Suit.DIAMONDS, Rank.QUEEN),
						tuple(Suit.DIAMONDS, Rank.JACK),
						tuple(Suit.DIAMONDS, Rank.NINE),
						tuple(Suit.DIAMONDS, Rank.EIGHT),
						tuple(Suit.DIAMONDS, Rank.SEVEN));
		assertThat(diamondsCards.stream().mapToInt(Card::getValue).sum()).isEqualTo(30);
	}

	@Test
	public void testGetValue() {
		for (final Card card : Card.values()) {
			assertThat(card.getValue())
					.as("Value of " + card.name())
					.isEqualTo(card.getRank().getValue());
		}
	}

	@Test
	public void testRanks() {
		assertThat(Rank.values())
				.hasSize(8)
				.containsExactly(
						Rank.ACE, Rank.TEN, Rank.KING, Rank.QUEEN, Rank.JACK, Rank.NINE, Rank.EIGHT, Rank.SEVEN);
	}

	@Test
	public void testRankValues() {
		assertThat(Rank.values())
				.extracting("value")
				.containsExactly(11, 10, 4, 3, 2, 0, 0, 0);
	}
}
