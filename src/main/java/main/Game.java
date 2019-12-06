package main;

import java.util.Random;
import java.util.Scanner;

public class Game {

	private Random rand = new Random();

	public static void start() {
		Scanner s = new Scanner(System.in);
		boolean play = true;
		System.out.println("Grey foggy clouds float oppressively close to you, \n"
				+ "reflected in the murky grey water which reaches up your shins.\n"
				+ "Some black plants barely poke out of the shallow water.\n"
				+ "Try \"north\", \"south\", \"east\", or \"west\"\n"
				+ "You notice a small watch-like device in your left hand.  \n"
				+ "It has hands like a watch, but the hands don't seem to tell time. \n");
		System.out.println(playRound(s));
		
	}

	public Compass getPlayerMove() {
		switch (rand.nextInt(5)) {
		case 4:
			return Compass.DESTINATION;
		case 3:
			return Compass.NORTH;
		case 2:
			return Compass.SOUTH;
		case 1:
			return Compass.EAST;
		case 0:
			return Compass.WEST;
		}
		return null;
	}

	public static Compass getPlayerMove(String choice) {
		switch (choice.toLowerCase()) {
		case "north":
			return Compass.NORTH;
		case "paper":
			return Compass.SOUTH;
		case "scissors":
			return Compass.EAST;
		case "west":
			return Compass.WEST;
		default:
			return null;
		}
	}

	public static String goDirection(Compass playerMove) {
		switch (playerMove) {

		case EAST:
			return " 5 metres";

		case WEST:
			return "2 metres";

		case NORTH:
			return "6 metres";

		case SOUTH:
			return "3 metres";

		case DESTINATION:
			return "TREASURE";
		}
		return null;
	}

	public static String playRound(Scanner s) {
		Compass playerMove = null;
		do {
			System.out.println("Please choose north, east, south or west:");
			playerMove = getPlayerMove(s.nextLine());
		} while (playerMove == null);
		System.out.println("Please chooses: " + playerMove);
		String outcome = goDirection(playerMove);
		return outcome;

	}

}
