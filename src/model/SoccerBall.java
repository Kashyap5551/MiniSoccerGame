package model;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents SoccerBall in the game
 */
public class SoccerBall {

	private static final SoccerBall soccerBall = new SoccerBall();

	private Point position;

	private double velocity;

	private final Color color;

	private SoccerBall() {
		color = Color.white;
		resetSoccerBall();
	}

	/**
	 * Gets SoccerBall
	 * 
	 * @return SoccerBall
	 */
	public static SoccerBall getSoccerBall() {
		return soccerBall;
	}

	/**
	 * Represents how the soccer ball moves in the game
	 * 
	 * @param initialDistance A int that contains the initial distance traveled by
	 *                        the soccer ball
	 * @param initialVelocity A double that contains the velocity of the ball that
	 *                        it is traveling in
	 * @param acceleration    A double contains acceleration of the ball to move the
	 *                        ball to the goal net
	 */
	public void moveBall(int initialDistance, double initialVelocity, double acceleration) {
		moveBallY(initialDistance);
		setVelocity(initialVelocity);
		Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				if (Math.abs(velocity) < 2) {
					velocity = 0.0;
					timer.cancel();
				} else {
					velocity = velocity - acceleration;
				}
				moveBallY((int) velocity);
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	/**
	 * Distance traveled by the ball
	 * 
	 * @param distance The int containing distance of the ball
	 */
	public void moveBallY(int distance) {
		if (getPosition().y + distance < 510 && getPosition().y - distance > 20) {
			setPosition(new Point(getPosition().x, getPosition().y - distance));
		} else {
			setVelocity(0.0);
		}
	}

	/**
	 * Resets the soccer position in the game after goal
	 */
	public void resetSoccerBall() {
		setVelocity(0.0);
		setPosition(new Point(480, 500));
	}

	/**
	 * The ball position at keeper side of the game
	 * 
	 * @return Position of the ball
	 */
	public boolean onGoalkeeperSide() {
		return getPosition().y < 200;
	}

	/**
	 * The ball enter the goal net gate
	 * 
	 * @return position of the ball in the keeper net gate
	 */
	public boolean inGate() {
		return getPosition().x > 180 && getPosition().x < 400 && getPosition().y > 10 && getPosition().y < 60;
	}

	/**
	 * @param velocity A double containing the ball velocity
	 */
	public void setVelocity(double velocity) {
		this.velocity = velocity;
	}

	/**
	 * @return ball position in the game
	 */
	public Point getPosition() {
		return position;
	}

	/**
	 * @param position Set position of the ball
	 */
	public void setPosition(Point position) {
		this.position = position;
	}

	/**
	 * @return ball's color in the game
	 */
	public Color getColor() {
		return color;
	}
}
