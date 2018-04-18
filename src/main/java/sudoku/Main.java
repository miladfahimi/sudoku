package sudoku;

import java.util.Scanner;

public class Main {

	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		gameGenerator g;

		boolean quit = false;
		while (!quit) {
			System.out.println("\nEnter action: (9 to show available actions)");
			String action = scanner.nextLine();
			switch (action) {
			case "1":
				g = new gameGenerator();
				System.out.println("\nStart the Game ");
				System.out.println("------------------------");
				System.out.println(g.getTable());
				boolean exit = false;
				while (!exit) {
					System.out.println("Enter 7 to input number and 8 to exit to main menu:");
					String play = scanner.nextLine();
					switch (play) {
					case "7":
						int row;
						int col;
						int number;
						try {
							System.out.println("\nEnter row (1 to 4): ");
							row = parseInput(scanner.nextLine());
							System.out.println("\nEnter column (1 to 4): ");
							col = parseInput(scanner.nextLine());
							System.out.println("\nEnter value (1 to 4): ");
							number = parseInput(scanner.nextLine());
						} catch (Exception e) {
							System.out.println("Invlid input. Pleas try again!\n\n");
							break;
						}
						g.updateValue(row - 1, col - 1, number);
						System.out.println(g.getTable());
						break;
					case "8":
						System.out.println("exit\n\n");
						exit = true;
						break;
					default:
				        System.out.println("Invalid input. Please try again!");
					}
				}
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

	private static int parseInput(String input) {
		int num;
		try {
			num = Integer.parseInt(input);
			if (num > 4 || num < 1) {
				throw new RuntimeException();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return num;
	}
}
