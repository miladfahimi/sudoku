package sudoku;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		gameGenerator g = new gameGenerator();

		boolean quit = false;
		while (!quit) {
			System.out.println("\nEnter action: (9 to show available actions)");
			String action = scanner.nextLine();
			switch (action) {
			case "1":
				System.out.println("\nStart the Game ");
				System.out.println("------------------------");
				System.out.println(g.getTable());
				break;
			case "2":
				System.out.println("\nThe Answer");
				System.out.println("------------------------\n");
				break;
			case "8":
				System.out.println("\nGood bye");
				quit = true;
				break;
			default:
				StringBuilder msg = new StringBuilder("\nAvailable actions:\n");
				msg.append("------------------------\n");
				msg.append("1- New Game\n");
				msg.append("2- Show solution\n");
				msg.append("8- Quit\n");
				System.out.println(msg);
			}
		}
	}
}
