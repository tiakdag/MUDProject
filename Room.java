import java.util.*;

public class Room {
/**
 * constructs a room object that has a name and can be entered
 * @param x the name of the room that will be entered.
 * @param items is the list of items in the inventory of the room.
 */
	public Room(String x,Item[] items){
		Inventory I = new Inventory(items);
		name = x;
	}
	/**
	 * getRoom() gets the name of the room
	 * @return the name of the room
	 */
	public String getRoom() {
		return name;
	}
	
	/**
	 * Takes in player query and sends back an Item if it is in the room or a null response if
	 * the item is not there.
	 * @param item_query is a string from the UI to the Player Class to room that represents the item the player wishes to pick up.
	 * @return Item object if the the desired item is in the room and accessible.
	 */
	public Item getItem(String item_query){
		return I.getItem(item_query);
		
	}
	
	public null addItem(Item item){
		I.add(item);
	}
	private String name;
	
	
	public static Map newInstance() {
        Map rooms = new Map();
        rooms.putRoom(0, 0, Room.Instance());
        rooms.putRoom(0, 1, Room.Instance());
        rooms.putRoom(1, 0, Room.Instance());
        rooms.currentRoom = rooms.getRoom(0, 0);
        return rooms;
    }
}

String description = null;
if (n == 0) {
	description = "Swamp";
} 
	else if (n == 1) {
		description = "";
} 
		else if (n == 2) {
			description = "";
} 
			else if (n == 3) {
				description = "";
} 
				else {
	return null;
}

