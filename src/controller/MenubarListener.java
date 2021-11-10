package controller;

import model.SoccerGame;
import view.GamePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents what the Menubar actions will perform
 * 
 * @author Professor, Aayush, Neel, Kashyap
 */
public class MenubarListener implements ActionListener {

	private final GamePanel gamePanel;

	/**
	 * @param panel contains panel to control option listed on top of menubar
	 */
	public MenubarListener(GamePanel panel) {
		gamePanel = panel;
	}

	/**
	 * Allows the user to take action by clicking on Menubar options
	 * 
	 * @param different switch case to define what the menubar option will perform
	 *                  when pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		SoccerGame soccerGame = gamePanel.getGame();
		switch (e.getActionCommand()) {
		case "NEW":
			gamePanel.setupSoccerGame();
			break;
		case "EXIT":
			System.exit(0);
			break;
		case "PAUSE":
			if (!soccerGame.isPaused() && !soccerGame.isOver()) {
				soccerGame.setPaused(true);
			} else if (soccerGame.isPaused()) {
				System.out.println("game is already on pause!");
			} else if (soccerGame.isOver()) {
				System.out.println("game is over, please start a new game.");
			}
			break;
		case "RESUME":
			if (soccerGame.isPaused() && !soccerGame.isOver()) {
				soccerGame.setPaused(false);
			} else if (!soccerGame.isPaused()) {
				System.out.println("game is already running!");
			} else if (soccerGame.isOver()) {
				System.out.println("game is over, please start a new game.");
			}
			break;
		default:
			throw new RuntimeException("Invalid action command " + e.getActionCommand());
		}
	}
}
