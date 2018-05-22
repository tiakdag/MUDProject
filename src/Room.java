import java.util.*;

public class Room {

	private String name;
	private String description;
	private String filepath;
	private ArrayList<Exit>exitList = new ArrayList<Exit> (10);
	private ArrayList<MOB>mobList = new ArrayList<MOB> ();

	private Inventory I = new Inventory();
	/**
 * constructs a room object that has a name and can be entered
 * @param x the name of the room that will be entered.
 * @param y is the short description of the room
 */
	public Room(String x,String y, String image){ //Added filepath to image as part of constructor
		
		name = x;
		description = y;
		filepath = image;
		
	}
	/**
	 * getRoom() gets the name of the room
	 * @return  name of the room
	 */
	public String getRoom() {
		return name;
	}
	/**
	 * getFilepath() gets the filepath of the rooms associate image
	 * @return file path of associated image
	 */
	public String getFilepath(){
		return filepath;
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
	 * get mob Item, checks to see if the mob is in the room
	 * @param item_query
	 * @return
	 */
	public boolean getMobItem(String item_query){
		for(MOB m : mobList){
			if (item_query.equalsIgnoreCase( m.getMobName())){
				return true;
			}
		}
		return false;
	}
	/**
	 * addItem(Item) adds an item to the inventory
	 * @param item adds item to the inventory
	 */
	public void addItem(Item item){
		I.add(item);
	}
	/**
	 * Adds a mob to the room's moblist
	 * @param m is a MOB that is added to the MOB List
	 */
	public void addMob(MOB m){
		mobList.add(m);
	}
	/**
	 * removes mob from room's mob list
	 * @param m is the mob to be removed
	 */
	public void removeMob(MOB m){
		mobList.remove(m);
	}
	/**
	 * getMob returns the mob of a specific room
	 * @param x
	 * @return
	 */
	public MOB getMob(String x){
		for(MOB m : mobList){
			if (x.equalsIgnoreCase(m.getMobName())){
				return m;
			}
		}
		return null;
	}
	
	/**
	 * Returns MOB list for current room
	 * @return MOB List
	 */
	public ArrayList<MOB> getMobList(){
		return mobList;
	}
	
	/**
	 * instead of returning the array list this method returns the array list as a string
	 * @return
	 */
	public String stringMobList() {
		String mobs = "";
		for (int i = 0; i < mobList.size() ; i++){
			mobs = mobs + mobList.get(i).getMobName()+", ";
		}
		return mobs;
	}
	
/**
 * description gives a description of the rooms
 * @return String that is the description
 */
	
public String description(){
	String exits = "";
	for (int i = 0; i < exitList.size() ; i++){
		exits = exits +"\n"+ exitList.get(i).getName();
	} 
	String items = I.returnItemList();
	String m = ( "Your exit options are \n"+ exits + "\n");
	
	return m;
}


/**
 * isMoveValid checks through rooms exits to see if passed in string matches name of any of the exit options
 * @param s door name passed in from user
 * @return room object of next room (the one the user wants to go to)
 */
public Room isMoveValid(String s, int playerPartySize){
	for(Exit e : exitList){
		if(s.equalsIgnoreCase(e.getName())){
			if(e.getLockState()== true){
			return e.getNextRoom();
			}else if (e.getLockState()==false&& e.getPartySize()<= playerPartySize){
				return e.getNextRoom();
			}
	} 
	}return null;
	}

/**
 * getRoomInventory gets the Room's inventory in the room class
 * @return
 */
public String getRoomInventory(){
	return I.returnItemList();
}
/**
 * gets the inventory object
 * @return
 */
public Inventory getInventory() {
	return I;
}
/**
 * returns the list of exits 
 * @return
 */
public ArrayList<Exit> getExitList() {
	return exitList;
}

} 
