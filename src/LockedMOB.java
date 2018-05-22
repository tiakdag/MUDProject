import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
public class LockedMOB extends MOB {
	private boolean available;
	private int partySize;
	public LockedMOB(String name, String description, String image, GameObservable observable, int sleepTimer,
			Room startLocation,  ReentrantLock Reentrant,boolean isAvailable, int thePartySize,int offense, int defense) {
		super(name, description, image, observable, sleepTimer, startLocation, Reentrant,offense,defense);
		available = isAvailable;
		partySize = thePartySize;
	}
	/**
	 * see's if the mob is available
	 * @return
	 */
	public boolean getAvailable(){
		return available; 
	}
	/**
	 * checks the size needed to add that mob
	 * @return
	 */
	public int getRequiredPartySizeForMob(){
		return partySize;
	}
	
	


}
