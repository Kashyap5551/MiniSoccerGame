package model;

import java.util.Timer;
import java.util.TimerTask;

import model.players.*;

/**
 * Represents SoccerGame Panel that user see when the program runs
 */
public class SoccerGame {

	private Integer timeRemaining;

	private Integer goal;

	private Boolean isPaused;

	private Boolean isOver;

	private final PlayerCollection gamePlayers;

	/**
	 * Set default values for variables in this constructor
	 */
	public SoccerGame() {
		timeRemaining = 60;
		goal = 0;
		isPaused = false;
		isOver = false;
		SoccerBall.getSoccerBall().resetSoccerBall();
		PlayerFactory playerFactory = new PlayerFactory();
		gamePlayers = new PlayerCollection();
		gamePlayers.add(playerFactory.getPlayer("striker"));
		gamePlayers.add(playerFactory.getPlayer("goalkeeper"));
		startGame();
	}

	/**
	 * Set the game when the user runs the program Set default screen when the
	 * program runs or user starts new game
	 */
	private void startGame() {
		Timer timer = new Timer();
		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				if (!isPaused()) {
					if (getTimeRemaining() <= 0) {
						setOver(true);
						timer.cancel();
					} else {
						setTimeRemaining(getTimeRemaining() - 1);
					}
					if (isScored()) {
						setPaused(true);
						setGoal(getGoal() + 1);
						getActivePlayer().setPlayerStatistics(getActivePlayer().getPlayerStatistics() + 1);
						getGamePlayers().get("Striker").setInitialPosition();
						SoccerBall.getSoccerBall().resetSoccerBall();
					} else {
						automateGoalkeeper();
					}
				}
			}
		};
		timer.schedule(timerTask, 1000, 1000);
	}

	/**
	 * Get the time remaining in the game
	 * 
	 * @return timeRemaining in the game at any point of the game
	 */
	public Integer getTimeRemaining() {
		return timeRemaining;
	}

	/**
	 * Set the time remaining in the game
	 * 
	 * @param timeRemaining The int contains the time remaining that we set above
	 */
	public void setTimeRemaining(Integer timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	/**
	 * Get goal from the game screen
	 * 
	 * @return goal from the game
	 */
	public Integer getGoal() {
		return goal;
	}

	/**
	 * set the goal in the game
	 * 
	 * @param newGoal The int contains the goal scored by the player
	 */
	public void setGoal(Integer newGoal) {
		goal = newGoal;
	}

	/**
	 * check the current operating state
	 * 
	 * @return if the game is paused
	 */
	public Boolean isPaused() {
		return isPaused;
	}

	/**
	 * setting the game to pause when ispaused is called
	 * 
	 * @param paused Checks if the game is paused or not
	 */
	public void setPaused(Boolean paused) {
		isPaused = paused;
	}

	/**
	 * terminate the game when the ends
	 * 
	 * @return state when the game is over (time is over)
	 */
	public Boolean isOver() {
		return isOver;
	}

	/**
	 * setting the game to over when time ends
	 * 
	 * @param over state of the game
	 */
	public void setOver(Boolean over) {
		isOver = over;
	}

	/**
	 * gameplayers in the game
	 * 
	 * @return player and the goal keeper in the game
	 */
	public PlayerCollection getGamePlayers() {
		return gamePlayers;
	}

	/**
	 * Represents what the goal keeper does in the game updates the stats of the
	 * gola keeper based on the conditions
	 */
	public void automateGoalkeeper() {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		Goalkeeper goalkeeper = (Goalkeeper) gamePlayers.get("Goalkeeper");
		if (soccerBall.onGoalkeeperSide()) {
			goalkeeper.grabsBall();
			goalkeeper.shootBall();
			goalkeeper.setPlayerStatistics(goalkeeper.getPlayerStatistics() + 1);
		} else {
			goalkeeper.moveRandomly();
		}
	}

	/**
	 * Represents when the goal enters the gate
	 * 
	 * @return stats if player scores goal
	 */
	public boolean isScored() {
		return SoccerBall.getSoccerBall().inGate();
	}

	/**
	 * Represents the player in the game
	 * 
	 * @return active player who is striker in the game
	 */
	public GamePlayer getActivePlayer() {
		return gamePlayers.get("Striker");
	}
}
