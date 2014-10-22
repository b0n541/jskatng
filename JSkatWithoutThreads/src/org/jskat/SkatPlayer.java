package org.jskat;

public interface SkatPlayer {

	public Boolean bidMore(Integer currentBid);

	public Boolean holdBid(Integer currentBid);

	public String playCard() throws InterruptedException;
}
