package org.jskat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.jskat.game.GameResult;
import org.jskat.game.SkatGame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class of JSkat.
 */
public class JSkat {

	private static final Logger LOG = LoggerFactory.getLogger(JSkat.class);

	public static void main(final String[] args) throws InterruptedException, ExecutionException {
		LOG.info("Hello JSkat");

		runGame();

		System.exit(0);
	}

	private static void runGame() throws InterruptedException, ExecutionException {
		LOG.info("Running game.");

		final SkatGame game = new SkatGame();
		final CompletableFuture<GameResult> gameResult = CompletableFuture.supplyAsync(() -> game.run());

		LOG.info("Waiting for game to be finished...");
		LOG.info("Game end. Result: " + (gameResult.get().isWon() ? "WON" : "LOST"));
		LOG.info("Done.");
	}
}
