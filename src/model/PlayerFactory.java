package model;

import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.Striker;

import java.awt.*;

/**
 * Represents a PlayerFactory
 * 
 * @author Professor, Aayush, Neel, Kashyap
 */
public class PlayerFactory {

	/**
	 * Creates unique instance of striker & GoalKeeper
	 * 
	 * @param striker The striker in the game
	 * @return striker A String representing striker
	 * @throws exception if there is none striker or goalkeeper
	 */
	public GamePlayer getPlayer(String striker) {
		switch (striker) {
		case ("striker") -> {
			return new Striker("Striker", Color.blue);
		}

		case ("goalkeeper") -> {
			return new Goalkeeper("Goalkeeper", Color.yellow);
		}

		default -> {
			throw new IllegalArgumentException("Argument provided is neither a striker nor a goalkeeper");
		}
		}
	}
}
