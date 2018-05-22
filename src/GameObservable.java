
public class GameObservable extends java.util.Observable {//notification
	
	private boolean running = true;
	private boolean interruptState = false;
	private boolean location = false;
	/**
	 * constructs an observable object
	 */
	public GameObservable(){
		
	}
	/**
	 * gets the boolean in the observable  class
	 * @return
	 */
	public boolean getBoolean(){
		return running;
	}
	/**
	 * tells threads to stop doing stuff
	 */
	public void terminate(){
		running = false;
		interruptState = true;
		alertObservers();
	}
	
	/**
	 * alerts the observers 
	 */
	public void alertObservers(){
		setChanged();
		notifyObservers(); 
	}
	/**
	 * sees if player's are in sameLocation
	 * @return
	 */
	public boolean sameLocation(){
		return location;
	}
	/**
	 * the interrupt state of mobs
	 * @return
	 */
	public boolean getInterruptState() {
		return interruptState;
	}
}
