package model;

import model.players.GamePlayer;

/**
 * Sorts player in the game: striker & goalkeeper
 * 
 * @author Professor, Aayush, Neel, Kashyap
 */
public class PlayerSort {

	// Singleton Class
	private static PlayerSort uniqInstance;

	private PlayerSort() {
	}

	/**
	 * get instance of playerSort
	 * 
	 * @return player's uniqInstance
	 */
	public static PlayerSort getInstance() {
		if (uniqInstance == null) {
			uniqInstance = new PlayerSort();
		}
		return uniqInstance;
	}

	/**
	 * Sort the player using algorithm
	 * 
	 * @param gamePlayers sort the gamePlayers
	 */
	public void sort(GamePlayer[] gamePlayers) {
		if (gamePlayers[0].compareTo(gamePlayers[1]) > 0) {
			GamePlayer temp = gamePlayers[0];
			gamePlayers[0] = gamePlayers[1];
			gamePlayers[1] = temp;
		}
	}
}
