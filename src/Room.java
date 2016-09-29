import java.util.*;

public class Room {

	private String name;
	private String description;
	ArrayList<Exit>exitList = new ArrayList<Exit> (10);
	private Inventory I = new Inventory();
	/**
 * constructs a room object that has a name and can be entered
 * @param x the name of the room that will be entered.
 * @param y is the short description of the room
 */
	public Room(String x,String y){
		
		name = x;
		description = y;
		
	}
	/**
	 * getRoom() gets the name of the room
	 * @return  name of the room
	 */
	public String getRoom() {
		return name;
	}
	/**
	 * addExit adds an exit to a room
	 * @param e, exit to be added
	 */
	public void addExit(Exit e){
		exitList.add(e);
	}
	
	
	/**
	 * Takes in player query and sends back an Item if the item is in the room or a null response if
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
	
/**
 * description gives a description of the rooms
 * @return String that is the description
 */
	
public String description(){
	String exits = "";
	for (int i = 0; i < exitList.size() ; i++){
		exits = exits +" "+ exitList.get(i).getName();
	} 
	String items = I.returnItemList();
	String m = (description + " your exit options are "+ exits + "\n The room has " + items );
	
	return m;
}

/**
 * isMoveValid checks through rooms exits to see if passed in string matches name of any of the exit options
 * @param s door name passed in from user
 * @return room object of next room (the one the user wants to go to)
 */
public Room isMoveValid(String s){
	for(Exit e : exitList){
		if(s.equalsIgnoreCase(e.getName())){
		return e.getNextRoom();
	} 
	}return null;
	}

} 

