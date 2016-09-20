
/**
 * A class that creates a player
 * @author takdag
 *
 */
public class Player {
	/**
	 * Constructs a player object that has a name and 
	 * @param x the name of the player
	 */
	public Player(String x) {
		name = x;
	}
	/**
	 * getName() gets the name of the player and returns that name
	 * @return the name of the player
	 */ 
	public String getName() {
		return name;
	}
	private String name;
}

