package org.jskat;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class JSkat {

	private final static Random random = new Random();
	private final static ExecutorService executor = Executors
			.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

	public static void main(String[] args) {

		final SkatGame game1 = new SkatGame(1);
		final SkatGame game2 = new SkatGame(2);

		final HumanPlayer human1 = new HumanPlayer();
		final HumanPlayer human2 = new HumanPlayer();

		final HumanPlayer[] humanArray = { human1, human2 };
		List<HumanPlayer> humans = Arrays.asList(humanArray);

		runGame(game1, human1);
		runGame(game2, human2);

		Scanner sc = new Scanner(System.in);

		boolean stop = false;
		do {
			String card = sc.nextLine();
			System.out.println(card);
			if ("".equals(card)) {
				stop = true;
			} else {
				humans.get(random.nextInt(humans.size())).actionPerformed(card);
			}
		} while (!stop);

		System.exit(0);
	}

	private static void runGame(final SkatGame game, final HumanPlayer human) {
		FutureTask<Void> futureTask = new FutureTask<Void>(
				new Callable<Void>() {
					@Override
					public Void call() throws Exception {
						System.out.println("Running game...");
						game.runGame(new RandomPlayer(), human,
								new RandomPlayer());
						return null;
					}
				});
		executor.execute(futureTask);
	}
}
