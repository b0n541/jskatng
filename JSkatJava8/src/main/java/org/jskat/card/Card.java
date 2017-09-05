package org.jskat.card;

/**
 * Skat card
 */
public enum Card {
	/**
	 * Ace of Clubs
	 */
	CA(Suit.CLUBS, Rank.ACE),
	/**
	 * Ten of Clubs
	 */
	CT(Suit.CLUBS, Rank.TEN),
	/**
	 * King of Clubs
	 */
	CK(Suit.CLUBS, Rank.KING),
	/**
	 * Queen of Clubs
	 */
	CQ(Suit.CLUBS, Rank.QUEEN),
	/**
	 * Jack of Clubs
	 */
	CJ(Suit.CLUBS, Rank.JACK),
	/**
	 * 9 of Clubs
	 */
	C9(Suit.CLUBS, Rank.NINE),
	/**
	 * 8 of Clubs
	 */
	C8(Suit.CLUBS, Rank.EIGHT),
	/**
	 * 7 of Clubs
	 */
	C7(Suit.CLUBS, Rank.SEVEN),
	/**
	 * Ace of Spades
	 */
	SA(Suit.SPADES, Rank.ACE),
	/**
	 * Ten of Spades
	 */
	ST(Suit.SPADES, Rank.TEN),
	/**
	 * King of Spades
	 */
	SK(Suit.SPADES, Rank.KING),
	/**
	 * Queen of Spades
	 */
	SQ(Suit.SPADES, Rank.QUEEN),
	/**
	 * Jack of Spades
	 */
	SJ(Suit.SPADES, Rank.JACK),
	/**
	 * 9 of Spades
	 */
	S9(Suit.SPADES, Rank.NINE),
	/**
	 * 8 of Spades
	 */
	S8(Suit.SPADES, Rank.EIGHT),
	/**
	 * 7 of Spades
	 */
	S7(Suit.SPADES, Rank.SEVEN),
	/**
	 * Ace of Clubs
	 */
	HA(Suit.HEARTS, Rank.ACE),
	/**
	 * Ten of Hearts
	 */
	HT(Suit.HEARTS, Rank.TEN),
	/**
	 * King of Hearts
	 */
	HK(Suit.HEARTS, Rank.KING),
	/**
	 * Queen of Hearts
	 */
	HQ(Suit.HEARTS, Rank.QUEEN),
	/**
	 * Jack of Hearts
	 */
	HJ(Suit.HEARTS, Rank.JACK),
	/**
	 * 9 of Hearts
	 */
	H9(Suit.HEARTS, Rank.NINE),
	/**
	 * 8 of Hearts
	 */
	H8(Suit.HEARTS, Rank.EIGHT),
	/**
	 * 7 of Hearts
	 */
	H7(Suit.HEARTS, Rank.SEVEN),
	/**
	 * Ace of Diamonds
	 */
	DA(Suit.DIAMONDS, Rank.ACE),
	/**
	 * Ten of Diamonds
	 */
	DT(Suit.DIAMONDS, Rank.TEN),
	/**
	 * King of Diamonds
	 */
	DK(Suit.DIAMONDS, Rank.KING),
	/**
	 * Queen of Diamonds
	 */
	DQ(Suit.DIAMONDS, Rank.QUEEN),
	/**
	 * Jack of Diamonds
	 */
	DJ(Suit.DIAMONDS, Rank.JACK),
	/**
	 * 9 of Diamonds
	 */
	D9(Suit.DIAMONDS, Rank.NINE),
	/**
	 * 8 of Diamonds
	 */
	D8(Suit.DIAMONDS, Rank.EIGHT),
	/**
	 * 7 of Diamonds
	 */
	D7(Suit.DIAMONDS, Rank.SEVEN);

	private final Suit suit;
	private final Rank rank;

	Card(final Suit suit, final Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * Gets the {@link Suit} of the {@link Card}.
	 *
	 * @return {@link Suit} of the {@link Card}
	 */
	public Suit getSuit() {
		return suit;
	}

	/**
	 * Gets the {@link Rank} of the {@link Card}.
	 *
	 * @return {@link Rank} of the {@link Card}
	 */
	public Rank getRank() {
		return rank;
	}

	/**
	 * Gets the value of the {@link Card}.
	 *
	 * @return Value of the {@link Rank} of the {@link Card}
	 */
	public int getValue() {
		return rank.getValue();
	}

	@Override
	public String toString() {
		return suit.toString() + rank.toString();
	}

	/**
	 * Rank of a {@link Card}.
	 */
	public enum Rank {
		ACE("A", 11), TEN("10", 10), KING("K", 4), QUEEN("Q", 3), JACK("J", 2), NINE("9", 0), EIGHT("8", 0), SEVEN("7",
				0);

		private String symbol;
		private final int value;

		private Rank(final String symbol, final int value) {
			this.symbol = symbol;
			this.value = value;
		}

		/**
		 * Gets the value of the {@link Rank}.
		 *
		 * @return Value of the {@link Rank}
		 */
		public int getValue() {
			return value;
		}

		@Override
		public String toString() {
			return symbol;
		}
	}

	/**
	 * Suit of a {@link Card}.
	 */
	public enum Suit {
		CLUBS("♣"), SPADES("♠"), HEARTS("♥"), DIAMONDS("♦");

		private String symbol;

		private Suit(final String symbol) {
			this.symbol = symbol;
		}

		@Override
		public String toString() {
			return symbol;
		}
	}
}
