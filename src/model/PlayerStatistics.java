package model;

/**
 * Represents the PlayerStatistics shown on JPanel at the end of game
 */
public class PlayerStatistics {
	private Integer statistics = 0;

	/**
	 * New instance of statistics
	 * 
	 * @param newStatistics The int of newStatistics
	 */
	public void setStatistics(Integer newStatistics) {
		statistics = newStatistics;
	}

	/**
	 * Get Statistics at the end of the game
	 * 
	 * @return statistics
	 */
	public Integer getStatistics() {
		return statistics;
	}

	/**
	 * @return Stats of the game as a String
	 */
	public String toString() {
		return getStatistics().toString();
	}
}
