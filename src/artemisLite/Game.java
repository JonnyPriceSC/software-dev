package src.artemisLite;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Game {

	// global variables
	public static Contract[] CONTRACT_ARRAY;
	public static int turnCount = 1;

	// global arraylists for year detail logs
	public static ArrayList<String> YEAR_2021_LOG = new ArrayList<String>();
	public static ArrayList<String> YEAR_2022_LOG = new ArrayList<String>();
	public static ArrayList<String> YEAR_2023_LOG = new ArrayList<String>();

	static int passGoValue = 200;
	static boolean gameEnd = false;

	public static void main(String[] args) {

		// adding initial details to event logs
		YEAR_2021_LOG.add("Year 2021 Event Log : ");
		YEAR_2022_LOG.add("Year 2022 Event Log : ");
		YEAR_2023_LOG.add("Year 2023 Event Log : ");

		// print out logs syntax
//		while(iterate1.hasNext()) {
//			System.out.println(iterate1.next());
//		}

		asciiPrint("logo");
		spacer();

		// initialising the contract objects across the board
		Contract go = new Contract(0, "Go", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Contract lobbyistOffice = new Contract(1, "Lobbyist Office", 30, 15, 15, 30, 60, 60, 60, 90, 999, 150, 30, 60,
				90, 120);
		Contract thinkTank = new Contract(2, "Think Tank", 40, 20, 20, 40, 80, 100, 80, 160, 240, 320, 40, 80, 120,
				160);
		Contract salesPitch = new Contract(3, "Sales Pitch", 50, 25, 20, 40, 80, 100, 25, 160, 240, 320, 100, 80, 120,
				160);
		Contract marketing = new Contract(4, "Marketing, Branding & Communications", 10, 5, 50, 100, 150, 200, 20, 30,
				60, 80, 10, 20, 30, 40);
		Contract merchandising = new Contract(5, "Merchandising", 20, 10, 100, 150, 225, 300, 40, 60, 80, 100, 20, 30,
				40, 50);
		Contract furloughSquare = new Contract(6, "Nothing happens!", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
		Contract astronautTraining = new Contract(7, "Astronaut Training Facilities", 60, 30, -30, -60, -90, 120, 120,
				180, 240, 300, 60, 90, 120, 150);
		Contract radar = new Contract(8, "Radar & Comms", 70, 35, -35, -70, -105, -140, 140, 210, 280, 350, 70, 105,
				140, 175);
		Contract launchSystem = new Contract(9, "Space Launch System", 70, 35, -35, -70, -105, -140, 140, 210, 280, 350,
				70, 105, 140, 175);
		Contract lunarHabitat = new Contract(10, "Lunar Habitat", 100, 55, -50, -100, -120, -180, -200, 300, 360, 450,
				100, 150, 180, 225);
		Contract sustainability = new Contract(11, "Sustainability", 120, 60, -60, -120, -150, -200, 240, 360, 400, 500,
				120, 180, 200, 250);

		// board array
		Contract[] board = { go, lobbyistOffice, thinkTank, salesPitch, marketing, merchandising, furloughSquare,
				astronautTraining, radar, launchSystem, lunarHabitat, sustainability };

		// Create Global Contract Array
		CONTRACT_ARRAY = board;

		// contract segment arrays
		Contract[] politicalLobbying = { lobbyistOffice, thinkTank, salesPitch };
		Contract[] commercialFundraising = { marketing, merchandising };
		Contract[] groundControl = { astronautTraining, radar, launchSystem };
		Contract[] lunarBase = { lunarHabitat, sustainability };

		// prints contract details

		// for (Contract c : board) {
		// System.out.println();
		// System.out.println("Contract name - " + c.getContractName());
		// System.out.println("Base cost - " + c.getBaseCost());
		// System.out.println("Base rent - " + c.getBaseRent());
		// System.out.println("Minor adjustment 1 - " + c.getAdjustmentMinor1());
		// System.out.println("Minor adjustment 2 - " + c.getAdjustmentMinor2());
		// System.out.println("Minor adjustment 3 - " + c.getAdjustmentMinor3());
		// System.out.println("Major adjustment - " + c.getAdjustmentMajor());
		// System.out.println("Minor cost 1 - " + c.getMinorCost1());
		// System.out.println("Minor cost 2 - " + c.getMinorCost2());
		// System.out.println("Minor cost 3 - " + c.getMinorCost3());
		// System.out.println("Major cost - " + c.getMajorCost());
		// System.out.println("Minor rent 1 - " + c.getMinorRent1());
		// System.out.println("Minor rent 2 - " + c.getMinorRent2());
		// System.out.println("Minor rent 3 - " + c.getMinorRent3());
		// System.out.println("Major rent - " + c.getMajorRent());
		// System.out.println("Current Adjustment - " + c.getCurrentAdjustment());
		// System.out.println("Current Cost - " + c.getCurrentCost());
		// System.out.println("Current Level - " + c.getCurrentLevel());
		// System.out.println("Current rent - " + c.getCurrentRent());
		// }

		// initialise number of players
		int numPlayers = 0;
		boolean validPlayerNum = false;

		// program starts <----------------------------------

		// initialise scanner
		Scanner scanner = new Scanner(System.in);

		// print menu - start game? Y/N
		print("Do you want to start the game? (Y/N)");

		String scannerInput = scanner.nextLine();

		// If yes = start game / If no = quit
		if (scannerInput.equalsIgnoreCase("Y")) {

			while (validPlayerNum == false) {
				// ask how many players (2-4)
				print("How many players are there? (2-4)");
				try {

					numPlayers = scanner.nextInt();
					scanner.nextLine();

					if (numPlayers < 2 || numPlayers > 4) {
						print("Must be between 2 and 4 players.");
					} else {
						validPlayerNum = true;
					}

				} catch (InputMismatchException e) {
					print("You need to enter a valid number between 2 and 4");
					scanner.nextLine();
					continue;
				}

			}

			// register players
			Player[] playerArray = new Player[numPlayers];

			boolean firstName = true;

			Scanner nameScanner = new Scanner(System.in);
			for (int i = 0; i < numPlayers; i++) {
				boolean validName = true;
				while (validName) {

					print("Please enter Player " + (i + 1) + " name:");
					String name = nameScanner.nextLine();

					while (firstName) {
						if (name.length() > 0) {

							Player player = new Player(i, name);

							playerArray[i] = player;

							firstName = false;
							break;

						}
					}

					if (firstName == false && i == 0) {
						break;
					}

					if (name.length() > 0) {

						for (Player p : playerArray) {

							if (p.getPlayerName().equalsIgnoreCase(name)) {
								print("Sorry that name is already taken");
								break;
							} else {
								Player player = new Player(i, name);

								playerArray[i] = player;
								validName = false;
								break;

							}

						}

					}

					else {
						print("You didn't enter a name, please enter a name");
					}

				}

			}

			int currentPlayer = 0;

			// start the game
			while (!gameEnd) {

				// check if the players have won the game
				int winCounter = 0;
				for (Contract c : board) {
					if (c.getCurrentLevel() == 4) {
						winCounter++;
					}
				}
				if (winCounter == 10) {
					print("Congratulations, you have completed the mission! ArtemisLite is on it's way to the moon. Houston, we have liftoff!");
					asciiPrint("blastOff");
					gameEnd = true;
					break;
				}

				boolean ownsPL = true;
				boolean ownsCF = true;
				boolean ownsGC = true;
				boolean ownsLB = true;

				Player player = playerArray[currentPlayer];

				// gameEnd check

				// bankruptcy check
				if (bankruptcyCheck(playerArray)) {
					break;
				}
				;

				// time check
				if (Time.timeCheck(playerArray) == true) {
					gameEnd = true;
					break;
				}

				// print the current player
				divider();
				System.out.println();
				System.out.println("Turn Number : " + turnCount);
				turnCount++;
				printCurrentPlayer(player, playerArray);

				// take a turn etc

				// does a player own any contract segments (skip first time around)

				for (Contract c : politicalLobbying) {
					if (currentPlayer != c.getOwnerId()) {
						ownsPL = false;
					}
				}

				for (Contract c : commercialFundraising) {
					if (currentPlayer != c.getOwnerId()) {
						ownsCF = false;
					}
				}

				for (Contract c : groundControl) {
					if (currentPlayer != c.getOwnerId()) {
						ownsGC = false;
					}
				}

				for (Contract c : lunarBase) {
					if (currentPlayer != c.getOwnerId()) {
						ownsLB = false;
					}
				}

				// offer development if segment owned.

				if (ownsPL) {
					String pol = "Political Lobbying";
					offerUpgrade(player, politicalLobbying, politicalLobbying.length, pol);
				}

				if (ownsCF) {
					String com = "Commercial Fundraising";
					offerUpgrade(player, commercialFundraising, commercialFundraising.length, com);
				}

				if (ownsGC) {
					String grd = "Ground Control";
					offerUpgrade(player, groundControl, groundControl.length, grd);
				}

				if (ownsLB) {
					String lun = "Lunar Base";
					offerUpgrade(player, lunarBase, lunarBase.length, lun);
				}

				divider();
				// print where the player is now before their roll
				print("You are currently on the " + board[player.getPlayerPosition()].getContractName() + " square. ["
						+ (player.getPlayerPosition() + 1) + "/12]");

				// print a menu of turn options
				print("What would you like to do?");
				print("Press 1 to roll the dice.");
				print("Press 2 to quit the game.");
				int turnResponse = scanner.nextInt();

				// cheat menu - enter 69 to win the game
				if (turnResponse == 69) {
					print("Congratulations, you have completed the mission! ArtemisLite is on it's way to the moon. Houston, we have liftoff!");
					asciiPrint("blastOff");
					gameEnd = true;
					break;
				}

				// initialise playerRoll
				int playerRoll = 0;

				try {
					while (turnResponse > 0 && turnResponse < 3 && !gameEnd) {
						if (turnResponse == 1) {
							// roll the dice!
							playerRoll = dice();
							break;
						} else {

							gameEnd = true;

							String log = String.format("%s was a spoilsport and decided to end the game early.",
									player.getPlayerName());
							Time.addToLog(log, Time.YEAR);
							break;
						}
					}
				} catch (Exception e) {
					print("You need to enter a valid menu option (1 or 2)");
					e.printStackTrace();
				}

				// end the game if the user quits
				if (gameEnd) {
					continue;
				}

				// quit the game

				//

				// move the player to their new square
				// check IF passed start (if passed = wallet adjustment + passedGo ticked +
				// timeChanged)
				movePlayer(player, playerRoll);

				// update the player on their new position [1/12]
				print("Your new position is now the " + board[player.getPlayerPosition()].getContractName()
						+ " square. [" + (player.getPlayerPosition() + 1) + "/12]");
				divider();

				// if the player lands on the Go square or the Nothing happens square -- nothing
				// happens...

				Contract thisContract = board[player.getPlayerPosition()];

				if (thisContract.getContractId() == 0) {
					System.out.printf("Nothing happens on the %s square.", thisContract.getContractName());
				} else if (thisContract.getContractId() == 6) {
					System.out.printf("Nothing happens on the %s square.", thisContract.getContractName());
					// check if square owned - if no one owns = offer square to player
				} else if (thisContract.getOwnerId() == 5) {

					System.out.printf("The %s is not owned. \n",
							thisContract.getContractName() + " square [" + (player.getPlayerPosition() + 1) + "/12]");

					buySquare(player, thisContract, playerArray);

					divider();

				}
				collectRent(player, thisContract, playerArray);

				// moving the currentPlayer on to the next player
				if (currentPlayer != playerArray.length - 1) {
					currentPlayer++;
				} else {
					currentPlayer = 0;
				}

			}
			spacer();
			spacer();
			printEpilogue(playerArray);

			// ----> end of loop <----

		} else {
			print("You have decided not to play the game or have put in the incorrect input please start the game again if you want to play");
		}

	}

	// Methods

	// Print the current player for wayfinding
	public static void printCurrentPlayer(Player player, Player[] playerArray) {
		spacer();
		System.out.printf("Current Player: %s [%d/%d]", player.getPlayerName(), player.getPlayerID() + 1,
				playerArray.length);
		spacer();
		spacer();
		wait(1.5);
	}

	// Check if any of the players are bankrupt

	public static boolean bankruptcyCheck(Player[] playerArray) {
		boolean bankrupt = false;
		for (Player p : playerArray) {
			if (p.getPlayerResources() < 0) {
				bankrupt = true;
				System.out.printf("Player %s has bankrupted the game", p.playerName);

				// add a item to the log
				String log = String.format("%s went bankrupt and ruined it for everyone.", p.getPlayerName());
				Time.addToLog(log, Time.YEAR);
				Time.printYearProgress(playerArray);
				return bankrupt;
			}
		}
		return bankrupt;
	}

	// Warn player if purchase will make the player bankrupt
	public static boolean costCheck(Player p, int cost) {
		if (p.getPlayerResources() < cost) {
			return true;
		} else {
			return false;
		}
	}

	// Update the player position

	public static void movePlayer(Player p, int roll) {
		int startPos = p.getPlayerPosition();
		int newPos = startPos + roll;

		// if larger than 12 - minus 12 to give a valid position on board

		if (newPos > 11) {
			newPos = newPos - 12;
			p.setPlayerPassedGo(true);
			int resourcesBefore = p.getPlayerResources();
			int resourcesAfter = resourcesBefore + passGoValue;
			p.setPlayerResources(resourcesAfter);
			print("You passed Go and received " + passGoValue + " Galactic Credits.");
			System.out.printf("Your balance has been updated from %d to %d. \n", resourcesBefore, resourcesAfter);
		}
		p.setPlayerPosition(newPos);

	}

	// Give player the option to buy square

	public static void buySquare(Player p, Contract c, Player[] playerArray) {

		Scanner scanner = new Scanner(System.in);

		print("Your Galactic Credit balance is " + p.getPlayerResources() + ". This will cost " + c.getCurrentCost()
				+ ".");

		if (costCheck(p, c.getCurrentCost())) {
			print("WARNING: This will make you bankrupt and end the game!");
		}

		print("Would you like to purchase? (Y/N)");

		String scannerInput = scanner.nextLine();
		// process upgrade if a user selects 'y'
		if (scannerInput.equalsIgnoreCase("Y")) {

			// set ownership of the square to this player
			c.setOwnerId(p.playerID);

			// balance adjustment for purchase
			p.setPlayerResources(p.getPlayerResources() - c.getCurrentCost());

			// tell the player they have bought the square
			System.out.printf("You have now bought the %s square. [%d/12]", c.getContractName(), c.getContractId() + 1);
			spacer();

			// tell the player their new balance
			System.out.printf("Your new balance is %d Galactic Credits.", p.getPlayerResources());
			spacer();
			c.setCurrentCost(c.getMinorCost1());

			// add a item to the log
			String log = String.format("%s bought the %s square.", p.getPlayerName(), c.getContractName());
			Time.addToLog(log, Time.YEAR);

		} else {

			// if player does not want to buy - offer to other players
			// If bought - remove resources from buying player

			offerSquare(p, playerArray, c);
		}

	}

	// who bought what, when
	// who upgraded what, when
	// completed a segment
	//

	public static void collectRent(Player p, Contract c, Player[] playerArray) {
		Scanner scanner = new Scanner(System.in);

		if (p.playerID != c.getOwnerId() && c.getOwnerId() != 5) {

			String squareOwner = playerArray[c.getOwnerId()].getPlayerName();

			print(squareOwner + ", do you wish to collect rent? (" + c.getCurrentRent() + " Galactic Credits) (Y/N)");

			int resourcesBefore = p.getPlayerResources();

			if (resourcesBefore < c.getCurrentCost()) {
				print("WARNING: This will make you bankrupt and end the game!");
			}

			String answer = scanner.nextLine();

			if (answer.equalsIgnoreCase("Y")) {

				p.setPlayerResources(p.getPlayerResources() - c.getCurrentRent());
				int resourcesAfter = p.getPlayerResources();

				print(p.playerName + " has paid " + c.getCurrentRent() + " rent for " + c.getContractName() + ".");
				print(p.playerName + "'s Galactic Credit balance has been updated from " + resourcesBefore + " to "
						+ resourcesAfter + ".");
			} else {
				print(squareOwner + "has waived the rent for this turn.");
			}
		}
	}

	// Simple score board
	public static void scoreboard(Player[] playerArray) {

		wait(0.005);
		System.out.println();
		System.out.println("Here are the current player balances:");
		System.out.println();

		wait(0.005);
		String leftAlignFormat = "| %-21s |         %-12d |%n";

		System.out.format("+-----------------------+----------------------+%n");
		System.out.format("| Player Name           |   Player Resources   |%n");
		System.out.format("+-----------------------+----------------------+%n");

		for (Player p : playerArray) {
			wait(0.005);
			System.out.format(leftAlignFormat, p.getPlayerName(), p.getPlayerResources());
		}
		wait(0.005);
		System.out.format("+-----------------------+----------------------+%n");
	}

	// this is the dice rolling method - it returns a value made from two 6 sided
	// dice rolls (1-12)
	public static int dice() {

		int roll1 = (int) (Math.random() * 6 + 1);
		int roll2 = (int) (Math.random() * 6 + 1);

		int number = roll1 + roll2;

		// System.out.println(roll1);
		// System.out.println(roll2);

		System.out.printf("You rolled a %d and a %d. %d total.", roll1, roll2, number);
		System.out.println();
		return number;
	}

	// simple utility printing method
	public static void print(String text) {
		wait(0.005);
		System.out.println(text);
	}

	public static void print(int text) {
		System.out.println(text);
	}

	// simple utility spacer method
	public static void spacer() {
		System.out.println();
	}

	// simple divider utility method
	public static void divider() {
		String div = "---------------------------------------------------------------------------------";
		System.out.println(div);
	}

	// simple utility wait method
	public static void wait(double seconds) {
		try {
			Thread.sleep((long) (seconds * 1000));
		} catch (InterruptedException e) {
		}
	}

	// simple utility print slow method
	public static void printSlow(String text, double waitTime) {

		for (int i = 0; i < text.length(); i++) {
			System.out.print(text.charAt(i));
			wait(waitTime);
		}
		System.out.println();
	}

	// simple utility method menu printing
	public static void printOfferedSquareMenu(String[] options) {
		int itemNumber = 1;
		System.out.println("If a player wishes to buy the square, please enter their corresponding number:");
		System.out.println();
		for (int i = 0; i < options.length; i++) {
			System.out.printf("%d. %s", itemNumber, options[i]);
			itemNumber++;
			System.out.println();
			// System.out.println();
		}
	}

	// simple utility method menu printing
	public static void printMenu(String[] options) {
		int itemNumber = 1;
		System.out.println("Please choose an option");
		System.out.println();
		for (int i = 0; i < options.length; i++) {
			System.out.printf("%d. %s", itemNumber, options[i]);
			itemNumber++;
			System.out.println();
			System.out.println();
		}
	}

	// If the player chooses not to purchase a square other players given the
	// opportunity to buy

	public static void offerSquare(Player declinee, Player[] playerArray, Contract c) {

		ArrayList<String> playerList = new ArrayList<String>();

		for (Player p : playerArray) {
			if (p.getPlayerID() != declinee.getPlayerID()) {
				playerList.add(p.getPlayerName());
			}

		}

		// String array to hold player names
		String[] playerMenuChoices = new String[playerList.size() + 1];
		playerMenuChoices = playerList.toArray(playerMenuChoices);

		playerMenuChoices[playerList.size()] = ("No one wants this square.");

		printOfferedSquareMenu(playerMenuChoices);

		print("Please select the number of the player who would like to buy this square");

		Scanner scanner = new Scanner(System.in);

		boolean validChoice = false;

		while (!validChoice) {
			try {
				int choice = scanner.nextInt();
				// check the user input for which player chooses to purchase the square

				if (choice != playerMenuChoices.length) {
					for (Player p : playerArray) {
						if (p.getPlayerID() != declinee.getPlayerID()) {
							if (p.getPlayerName().equals(playerMenuChoices[choice - 1])) {

								buySquare(p, c, playerArray);

							}
						}

					}
				} else {
					print("No one wants this square.");

				}
				validChoice = true;

			} catch (InputMismatchException e) {
				print("You need to enter a valid number from the menu");
				scanner.nextLine();
			} catch (ArrayIndexOutOfBoundsException e) {
				print("You need to enter a valid number from the menu");
				scanner.nextLine();
			} catch (Exception e) {
				print("You need to enter a valid number from the menu");
				scanner.nextLine();
			}
		}
	}

	public static void asciiPrint(String option) {

		if (option.equals("logo")) {
			String artemisLogo = "          _____ _______ ______ __  __ _____  _____   _      _____ _______ ______ \r\n"
					+ "    /\\   |  __ \\__   __|  ____|  \\/  |_   _|/ ____| | |    |_   _|__   __|  ____|\r\n"
					+ "   /  \\  | |__) | | |  | |__  | \\  / | | | | (___   | |      | |    | |  | |__   \r\n"
					+ "  / /\\ \\ |  _  /  | |  |  __| | |\\/| | | |  \\___ \\  | |      | |    | |  |  __|  \r\n"
					+ " / ____ \\| | \\ \\  | |  | |____| |  | |_| |_ ____) | | |____ _| |_   | |  | |____ \r\n"
					+ "/_/    \\_\\_|  \\_\\ |_|  |______|_|  |_|_____|_____/  |______|_____|  |_|  |______|";

			printSlow(artemisLogo, 0.005);

		}

		if (option.equals("blastOff")) {
			String blastOff = "___  ___      .______    __          ___           _______.___________.     ______    _______  _______       ___  ___\r\n"
					+ "\\  \\ \\  \\     |   _  \\  |  |        /   \\         /       |           |    /  __  \\  |   ____||   ____|     /  / /  /\r\n"
					+ " \\  \\ \\  \\    |  |_)  | |  |       /  ^  \\       |   (----`---|  |----`   |  |  |  | |  |__   |  |__       /  / /  / \r\n"
					+ "  >  > >  >   |   _  <  |  |      /  /_\\  \\       \\   \\       |  |        |  |  |  | |   __|  |   __|     <  < <  <  \r\n"
					+ " /  / /  /    |  |_)  | |  `----./  _____  \\  .----)   |      |  |        |  `--'  | |  |     |  |         \\  \\ \\  \\ \r\n"
					+ "/__/ /__/     |______/  |_______/__/     \\__\\ |_______/       |__|         \\______/  |__|     |__|          \\__\\ \\__\\\r\n"
					+ " \r\n" + "                                                   ,:\r\n"
					+ "                                                 ,' |\r\n"
					+ "                                                /   :\r\n"
					+ "                                             --'   /\r\n"
					+ "                                             \\/ />/\r\n"
					+ "                                             / <//_\\\r\n"
					+ "                                          __/   /\r\n"
					+ "                                          )'-. /\r\n"
					+ "                                          ./  :\\\r\n"
					+ "                                           /.' '\r\n"
					+ "                                         '/'\r\n"
					+ "                                         +\r\n" + "                                        '\r\n"
					+ "                                      `.\r\n" + "                                  .-\"-\r\n"
					+ "                                 (    |\r\n" + "                              . .-'  '.\r\n"
					+ "                             ( (.   )8:\r\n" + "                         .'    / (_  )\r\n"
					+ "                          _. :(.   )8P  `\r\n" + "                      .  (  `-' (  `.   .\r\n"
					+ "                       .  :  (   .a8a)\r\n" + "                      /_`( \"a `a. )\"'\r\n"
					+ "                  (  (/  .  ' )=='\r\n" + "                 (   (    )  .8\"   +\r\n"
					+ "                   (`'8a.( _(   (\r\n" + "                ..-. `8P    ) `  )  +\r\n"
					+ "              -'   (      -ab:  )\r\n" + "            '    _  `    (8P\"Ya\r\n"
					+ "          _(    (    )b  -`.  ) +\r\n" + "         ( 8)  ( _.aP\" _a   \\( \\   *\r\n"
					+ "       +  )/    (8P   (88    )  )\r\n" + "          (a:f   \"     `\"       `";
			printSlow(blastOff, 0.005);
		}

	}

	// method to print the epilogue for the game
	public static void printEpilogue(Player[] playerArray) {

		Iterator<String> iterate1 = YEAR_2021_LOG.iterator();
		Iterator<String> iterate2 = YEAR_2022_LOG.iterator();
		Iterator<String> iterate3 = YEAR_2023_LOG.iterator();

		System.out.printf("The game has ended after %d turns, here is a recap of the events of the game:", turnCount);
		spacer();
		spacer();

		while (iterate1.hasNext() && (YEAR_2021_LOG.size() > 1)) {
			System.out.println(iterate1.next());
			wait(0.005);
		}

		while (iterate2.hasNext() && (YEAR_2022_LOG.size() > 1)) {
			System.out.println(iterate2.next());
			wait(0.005);
		}

		while (iterate3.hasNext() && (YEAR_2023_LOG.size() > 1)) {
			System.out.println(iterate3.next());
			wait(0.005);
		}

		divider();
		print("Here is the final state of play:");
		divider();

		scoreboard(playerArray);
		Time.printYearProgress(playerArray);
	}

	public static void offerUpgrade(Player player, Contract[] segment, int segmentLength, String segName) {

		boolean contractsComplete = false;
		int contractsCompleteCount = 0;
		Scanner scanner = new Scanner(System.in);

		for (Contract c : segment) {
			if (c.getCurrentLevel() == 4) {
				contractsCompleteCount++;
			}
		}

		if (contractsCompleteCount == segmentLength) {
			contractsComplete = true;
		}

		if (!contractsComplete) {

			print("You own the full " + segName + " segment.");
			print("Would you like to upgrade any contracts? (Y/N)");

			String input = scanner.nextLine();

			if (input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("Yes")) {

				// checking that all minor upgrades are completed.
				boolean allMinorUpgradesComplete = false;
				int count = 0;

				for (Contract c : segment) {
					if (c.getCurrentLevel() == 3) {
						count++;
					}
				}

				if (count == segmentLength) {
					allMinorUpgradesComplete = true;
				}

				// looping through contracts of current segment. Offer upgrade.
				for (Contract c : segment) {

					if (c.getCurrentLevel() == 4) {
						System.out.printf("%s square is fully developed.", c.getContractName());
						continue;
					}

					String currentContract = c.getContractName();

					// cycle through upgrades

					if (!allMinorUpgradesComplete) {
						print("Major Upgrade for " + c.getContractName()
								+ " cannot be completed until all minor developments of this segment are completed.");
					}

					if (c.getCurrentLevel() < 3) {
						print("Do you want to upgrade " + currentContract + " from development level "
								+ c.getCurrentLevel() + " to development level " + (c.getCurrentLevel() + 1));
					} else if (allMinorUpgradesComplete) {
						print("Do you want to carry out the major development on " + currentContract);
					}

					print("Your Galactic Credit balance is " + player.getPlayerResources());

					int nextContractCost = 0;
					int currentLevel = c.getCurrentLevel();
					int nextRentLevel = 0;

					// finding the next development cost
					switch (currentLevel) {
					case 0:

						nextContractCost = c.getMinorCost1();
						break;
					case 1:

						nextContractCost = c.getMinorCost2();
						break;
					case 2:

						nextContractCost = c.getMinorCost3();
						break;
					case 3:
						if (allMinorUpgradesComplete) {

							nextContractCost = c.getMajorCost();
						} else {
							print("You can't do a major development until all minor developments of this segment are completed.");
						}
						break;
					}

					print("This will cost " + nextContractCost);

					// finding the next rent level
					switch (currentLevel) {
					case 0:
						nextRentLevel = c.getMinorRent1();
						break;
					case 1:
						nextRentLevel = c.getMinorRent2();
						break;
					case 2:
						nextRentLevel = c.getMinorRent3();
						break;
					case 3:
						nextRentLevel = c.getMajorRent();
						break;
					}

					print("Current rent is " + c.getCurrentRent() + ". Your rent will increase to " + nextRentLevel);

					int nextAdjustment = 0;

					// finding the next adjustment level
					switch (currentLevel) {
					case 0:
						nextAdjustment = c.getAdjustmentMinor1();
						break;
					case 1:
						nextAdjustment = c.getAdjustmentMinor2();
						break;
					case 2:
						nextAdjustment = c.getAdjustmentMinor3();
						break;
					case 3:
						nextAdjustment = c.getAdjustmentMajor();
						break;
					}

					print("This will adjust the pass go value from " + passGoValue + " to "
							+ (nextAdjustment + passGoValue));
					print("Would you like to process upgrade? (Y/N)");

					// process upgrade if a user selects 'y'
					if (scanner.nextLine().equalsIgnoreCase("Y")) {
						c.setCurrentCost(nextContractCost);
						int playerResources = player.getPlayerResources();
						player.setPlayerResources(playerResources - c.getCurrentCost());
						// after upgrade set new "current" values
						c.setCurrentLevel(currentLevel + 1);
						c.setCurrentRent(nextRentLevel);
						c.setCurrentAdjustment(nextAdjustment);

						if (c.getCurrentLevel() < 4) {
							// minor development
							String log = String.format("%s upgraded the %s square to development level %d.",
									player.getPlayerName(), c.getContractName(), c.getCurrentLevel());
							Time.addToLog(log, Time.YEAR);
						} else {
							// major development
							String log = String.format("%s completed the major development for the %s square.",
									player.getPlayerName(), c.getContractName());
							Time.addToLog(log, Time.YEAR);
						}

					}

				}

			}

		}
	}

}
