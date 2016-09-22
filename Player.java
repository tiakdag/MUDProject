/**
 * A class that creates a player
 * @author takdag
 *
 */
public class Player {
	private String name;
	private Room room;
	/**
	 * Constructs a player object that has a name and 
	 * @param x the name of the player
	 */
	public Player() {
		name = "Scooby";
		
	}
	public Player(String x){
		name = x;
	}
	/**
	 * getName() gets the name of the player and returns that name
	 * @return the name of the player
	 */ 
	public String getName() {
		return name;
	}
	/**
	 * location() gets the name of the room that the player is currently in
	 * @return the name of the room
	 */
	 public String location() {
	  return room.getName();
	 }
	 // return the current location of the player
	 
	
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
	 
	 public void moveRooms(){
		 
		 
	        boolean northExit = roomExists(currentX, currentY+1);
	        boolean southExit = roomExists(currentX, currentY-1);
	        boolean eastExit = roomExists(currentX+1, currentY);
	        boolean westExit = roomExists(currentX-1, currentY);
	        
	        System.out.print("Exit options are:");
	        
	        if (northPossible) {System.out.print(" North ");
	            }
	        if (eastPossible) {System.out.print(" East ");
	            }
	        if (southPossible) {System.out.print(" South ");
	            }
	        if (westPossible) {System.out.print(" West ");
	            }
	        System.out.print("?");
	        
	        input playerInput = new input(new Input(System.in));
	        String direction = playerInput.readInput();
	        if (direction.equals("North") && northExit) {
	            currentY++;
	        } else if (direction.equals("south") && southExit) {
	            currentY--;
	        } else if (direction.equals("East") && eastExit) {
	            currentX++;
	        } else if (direction.equals("West") && westExit) {
	            currentX--;
	        }
	        room = getRoom(currentX, currentY);
	    }
	 
	
}

