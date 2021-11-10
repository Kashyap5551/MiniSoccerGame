package tester;

import org.junit.*;

import controller.MenubarListener;
import main.MiniSoccerApp;

import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.Action;

import model.*;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import model.SoccerBall;
import model.players.GamePlayer;
import model.players.Goalkeeper;
import model.players.Striker;
import view.GamePanel;

public class MiniGameTester {

	// Model.Players Section

	@Test
	public void goalKeeper() {

		Goalkeeper g = new Goalkeeper("Kash", Color.white);

		g.setInitialPosition();
		g.moveLeft();
		Point p = g.getPlayerPosition();
		assertEquals(Double.valueOf(270), p.getX());

		g.setPlayerPosition(new Point(0, 70));
		g.moveLeft();

		g.setInitialPosition();
		g.moveRight();
		Point q = g.getPlayerPosition();
		assertEquals(Double.valueOf(290), q.getX());

		g.setPlayerPosition(new Point(600, 70));
		g.moveRight();

		g.setInitialPosition();
		g.moveUp();
		Point r = g.getPlayerPosition();
		assertEquals(Double.valueOf(65), r.getY());

		g.setPlayerPosition(new Point(0, 0));
		g.moveUp();

		g.setInitialPosition();
		g.moveDown();
		Point s = g.getPlayerPosition();
		assertEquals(Double.valueOf(75), s.getY());

		g.setPlayerPosition(new Point(0, 300));
		g.moveDown();

		g.shootBall();
		g.moveRandomly();
		g.toString();
	}

	@Test
	public void striker() {

		Striker g = new Striker("Kash", Color.white);

		g.setInitialPosition();
		g.moveLeft();
		Point p = g.getPlayerPosition();
		assertEquals(Double.valueOf(495), p.getX());

		g.setPlayerPosition(new Point(0, 70));
		g.moveLeft();

		g.setInitialPosition();
		g.moveRight();
		Point q = g.getPlayerPosition();
		assertEquals(Double.valueOf(505), q.getX());

		g.setPlayerPosition(new Point(600, 70));
		g.moveRight();

		g.setInitialPosition();
		g.moveUp();
		Point r = g.getPlayerPosition();
		assertEquals(Double.valueOf(445), r.getY());

		g.setPlayerPosition(new Point(0, 0));
		g.moveUp();

		g.setInitialPosition();
		g.moveDown();
		Point s = g.getPlayerPosition();
		assertEquals(Double.valueOf(450), s.getY());

		g.setPlayerPosition(new Point(0, 300));
		g.moveDown();

		g.shootBall();
		g.toString();

	}

	@Test
	public void gamePlayer() {

		GamePlayer g = new Goalkeeper("John", Color.white);
		String s = "John";
		assertSame(s, g.getPlayerName());

		Color c = Color.white;
		assertSame(c, g.getPlayerColor());

		g.setPlayerStatistics(50);
		assertEquals(50, g.getPlayerStatistics());

		GamePlayer f = new Goalkeeper("John", Color.white);
		assertEquals(-1, g.compareTo(f));

		g.grabsBall();

		g.setPlayerPosition(new Point(-1, 0));
		g.grabsBall();
	}

	// Model Section

	@Test
	public void soccerGame() {

		SoccerGame game = new SoccerGame();

		game.setTimeRemaining(60);
		assertEquals(60, game.getTimeRemaining());

		game.setGoal(5);
		assertEquals(5, game.getGoal());

		game.setPaused(false);
		assertFalse(game.isPaused());

		game.setOver(false);
		assertFalse(game.isOver());

		PlayerCollection p = game.getGamePlayers();
		assertNotSame(p, new PlayerCollection());

		game.automateGoalkeeper();

		SoccerBall ball = SoccerBall.getSoccerBall();
		ball.setPosition(new Point(480, 180));

		game.automateGoalkeeper();

		assertFalse(game.isScored());

		GamePlayer g = new Striker("John", Color.white);
		assertNotSame(g, game.getActivePlayer());

	}

	@Test
	public void playerCollection() {
		PlayerCollection coll = new PlayerCollection();
		GamePlayer g = new Striker("john", Color.white);
		GamePlayer h = new Striker("henri", Color.white);
		GamePlayer i = new Striker("matt", Color.white);
		coll.add(g);
		coll.add(h);

		assertSame(g, coll.get("john"));

		coll.iterator();

		coll.sort();

		GamePlayer[] exp = { g, h };

		assertArrayEquals(exp, coll.getPlayers());
	}

	@Test
	public void playerSort() {
		GamePlayer g = new Striker("john", Color.white);
		g.setPlayerStatistics(25);
		GamePlayer h = new Striker("henri", Color.white);
		h.setPlayerStatistics(50);

		GamePlayer[] arr = { g, h };

		PlayerSort.getInstance().sort(arr);

		GamePlayer[] exp = { h, g };

		assertArrayEquals(exp, arr);
	}

	@Test
	public void playerStatistics() {
		PlayerStatistics stats = new PlayerStatistics();
		stats.setStatistics(50);

		assertEquals(50, stats.getStatistics());
	}

	@Test
	public void soccerBall() {
		SoccerBall ball = SoccerBall.getSoccerBall();
		ball.setPosition(new Point(400, 400));
		ball.moveBall(20, 0, 0);
		Point p = ball.getPosition();
		assertEquals(380, p.getY(), "Y position must be 380");

		assertFalse(ball.onGoalkeeperSide());

		assertFalse(ball.inGate());

		assertSame(Color.white, ball.getColor());
	}
}
