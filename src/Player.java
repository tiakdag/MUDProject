/**
 * A class that creates a player
 * @author takdag
 *
 */
public class Player {
	private String name;
	private Room room;
	public Inventory inventory;

	/**
	 * Player() Constructs a player object that has a name and empty inventory
	 * 
	 */
	public Player() {
		name = "Scooby";
		inventory = new Inventory();
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
	  return room.getRoom();
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
			return true;
		}
		
	}
	/**
	 * moveRooms Takes in a door name (string) and asks the room if that is a valid exit. 
	 * if the exit is valid, then the current room will send back the next room and change the players location
	 * @param s is the name of the door the player wishes to 'open' / go through
	 * @return true if player went to next room, false if next room doesnt exist
	 */
	public boolean moveRooms(String s){
		Room nextRoom = room.isMoveValid(s);
		if(nextRoom == null){
			return false;
		}
		else{
			setLocation(nextRoom);
			return true;
		}
	}
	/**
	 * getDescription gets a description of the room
	 * @return the string description of room
	 */
	public String getDescription() {
		return room.description();
	}
	
	 
	
}
