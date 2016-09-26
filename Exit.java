import java.util.*;

public class Exit {

	//Constructor
	public Exit(boolean initialLockState){ //Probably needs references to connected exits passed in?
		doorStatus = initialLockState;
	}
	//I dont know what this method is #UMLproblems
	public void door(){
		
	}
	//I dont know what this class is #UMLproblems
	public void lockedDoor(){
		
	}
	//Checks to see if doors are locked or not
	public boolean getDoorStatus(){
		return doorStatus;
	}
	//Changes a locked door to unlocked, or vice versa
	public void setDoorStatus(boolean tf){
		this.doorStatus = tf; //I dont know if 'this.' is necessary, but I also dont want to let this method unlock all doors.
	}
	private boolean doorStatus;
}
