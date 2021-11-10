package model;

import model.players.GamePlayer;

import java.util.Iterator;

/**
 * Implements the class GamePlayer Represents the players in the game
 * 
 * @author Professor, Aayush, Neel, Kashyap
 */
public class PlayerCollection implements Iterable<GamePlayer> {

	private GamePlayer[] players = new GamePlayer[2];
	private int index = 0;

	/**
	 * Default constructor
	 */
	public PlayerCollection() {
	}

	/**
	 * Adds 2 player to the game
	 * 
	 * @param player 2 players
	 * @throws exception if there are more than 2 players
	 */
	public void add(GamePlayer player) {
		if (index >= 2) {
			throw new RuntimeException("More than 2 number of Players");
		}
		players[index++] = player;
	}

	/**
	 * Gets the player
	 * 
	 * @param players A string
	 * @return A String containing the player
	 * @throws exception if player is not found
	 */
	public GamePlayer get(String player) {
		for (int i = 0; i < 2; i++) {
			if (players[i].getPlayerName().equals(player)) {
				return players[i];
			}
		}
		throw new RuntimeException("Player Could not be found");

	}

	/**
	 * Implements the class GamePlayer Represents the players in the game
	 */
	private class PlayerCollectionIterator implements Iterator<GamePlayer> {
		private int index = 0;

		/**
		 * @returns true or false if index less than or equal to 1
		 */
		@Override
		public boolean hasNext() {
			return index <= 1;
		}

		/**
		 * @returns players index
		 */
		@Override
		public GamePlayer next() {
			return players[index++];
		}
	}

	/**
	 * @returns new instance of class PlayerCollectionIterator
	 */
	@Override
	public Iterator<GamePlayer> iterator() {
		return new PlayerCollectionIterator();
	}

	/**
	 * @param playerSort get instance of the object PlayerSort
	 */
	public void sort() {
		PlayerSort playerSort = PlayerSort.getInstance();
		playerSort.sort(players);
	}

	/**
	 * @return variable players object of the class GamePlayer
	 */
	public GamePlayer[] getPlayers() {
		return players;
	}
}
