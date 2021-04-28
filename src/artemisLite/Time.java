package src.artemisLite;

public class Time {
	

	public static boolean keepGoing = true;

	public static boolean yearIncreased = false;

	//global variable for the year
	public static int YEAR = 2021;

	public static int quarter = 0;

	public static boolean gameEnd = false;
	
	public static void addToLog (String logItem, int year) {
		if(year == 2021) {
			Game.YEAR_2021_LOG.add(logItem);
		} else if (year == 2022){
			Game.YEAR_2022_LOG.add(logItem);
		} else if (year == 2023) {
			Game.YEAR_2023_LOG.add(logItem);
		}
	}
	
	
	public static boolean timeCheck(Player[] p) {

		while (keepGoing) {
			for (Player thisPlayer : p) {
				if (thisPlayer.isPlayerPassedGo() != true) {
					keepGoing = false;
					break;
				} else {
					quarter++;
					thisPlayer.setPlayerPassedGo(false);
					if (quarter % 4 == 0) {
						YEAR++;
						yearIncreased = true;
						quarter = 0;
					}
				}
			}
		}

		if (!yearIncreased) {
			printYearProgress(p);
			//store variables and print from here
			
		}

		if (YEAR == 2024) {
			gameEnd = true;
			//print the epilogue
		}

		if (gameEnd) {
			return true;
		} else
			return false;
	}
	
	

	

	public static String getPlayerNameById(int playerId, Player[] playerArray) {
		String playerName = playerArray[playerId].getPlayerName();
		return playerName;
	}

	public static void printYearProgress(Player[] playerArray) {
		Game.wait(0.005);
		System.out.println();
		System.out.println("Here is the board:");
		System.out.println();

		Game.wait(0.005);
		String leftAlignFormat = "| %-21s |      %-10s |       %-10s |%n";

		Game.wait(0.005);
		System.out.format("+-----------------------+-----------------+------------------+%n");
		System.out.format("| Contract Name         |   Owner Name    |   Current Level  |%n");
		System.out.format("+-----------------------+-----------------+------------------+%n");

		for (Contract c : Game.CONTRACT_ARRAY) {
			String contractName = c.getContractName();

			contractName = c.getContractId() == 4 ? "Marketing" : contractName;
			contractName = c.getContractId() == 7 ? "Training Facilities" : contractName;

			String playerName = "";
			if ((c.getContractId() != 0) && (c.getContractId() != 6)) {
				if (c.getOwnerId() == 5) {
					playerName = "n/a";
					System.out.format(leftAlignFormat, contractName, playerName, c.getCurrentLevel());
				} else {
					playerName = getPlayerNameById(c.getOwnerId(), playerArray);

					System.out.format(leftAlignFormat, contractName, playerName, c.getCurrentLevel());
				}
			}

		}
		System.out.format("+-----------------------+-----------------+------------------+%n");

	
	}
	

}
