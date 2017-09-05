package org.jskat.game;

public enum WinLevel {
	BASIC(1, 2), SCHNEIDER(2, 3), SCHWARZ(3, 5), SCHNEIDER_ANNOUNCED(0, 4), SCHWARZ_ANNOUNCED(0, 6), OPEN(0, 7);

	private int multiplier;
	private int multiplierHandGame;

	private WinLevel(final int multiplier, final int multiplierHandGame) {
		this.multiplier = multiplier;
		this.multiplierHandGame = multiplierHandGame;
	}

	/**
	 * Gets the multiplier of the {@link WinLevel}.
	 *
	 * @param isHandGame
	 *            TRUE, if skat was not picked up
	 * @return Mulitplier of the {@link WinLevel}
	 */
	public int getMultiplier(final boolean isHandGame) {
		if (isHandGame) {
			return multiplierHandGame;
		}
		return multiplier;
	}
}
