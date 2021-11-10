package model.players;

import model.SoccerBall;

import java.awt.*;
import java.util.Random;

/**
 * Represents the goal keeper in the game and what it does
 */
public class Goalkeeper extends GamePlayer {

	private int movementStep;

	/**
	 * Setting up goal keeper in the game when it starts
	 * 
	 * @param name  A String containing goal keeper name
	 * @param color A String containing goal keeper color
	 */
	public Goalkeeper(String name, Color color) {
		super(name, color);
		movementStep = 10;
	}

	/**
	 * Represents keeper movement when it moves left
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 5 - movementStep > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - movementStep, getPlayerPosition().y));
		}
	}

	/**
	 * Represents keeper movement when it moves right
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 + movementStep < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + movementStep, getPlayerPosition().y));
		}
	}

	/**
	 * Represents keeper movement when it moves up
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	/**
	 * Represents keeper movement when it moves down
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 300) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	/**
	 * Represents when goal keeper catches the ball and shoots it back to the player
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(-20, -5.0, -0.05);
	}

	/**
	 * Representing goal keeper movement
	 */
	public void moveRandomly() {
		Random random = new Random();
		double playerCurrentXPosition = (double) getPlayerPosition().x + 15;
		double chanceOfMovingLeft = (playerCurrentXPosition - 300) / 100 - (random.nextGaussian());
		movementStep = (int) Math.abs(30 * chanceOfMovingLeft);
		if (chanceOfMovingLeft > 0) {
			moveLeft();
		} else {
			moveRight();
		}
	}

	/**
	 * Representing goal keeper initial position
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(280, 70));
	}

	/**
	 * Represents the stats at end
	 * 
	 * @return stats based on number of ball caught by the keeper
	 */
	@Override
	public String toString() {
		return playerName + " caught " + playerStatistics.toString() + " balls";
	}
}
