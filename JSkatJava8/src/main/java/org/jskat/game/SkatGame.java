package org.jskat.game;

import org.jskat.card.CardDeck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Skat game
 */
public class SkatGame {

	private static final Logger LOG = LoggerFactory.getLogger(SkatGame.class);

	private final GameResult gameResult = new GameResult();

	public GameResult run() {
		LOG.info("Game start...");

		final CardDeck cardDeck = new CardDeck();
		LOG.info("Unpacking new card deck: " + cardDeck);

		LOG.info("Shuffle and cut cards...");
		cardDeck.shuffle();
		cardDeck.shuffle();
		cardDeck.shuffle();
		cardDeck.shuffle();
		cardDeck.cut();
		LOG.info("After shuffeling: " + cardDeck);

		LOG.info("Game end. Result: " + (gameResult.isWon() ? "WON" : "LOST"));
		return gameResult;
	}
}
