import java.util.*;

public class Room {

	private String description;
	ArrayList<Exit>exitList = new ArrayList<Exit> (5);
	private Inventory I = new Inventory(null);
	/**
 * constructs a room object that has a name and can be entered
 * @param x the name of the room that will be entered.
 * @param items is the list of items in the inventory of the room.
 */
	public Room(String x,String y){
		
		name = x;
		description = y;
		
	}
	/**
	 * getRoom() gets the name of the room
	 * @return the name of the room
	 */
	public String getRoom() {
		return name;
	}
	//Room if it can’t find an exit return null -> loop to go through the exits
	public void addExit(Exit e){
		exitList.add(e);
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
	/**
	 * addItem(Item) adds an item to the inventory
	 * @param item adds item to the inventory
	 */
	public void addItem(Item item){
		I.add(item);
	}
	private String name;
	
	
	/*public static Map newInstance() {
        Map rooms = new Map();
        rooms.putRoom(0, 0, Room.Instance());
        rooms.putRoom(0, 1, Room.Instance());
        rooms.putRoom(1, 0, Room.Instance());
        rooms.currentRoom = rooms.getRoom(0, 0);
        return rooms;
    } */

/**
 * creates a description of the room 
 */
	
public String description(){
	String exits = "";
	for (int i = 0; i < exitList.size() ; i++){
		exits = exits +" "+ exitList.get(i).getName();
	}
	
	String m = (description + " your exit options are "+ exits);
	return m;
}


/*String description = null;
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
	return null;*/
} 

