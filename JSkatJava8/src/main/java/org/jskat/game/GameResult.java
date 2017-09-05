package org.jskat.game;

public class GameResult {
	private PlayerSeat declarer;
	private GameDeclaration declaration;
	private WinLevel winLevel;
	private final int multiplier = 2;
	private final boolean schneider = false;
	private final boolean schwarz = false;
	private final boolean won = false;
	private final int gameValue = 0;

	/**
	 * Gets the outcome of the game.
	 *
	 * @return TRUE, if the game is won
	 */
	public boolean isWon() {
		return won;
	}
}
