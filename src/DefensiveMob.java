import java.util.concurrent.locks.ReentrantLock;

public class DefensiveMob extends MOB {

	public DefensiveMob(String name, String description, String image, GameObservable observable, int sleepTimer,
			Room startLocation, ReentrantLock Reentrant, int offense, int defense) {
		super(name, description, image, observable, sleepTimer, startLocation, Reentrant,offense,defense );
		// TODO Auto-generated constructor stub
	}

}
