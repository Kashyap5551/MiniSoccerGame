package view;

import model.SoccerBall;
import model.SoccerGame;
import model.players.GamePlayer;
import model.PlayerCollection;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Represents the Game panel that the user will see when the game starts
 */
public class GamePanel extends JPanel {

	private final Font uiFont;

	private SoccerGame game;

	public GamePanel() {
		super(null);
		super.setBackground(new Color(112, 176, 49));
		uiFont = new Font("UI", Font.BOLD, 15);
		setupSoccerGame();
		setupRepaint();
	}

	/**
	 * Starts new game when the program starts or when user clicks on start new game
	 * initialize new game
	 */
	public void setupSoccerGame() {
		game = new SoccerGame();
	}

	/**
	 * Repaints the game when the game starts or new game starts
	 */
	private void setupRepaint() {
		java.util.Timer timer = new Timer();
		TimerTask repaintTask = new TimerTask() {
			@Override
			public void run() {
				repaint();
			}
		};
		timer.schedule(repaintTask, 0, 10);
	}

	/**
	 * current game state
	 * 
	 * @return new game
	 */
	public SoccerGame getGame() {
		return game;
	}

	/**
	 * Represents different paint component used in the game panel
	 */
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintPausedText(g);
		paintGate(g);
		paintPenaltyLine(g);
		paintGoal(g);
		paintTimer(g);
		paintPlayers(g);
		paintBall(g);
		paintStatistics(g);
	}

	/**
	 * Paint the display when the game is paused
	 */
	private void paintPausedText(Graphics g) {
		if (getGame().isPaused()) {
			g.setColor(Color.red);
			g.setFont(uiFont);
			g.drawString("Paused", 270, 300);
		}
	}

	/**
	 * Paint the goal gate
	 */
	private void paintGate(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(200, 10, 200, 50);
		g.setColor(Color.black);
		g.setFont(uiFont);
		g.drawString("Gate", 280, 40);
	}

	/**
	 * Paint the penalty line in the game
	 */
	private void paintPenaltyLine(Graphics g) {
		g.setColor(Color.darkGray);
		g.drawLine(0, 200, 600, 200);
	}

	/**
	 * Paint the timer displayed in the game
	 */
	private void paintTimer(Graphics g) {
		g.setColor(Color.black);
		g.setFont(uiFont);
		g.drawString("Time: " + getGame().getTimeRemaining(), 20, 25);
	}

	/**
	 * Paint the displayed goal
	 */
	private void paintGoal(Graphics g) {
		g.setColor(Color.black);
		g.setFont(uiFont);
		g.drawString("Goal: " + game.getGoal(), 20, 50);
	}

	/**
	 * Paint the player based on the position in the game
	 */
	private void paintPlayers(Graphics g) {
		PlayerCollection gamePlayers = game.getGamePlayers();
		for (GamePlayer player : gamePlayers) {
			g.setColor(player.getPlayerColor());
			g.drawOval(player.getPlayerPosition().x, player.getPlayerPosition().y, 30, 30);
			g.fillPolygon(
					new int[] { player.getPlayerPosition().x, player.getPlayerPosition().x + 15,
							player.getPlayerPosition().x + 30 },
					new int[] { player.getPlayerPosition().y + 30, player.getPlayerPosition().y + 70,
							player.getPlayerPosition().y + 30 },
					3);
			g.setColor(Color.black);
			g.setFont(uiFont);
			g.drawString(player.getPlayerName(),
					player.getPlayerPosition().x - (int) (1.8 * player.getPlayerName().length()),
					player.getPlayerPosition().y + 85);
		}
	}

	/**
	 * Paint the ball in the game
	 */
	private void paintBall(Graphics g) {
		SoccerBall soccerBall = SoccerBall.getSoccerBall();
		g.setColor(soccerBall.getColor());
		g.fillOval(soccerBall.getPosition().x, soccerBall.getPosition().y, 20, 20);
	}

	/**
	 * Paint the stats showed during the game and stats showed at the end
	 */
	private void paintStatistics(Graphics g) {
		if (getGame().isOver()) {
			g.setColor(Color.red);
			g.setFont(uiFont);
			g.drawString("Game Over!", 250, 250);
			PlayerCollection gamePlayers = game.getGamePlayers();
			gamePlayers.sort();
			int y = 300;
			for (GamePlayer player : gamePlayers) {
				g.drawString(player.toString(), 200, y);
				y = y + 30;
			}
		}
	}
}
