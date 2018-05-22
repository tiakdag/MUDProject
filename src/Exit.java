public class Exit {

	 private Room nextRoom;
	 private String exitName;
	 private boolean lockState;
	 private int partySize;
	/**
	 * Constructs an exit class that stores exit options and has reference to all connected rooms
	 * @param initialLockState is the locked state of the door
	 */
	public Exit(Room r, String s,Boolean lock, int requiredPartySize){ //Probably needs references to connected exits passed in?
		 this.nextRoom = r;
		 this.exitName = s;
		lockState = lock;
		partySize = requiredPartySize;
	}
	/**
	 * getName() gets the name of the exit we are looking for
	 * @return exitName
	 */
	public String getName(){
		return exitName;
	}
	
	/**
	 * getNextRoom creates an exit for the room 
	 * @return the Room object the the exit links too (ie nextRoom)
	 */
	public Room getNextRoom(){
		return nextRoom;
	}
	/**
	 * getDoorStatus() checks to see if the door is able to open or not
	 * @return the status of the door
	 */
	public boolean getLockState(){
		return lockState;
	}
	/**
	 * setDoorStatus(boolean) sets the door status to locked or open
	 * @param tf if true door is locked if false door is unlocked
	 */
	public void setLockState(boolean tf){
		this.lockState = tf; //I dont know if 'this.' is necessary, but I also dont want to let this method unlock all doors.
	}
	/**
	 * getPartySize get the current party size
	 * @return
	 */
	public int getPartySize(){
		return partySize;
	}
	/**
	 * sets the party size to be the value of x
	 * @param x
	 */
	public void setPartySize(int x) {
		partySize = x;
	}
}