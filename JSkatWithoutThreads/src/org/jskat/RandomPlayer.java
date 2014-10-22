package org.jskat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomPlayer implements SkatPlayer {

	protected static final String[] cardArray = { "CJ", "SJ", "HJ", "DJ" };
	protected static final List<String> cards = Arrays.asList(cardArray);

	private static final Random random = new Random();

	@Override
	public Boolean bidMore(Integer currentBid) {
		return Boolean.valueOf(random.nextBoolean());
	}

	@Override
	public Boolean holdBid(Integer currentBid) {
		return Boolean.valueOf(random.nextBoolean());
	}

	@Override
	public String playCard() throws InterruptedException {
		if (random.nextBoolean()) {
			// break terribly
			System.out.println("Ich drehe jetzt durch...");
			Integer i = null;
			i.intValue();
		}
		return cards.get(random.nextInt(cards.size()));
	}
}
