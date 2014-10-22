/**
 * This file is part of JSkat.
 *
 * JSkat is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * JSkat is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with JSkat.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.jskat;

/**
 * Human player
 */
public class HumanPlayer implements SkatPlayer {

	private Idler idler = new Idler();

	private String nextCard;

	@Override
	public String playCard() throws InterruptedException {
		System.out.println("Waiting for player input...");
		waitForUserInput();
		return nextCard;
	}

	@Override
	public Boolean bidMore(Integer currentBid) {
		return false;
	}

	@Override
	public Boolean holdBid(Integer currentBid) {
		return false;
	}

	/**
	 * Starts waiting for user input
	 */
	public void waitForUserInput() {

		idler = new Idler();
		idler.setMonitor(this);

		this.idler.start();
		try {
			this.idler.join();
		} catch (InterruptedException e) {
		}
	}

	public void actionPerformed(String nextMove) {
		nextCard = nextMove;
		idler.interrupt();
	}

	/*-------------------------------------------------------------------
	 * Inner class
	 *-------------------------------------------------------------------*/
	/**
	 * Protected class implementing the waiting thread for user input
	 */
	protected static class Idler extends Thread {

		/**
		 * Sets the monitoring object
		 * 
		 * @param newMonitor
		 *            Monitor
		 */
		public void setMonitor(final Object newMonitor) {

			this.monitor = newMonitor;
		}

		/**
		 * Stops the waiting
		 */
		public void stopWaiting() {

			this.doWait = false;
		}

		/**
		 * @see Thread#run()
		 */
		@Override
		public void run() {

			synchronized (this.monitor) {

				while (this.doWait) {
					try {
						this.monitor.wait();
					} catch (InterruptedException e) {
						stopWaiting();
					}
				}
			}
		}

		private boolean doWait = true;
		private Object monitor = null;
	}
}
