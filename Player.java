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
	
	/* public String location() {
	 * return the current location of the player
	 */
	
	/*public Boolean pickUpItem(String x){
		this method allows player to add an item to their inventory
		User enters pick up item.
		player calls on the inventory of the room to see if item is in room.
		If item is in room, then remove the item from inventory of room 
		to inventory of the player.
		
	}*/
	
	
	/*public Boolean moveRooms(String x) {
	 * this method moves players from one room to the next
	 * if player enters a correct direction then player moves current location -> new location
	 * if player enters wrong direction player stays 
	 *  if (player enters up) {
	 *  then (changeRoom up)
	 *  else if (player enters down) 
	 *  then (changeRoom down)
	 *  else if (player enters right)
	 *  then (changeRoom right)
	 *  else if (player enters left)
	 *  then (changeRoom left)
	 *  else (player stays)
	 */
	 
	private String name;
}
