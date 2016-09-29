/**
 * A class that creates a player
 * @author takdag
 *
 */
public class Player {
	private String name;
	private Room room;
	/**
	 * Player() Constructs a player object that has a name and empty inventory
	 * 
	 */
	public Player() {
		name = "Scooby";
		Inventory inventory = new Inventory();
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
	 /**
	  * set the location of the player
	  * @param the new location of the player
	  */
	 public void setLocation(Room currentRoom){
		 this.room=currentRoom;
	 }
	 /**
	  * boolean pickUpItem allows a player to pick up an item player calls on the inventory of the room to see if item is in room.
		If item is in room, then remove the item from inventory of room 
		to inventory of the player.
	  * @param String x
	  * @return true if the item is in the inventory of the room
	  */
	
	public boolean pickUpItem(String x){
		Item itemCheck = room.getItem(x);
		if(itemCheck == null){
			return false;
		}
		else{
			inventory.add(itemCheck);
			system.out.println("This is a test line: You have tried to pick up " + itemCheck);
			return true;
		}
	}
	/**
	 * Remove an item from the player's inventory
	 * @param String x
	 * @return false if there is no item in the player's inventory
	 * true if player has an item in their inventory
	 */
	public boolean dropItem(String x){
		Item itemCheck = inventory.getItemName(x);
		if(itemCheck == null){
			return false;
		}
		else{
			inventory.remove(itemCheck);// removes item from player inventory
			room.addItem(itemCheck); //adds item to room inventory
			system.out.println("This is a test line: You have tried to drop " + itemCheck);
			return true;
		}
		
	}
	
	
	
	 /*
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
	    }  */
	 
	
}

