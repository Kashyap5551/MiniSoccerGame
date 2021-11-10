package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Represents panel to control our character in the game
 * 
 * @author Professor, Aayush, Neel, Kashyap
 */
public class GameListener implements KeyListener {

	private final GamePanel gamePanel;

	/**
	 * 
	 * @param panel Contains panel for the game control
	 */
	public GameListener(GamePanel panel) {
		gamePanel = panel;
	}

	/**
	 * Invokes when key is typed by the user
	 */
	@Override
	public void keyTyped(KeyEvent e) {

	}

	/**
	 * Allows the user to control the player through keys
	 * 
	 * @param different switch case to define what the key will perform
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		if (!soccerGame.isPaused() && !soccerGame.isOver()) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_LEFT:
				soccerGame.getActivePlayer().moveLeft();
				break;
			case KeyEvent.VK_RIGHT:
				soccerGame.getActivePlayer().moveRight();
				break;
			case KeyEvent.VK_UP:
				soccerGame.getActivePlayer().moveUp();
				break;
			case KeyEvent.VK_DOWN:
				soccerGame.getActivePlayer().moveDown();
				break;
			case KeyEvent.VK_SPACE:
				if (soccerGame.getActivePlayer().isPlayerHasBall()) {
					soccerGame.getActivePlayer().shootBall();
				}
				break;
			}
		}
	}

	/**
	 * Invokes when key is released by the user
	 */
	@Override
	public void keyReleased(KeyEvent e) {

	}
}
