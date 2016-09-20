
public class Room {
/**
 * constructs a room object that has a name and can be entered
 * @param x the name of the room that will be entered
 */
	public Room(String x){
		name = x;
	}
	/**
	 * getRoom() gets the name of the room
	 * @return the name of the room
	 */
	public String getRoom() {
		return name;
	}
	private String name;
}

