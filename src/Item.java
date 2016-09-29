/** A class that creates an item 
 * 
 * @author takdag
 *
 */
public class Item {
/**
 * Constructs a Item object that has a name and can be picked up.
 * @param x the name of the object that will be picked up
 */
	public Item(String x){
		name = x;
	}
	/**
	 * getName() gets the name of the object and returns that name
	 * @return the name of the object
	 */
	public String getName(){
		return name;
	}
	/**
	 * pickUpItem takes the item and will add it to the inventory.
	 * 
	 * @return a message saying the player has picked up a item 
	 */
	

	
	private String name;
}
