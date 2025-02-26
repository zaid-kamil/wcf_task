package com.wipro;

class Animal implements Runnable {

	public static String winner;

	void race(int maxDistance) throws InterruptedException {
		for (int d = 0; d <= maxDistance; d++) {
			System.out.println(String.format("Distance convered by %s is %d meters", Thread.currentThread().getName(), d));
			if (handleRaceStates(d, maxDistance))
				break;
		}
	}

	boolean handleRaceStates(int totalDistanceCovered, int maxDistance) throws InterruptedException {
		boolean isRaceWon = false;
		if (Animal.winner == null && totalDistanceCovered == maxDistance) {
			Animal.winner = Thread.currentThread().getName();
			System.out.println(String.format("Winner is %s", Animal.winner));
			
			isRaceWon = true;
		} else if (totalDistanceCovered == 60 && Thread.currentThread().getName().equals("Hare")) {
			System.out.println(String.format("%s is taking a nap", Thread.currentThread().getName()));
			Thread.currentThread();
			Thread.sleep(1000);

		} else if (Animal.winner == null) {
			isRaceWon = false;
		} else if (Animal.winner != null) {
			isRaceWon = true;
		}
		return isRaceWon;
	}

	@Override
	public void run() {
		try {
			race(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
