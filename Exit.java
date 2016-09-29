import java.util.*;

public class Exit {

	 private Room nextRoom;
	 private String exitName;
	/**
	 * Constructs an exit class that stores exit options and has reference to all connected rooms
	 * @param initialLockState is the locked state of the door
	 */
	public Exit(Room r, String s){ //Probably needs references to connected exits passed in?
		 this.nextRoom = r;
		 this.exitName = s;
		
	}
	//I dont know what this method is #UMLproblems
	public void door(){
		
	}
	//I dont know what this class is #UMLproblems
	public void lockedDoor(){
		
	}
	/**
	 * exitRoom creates an exit for the room 
	 * @param Room r
	 * @param String s
	 * compare the room we want to go to and the string we pass in for the name of the room
	 */
	public exitRoom(Room r, String s){
		if (getRoom(r)== s){
			return r;
		} else return "error";
	}
	/**
	 * getDoorStatus() checks to see if the door is able to open or not
	 * @return the status of the door
	 */
	public boolean getDoorStatus(){
		return doorStatus;
	}
	/**
	 * setDoorStatus(boolean) sets the door status to locked or open
	 * @param tf if true door is locked if false door is unlocked
	 */
	public void setDoorStatus(boolean tf){
		this.doorStatus = tf; //I dont know if 'this.' is necessary, but I also dont want to let this method unlock all doors.
	}
	private boolean doorStatus;
}
