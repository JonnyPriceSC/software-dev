package src.artemisLite;

public class Player {
	
	// variables
	int playerID;
	String playerName;
	int playerResources;
	boolean playerPassedGo;
	int playerPosition;

	// constructor
	public Player(int playerID, String playerName) {
		this.playerID = playerID;
		this.playerName = playerName;
		this.playerResources = 250;
		this.playerPosition = 0;
		this.playerPassedGo = false;
	} 

	// getters and setters
	public int getPlayerID() {
		return playerID;
	}

	public void setPlayerID(int playerID) {
		this.playerID = playerID;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerResources() {
		return playerResources;
	}

	public void setPlayerResources(int playerResources) {
		this.playerResources = playerResources;
	}
	
	public int getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(int playerPosition) {
		this.playerPosition = playerPosition;
	}

	public boolean isPlayerPassedGo() {
		return playerPassedGo;
	}

	public void setPlayerPassedGo(boolean playerPassedGo) {
		this.playerPassedGo = playerPassedGo;
	}

}
