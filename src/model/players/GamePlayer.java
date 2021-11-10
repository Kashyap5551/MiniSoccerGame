package model.players;

import model.PlayerStatistics;
import model.SoccerBall;

import java.awt.*;

/**
 * Represents the Game player in the game and what it does
 */
public abstract class GamePlayer implements Comparable<GamePlayer> {

	protected final String playerName;

	protected final Color playerColor;

	protected Point playerPosition;

	protected final PlayerStatistics playerStatistics;

	/**
	 * The player's initial position
	 * 
	 * @param name  A String containing player (striker) name
	 * @param color A String containing player (striker) color
	 */
	public GamePlayer(String name, Color color) {
		playerName = name;
		playerColor = color;
		playerStatistics = new PlayerStatistics();
		setInitialPosition();
	}

	/**
	 * Represents what the player can do if ball is in the possession and allows to
	 * control the ball
	 * 
	 * @return distance of the ball when the players moves it
	 */
	public boolean isPlayerHasBall() {
		Point playerPositionCenter = new Point(getPlayerPosition().x + 15, getPlayerPosition().y + 30);
		return playerPositionCenter.distance(SoccerBall.getSoccerBall().getPosition()) < 55;
	}

	/**
	 * Represents when the players grabs the soccer ball and allows it to control it
	 * Condition showing the ball position if the player does not have the ball
	 */
	public void grabsBall() {
		SoccerBall ball = SoccerBall.getSoccerBall();
		if (getPlayerPosition().x + 15 > ball.getPosition().x) {
			ball.setPosition(new Point(getPlayerPosition().x - 10, getPlayerPosition().y + 55));
		} else {
			ball.setPosition(new Point(getPlayerPosition().x + 20, getPlayerPosition().y + 55));
		}
	}

	public abstract void moveLeft();

	public abstract void moveRight();

	public abstract void moveUp();

	public abstract void moveDown();

	public abstract void shootBall();

	/**
	 * Getter that gets player name
	 * 
	 * @return player name as String
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Getter that gets player color
	 * 
	 * @return player color
	 */
	public Color getPlayerColor() {
		return playerColor;
	}

	/**
	 * Getter that gets player position
	 * 
	 * @return player position in the game
	 */
	public Point getPlayerPosition() {
		return playerPosition;
	}

	public abstract void setInitialPosition();

	/**
	 * Setter that sets player position
	 * 
	 * @param newPosition player new position in the game after moving the character
	 */
	public void setPlayerPosition(Point newPosition) {
		playerPosition = newPosition;
		if (isPlayerHasBall()) {
			grabsBall();
		}
	}

	/**
	 * Getter that gets player stats
	 * 
	 * @return Player Stats at end
	 */
	public Integer getPlayerStatistics() {
		return playerStatistics.getStatistics();
	}

	/**
	 * Setter that sets player stats as it updates
	 * 
	 * @param newStatistics new game stats as game progresses
	 */
	public void setPlayerStatistics(Integer newStatistics) {
		playerStatistics.setStatistics(newStatistics);
	}

	/**
	 * Compare goal keeper and player (striker) stats at end
	 * 
	 * @return the final stats after comparing both player and goal keeper
	 */
	@Override
	public int compareTo(GamePlayer otherPlayer) {
		return otherPlayer.getPlayerStatistics().compareTo(this.getPlayerStatistics());
	}

	@Override
	public abstract String toString();
}
