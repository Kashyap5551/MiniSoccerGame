package main;

import controller.GameListener;
import controller.MenubarListener;
import view.GameMenuBar;
import view.GamePanel;

import javax.swing.*;

/**
 * Creates application for our game
 * 
 * @author Professor, Aayush, Neel, Kashyap
 */
public class MiniSoccerApp {

	/**
	 * Creates instances of the class object and JPanel for the game
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame gameFrame = new JFrame("Mini Soccer");
		GamePanel gamePanel = new GamePanel();
		GameListener gameListener = new GameListener(gamePanel);
		MenubarListener menubarListener = new MenubarListener(gamePanel);
		GameMenuBar gameMenuBar = new GameMenuBar(menubarListener);
		gameFrame.add(gamePanel);
		gameFrame.addKeyListener(gameListener);
		gameFrame.setJMenuBar(gameMenuBar);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.setSize(600, 600);
		gameFrame.setLocationRelativeTo(null);
		gameFrame.setResizable(false);
		gameFrame.setVisible(true);
	}
}
