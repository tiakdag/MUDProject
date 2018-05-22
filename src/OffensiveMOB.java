import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class OffensiveMOB extends MOB {
	
	public OffensiveMOB(String name, String description, String image, GameObservable observable, int sleepTimer,
			Room startLocation, ReentrantLock Reentrant,int offense, int defense) {
		super(name, description, image, observable, sleepTimer, startLocation, Reentrant,offense,defense);
		
	}
	public void run(){
		run = obs.getBoolean();
		while (run && run2) {

			ArrayList<Exit> exitList = new ArrayList<Exit>(10);
			roomInventory = mobRoom.getInventory();

			int l = roomInventory.getLength();
			if (l != 0) {
				int i = randomNumber(l);
				try {
					lock.lock();
					pickUpItem(roomInventory.getItemAt(i).getName());
					obs.alertObservers();

				} finally {
					lock.unlock();
				}
			}

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
	

}
