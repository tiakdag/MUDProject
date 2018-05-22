import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.locks.ReentrantLock;

public class MOB extends Thread implements Observer {
	// individualize mobs in constructor
	protected ReentrantLock lock = new ReentrantLock();
	protected String mobName;
	protected String mobDescription;
	protected String mobImage;
	protected Inventory mobInventory;
	protected Room mobRoom;
	protected int currentPartySize = 0;
	protected int sleep;
	protected GameObservable obs;
	protected boolean run;
	protected boolean run2 = true;
	protected Inventory roomInventory = new Inventory();
	protected boolean gameOgre;
	protected int offense;
	protected int defense;
	protected boolean stillRunning = true;

	// players and mobs are observers
	// have a field that connects to observable
	/**
	 * MOB constructor
	 * 
	 * @param name
	 * @param description
	 * @param image
	 * @param observable
	 * @param sleepTimer
	 * @param startLocation
	 */
	public MOB(String name, String description, String image, GameObservable observable, int sleepTimer,
			Room startLocation, ReentrantLock Reentrant,int aOffense, int aDefense) {
		mobName = name;
		mobDescription = description;
		mobImage = image;
		mobInventory = new Inventory();
		sleep = sleepTimer;
		obs = observable;
		mobRoom = startLocation;
		lock = Reentrant;
		gameOgre = obs.getInterruptState();
		offense = aOffense;
		defense = aDefense;
	}

	/**
	 * thread method that makes the Mob's do stuff
	 */
	public void run() {
		run = obs.getBoolean();
		while (run && run2) {
			ArrayList<Exit> exitList = new ArrayList<Exit>(10);
			exitList = mobRoom.getExitList();
			int j = randomNumber(exitList.size());
			try {
				lock.lock();
				moveRooms(exitList.get(j).getName());
				obs.alertObservers();
			} finally {
				lock.unlock();
			}
			try {
				Thread.sleep(sleep * 1000);
			} catch (InterruptedException e) {
			}
			run = obs.getBoolean();

		}
		return;

	}
	/**
	 * get's a mob's offense stat
	 * @return
	 */
	public int getOffense(){
		return offense;
	}
	/**
	 * get's a mob's defense stat
	 * @return
	 */
	public int getDefense(){
		return defense;
	}
	/**
	 * gets the mob's description
	 * @return
	 */
	public String getMobDescription(){
		return mobDescription;
	}
	/**
	 * getName() gets the name of the player and returns that name
	 * 
	 * @return the name of the player
	 */
	public String getMobName() {
		return mobName;
	}

	/**
	 * location() gets the name of the room that the player is currently in
	 * 
	 * @return the name of the room
	 */
	public String location() {
		return mobRoom.getRoom();
	}

	/**
	 * set the location of the player
	 * 
	 * @param the
	 *            new location of the player
	 */
	public void setLocation(Room currentRoom) {
		this.mobRoom = currentRoom;
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
		Item itemCheck = mobRoom.getItem(x);
		if (itemCheck == null) {
			return false;
		} else {
			mobInventory.add(itemCheck);
			return true;
		}
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
		Item itemCheck = mobInventory.getItemName(x);
		if (itemCheck == null) {
			return false;
		} else {
			mobInventory.remove(itemCheck);// removes item from player inventory
			mobRoom.addItem(itemCheck); // adds item to room inventory
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

		Room nextRoom = mobRoom.isMoveValid(s, currentPartySize);
		if (nextRoom == null) {
			return false;
		} else {
			mobRoom.removeMob(this);
			setLocation(nextRoom);
			mobRoom.addMob(this);
			return true;
		}
	}

	/**
	 * getDescription gets a description of the room
	 * 
	 * @return the string description of room
	 */
	public String getDescription() {
		return mobRoom.description();
	}

	/**
	 * getRoom gets the room that the player is in
	 * 
	 * @return room
	 */
	public Room getRoom() {
		return mobRoom;
	}

	/**
	 * gets the player's inventory
	 * 
	 * @return
	 */
	public String getPlayerInventory() {
		return mobInventory.returnItemList();
	}

	/**
	 * gets the Room's inventory
	 * 
	 * @return
	 */
	public String getRoomInventory() {
		return mobRoom.getRoomInventory();
	}

	/**
	 * generate that random number
	 * 
	 * @param x
	 * @return
	 */
	protected int randomNumber(int x) {
		x = (int) (Math.random() * (x));

		return x;
	}

	/**
	 * real fancy method here so complex where to begin. Ends the run method as
	 * you can see
	 * 
	 * @return
	 */
	public void endRun() {
		run = false;
	}

	/**
	 * gets the filepath for images
	 * 
	 * @return
	 */
	public String getMobFilepath() {

		return mobImage;
	}

	/**
	 * brutally stops a mob ending their sweet freedom and making them our
	 * slaves MUUAHHAHAHAHAHAHAHAHAHA
	 */
	public void fatality() {
		this.interrupt();
		this.run2 = false;
		stillRunning = false;
		mobRoom.removeMob(this);
	}
	/**
	 * see's if the thread is still running
	 * @return
	 */
	public boolean stillRunning(){
		return stillRunning;
	}
	/**
	 * gets mob's inventory
	 * 
	 * @return
	 */
	public Inventory getMobInventory() {
		return mobInventory;
	}

	/**
	 * update for mobs see if we have picked them up
	 */
	public void update(java.util.Observable arg0, Object arg1) {
		gameOgre = obs.getInterruptState();
		run = obs.getBoolean();
		if (gameOgre) {
			this.interrupt();
		}
	}

}
