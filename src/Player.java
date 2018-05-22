import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * A class that creates a player
 * 
 * @author takdag
 *
 */
public class Player implements Observer {
	private String name;
	private Room room;
	private Inventory inventory;
	private int currentPartySize;
	private ReentrantLock lock;
	private Boot aBoot;
	private GameObservable obs;
	private boolean defensive = false;
	/**
	 * Player() Constructs a player object that has a name and empty inventory
	 * 
	 */
	public Player(ReentrantLock deadbolt, Boot boot,GameObservable observable) {
		name = "Scooby";
		inventory = new Inventory();
		currentPartySize = 0;
		lock = deadbolt;
		aBoot = boot;
	}
	
	
	/**
	 * gets the player's total offense and defense
	 * @return
	 */
	public double getTotalCombatScore(){
		return (inventory.addOffense() + (inventory.addDefense()));
	}
	
	/**
	 * get the player's current party size
	 * @return
	 */
	public int getPartySize(){
		return currentPartySize;
	}
	/**
	 * get's defensive state of the player
	 * @return
	 */
	public boolean getDefensiveState(){
		return defensive;
	}
	/**
	 * set the defensive state
	 * @param x
	 */
	public void setDefensiveState(boolean x){
		defensive = x;
	}
	/**
	 * i dont know what your talking aboot
	 * gets the boot
	 * @return
	 */
	public Boot getBoot(){
		return aBoot;
	}
	/**
	 * getName() gets the name of the player and returns that name
	 * 
	 * @return the name of the player
	 */
	public String getName() {
		return name;
	}

	/**
	 * location() gets the name of the room that the player is currently in
	 * 
	 * @return the name of the room
	 */
	public String location() {
		return room.getRoom();
	}

	/**
	 * set the location of the player
	 * 
	 * @param the
	 *            new location of the player
	 */
	public void setLocation(Room currentRoom) {
		this.room = currentRoom;
	}

	/**
	 * boolean pickUpItem allows a player to pick up an item player calls on the
	 * inventory of the room to see if item is in room. If item is in room, then
	 * remove the item from inventory of room to inventory of the player.
	 * 
	 * @param String
	 *            x
	 * @return true if the item is in the inventory of the room
	 */

	public boolean pickUpItem(String x) {
		Item itemCheck = room.getItem(x);
		if (itemCheck == null) {
			return false;
		} else {
			try {
				lock.lock();
				inventory.add(itemCheck);
				return true;
			} finally {
				lock.unlock();
			}
		}
	}
	/**
	 * removes an item from the player's inventory
	 */
	public String removeItemAt(int x){
		
		if(inventory.getLength()!= 0){
			Item item = inventory.getItemAt(x);
			inventory.remove(item);
			return ("\nGuess what?  Your lovely "+ item.getName()+" has been stolen!!!  Also to add more pain you couldn't add them to your party!!");
		}else{
			return("\nYou cannot add this mob, they too slippery");
		}
	}
	/**
	 * adds the item to the players inventory how many add items can we have in
	 * one game? stay tuned to find out
	 */
	public void addItem(Item x) {
		inventory.add(x);
	}

	/**
	 * adds 1 to the party size
	 */
	public void incrementPartySize() {
		currentPartySize++;
	}

	/**
	 * add mob adds the mob to the players inventory
	 * 
	 * @param x
	 * @return
	 */
	public boolean addMob(String x) {
		return room.getMobItem(x);
	}

	/**
	 * Remove an item from the player's inventory
	 * 
	 * @param String
	 *            x
	 * @return false if there is no item in the player's inventory true if
	 *         player has an item in their inventory
	 */
	public boolean dropItem(String x) {
		Item itemCheck = inventory.getItemName(x);
		if (itemCheck == null) {
			return false;
		} else {
			inventory.remove(itemCheck);// removes item from player inventory
			room.addItem(itemCheck); // adds item to room inventory
			return true;
		}

	}

	/**
	 * moveRooms Takes in a door name (string) and asks the room if that is a
	 * valid exit. if the exit is valid, then the current room will send back
	 * the next room and change the players location
	 * 
	 * @param s
	 *            is the name of the door the player wishes to 'open' / go
	 *            through
	 * @return true if player went to next room, false if next room doesnt exist
	 */
	public boolean moveRooms(String s) {
		Room nextRoom = room.isMoveValid(s, currentPartySize);
		if (nextRoom == null) {
			return false;
		} else {
			setLocation(nextRoom);
			return true;
		}
	}

	/**
	 * getDescription gets a description of the room
	 * 
	 * @return the string description of room
	 */
	public String getDescription() {
		return room.description();
	}

	/**
	 * getRoom gets the room that the player is in
	 * 
	 * @return room
	 */
	public Room getRoom() {
		return room;
	}

	/**
	 * gets the player's inventory
	 * 
	 * @return
	 */
	public String getPlayerInventory() {
		return inventory.returnItemList();
	}

	/**
	 * gets the Room's inventory
	 * 
	 * @return
	 */
	public String getRoomInventory() {
		return room.getRoomInventory();
	}

	/**
	 * sets the party size of the player
	 * 
	 * @param x
	 */
	public void setPartySize(int x) {
		currentPartySize = x;

	}

	/**
	 * get the precious items the mob has and make them yours you awful bastard
	 * 
	 * @param x
	 */
	public void getMobItems(MOB x) {
		if (x.getMobInventory().getLength() > 0) {
			for (int i = 0; i < x.getMobInventory().getLength(); i++) {
				inventory.add(x.getMobInventory().getItemAt(i));
			}
		}
	}
	/**
	 * extends this so we can use in boot
	 * @return
	 */
	public boolean playersInSameRoom(){
		if(aBoot.sameLocation()){
			return true;
		}else {
			return false;
		}
	}
	@Override
	public void update(Observable o, Object arg) {
	//TODO

	}
}