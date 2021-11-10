package model.players;

import model.SoccerBall;

import java.awt.*;

/**
 * Setting up player (striker) in the game when it starts
 * 
 * @param name  A String containing striker name
 * @param color A String containing striker color
 */
public class Striker extends GamePlayer {
	public Striker(String name, Color color) {
		super(name, color);
	}

	/**
	 * Represents striker movement when it moves left
	 */
	@Override
	public void moveLeft() {
		if (getPlayerPosition().x - 10 > 0) {
			setPlayerPosition(new Point(getPlayerPosition().x - 5, getPlayerPosition().y));
		}
	}

	/**
	 * Represents striker movement when it moves right
	 */
	@Override
	public void moveRight() {
		if (getPlayerPosition().x + 50 < 600) {
			setPlayerPosition(new Point(getPlayerPosition().x + 5, getPlayerPosition().y));
		}
	}

	/**
	 * Represents striker movement when it moves up
	 */
	@Override
	public void moveUp() {
		if (getPlayerPosition().y - 5 > 200) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y - 5));
		}
	}

	/**
	 * Represents striker movement when it moves down
	 */
	@Override
	public void moveDown() {
		if (getPlayerPosition().y + 50 < 500) {
			setPlayerPosition(new Point(getPlayerPosition().x, getPlayerPosition().y + 5));
		}
	}

	/**
	 * Represents when striker shoots the ball towards the net or the keeper at
	 * other end
	 */
	@Override
	public void shootBall() {
		SoccerBall.getSoccerBall().moveBall(60, 5.0, 0.05);
	}

	/**
	 * Representing striker initial position
	 */
	@Override
	public void setInitialPosition() {
		setPlayerPosition(new Point(500, 450));
	}

	/**
	 * Represents the stats at end
	 * 
	 * @return stats based on number of goal scored by the striker
	 */
	@Override
	public String toString() {
		return playerName + " scored " + playerStatistics.toString() + " goals";
	}
}
