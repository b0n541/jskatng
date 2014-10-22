package org.jskat;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SkatGame {

	private final Integer gameId;

	private SkatPlayer foreHand;
	private SkatPlayer middleHand;
	private SkatPlayer rearHand;

	public SkatGame(Integer gameId) {
		this.gameId = gameId;
	}

	public void runGame(SkatPlayer foreHand, SkatPlayer middleHand,
			SkatPlayer rearHand) throws Exception {

		this.foreHand = foreHand;
		this.middleHand = middleHand;
		this.rearHand = rearHand;

		ExecutorService executor = Executors.newFixedThreadPool(1);

		System.out.println("Game " + gameId + ": Dealing...");
		System.out.println("Game " + gameId + ": Bidding...");
		System.out.println("Game " + gameId + ": Card play...");

		for (int i = 0; i < 10; i++) {

			System.out.println("Game " + gameId + ": Trick " + (i + 1));

			Callable<String> task = new Callable<String>() {
				@Override
				public String call() throws InterruptedException {
					System.out.println("Game " + gameId
							+ ": Player thinking...");
					return SkatGame.this.foreHand.playCard();
				}
			};
			Future<String> future = executor.submit(task);

			try {
				System.out.println("  Forehand plays " + future.get());
			} catch (InterruptedException | ExecutionException e) {
				throw e;
			}

			task = new Callable<String>() {
				@Override
				public String call() throws InterruptedException {
					System.out.println("Game " + gameId
							+ ": Player thinking...");
					return SkatGame.this.middleHand.playCard();
				}
			};
			future = executor.submit(task);

			System.out.println("  Middlehand plays " + future.get());

			task = new Callable<String>() {
				@Override
				public String call() throws InterruptedException {
					System.out.println("Game " + gameId
							+ ": Player thinking...");
					return SkatGame.this.rearHand.playCard();
				}
			};
			future = executor.submit(task);

			System.out.println("  Rearhand plays " + future.get());
		}
	}
}
