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
	 * getItem checks to see if the name of the object we are getting
	 * matches and if it does return that name
	 * @param  x
	 * @return the item 
	 */
	public Item getItem(String x){
		if (x == name){
			return x;
		}else return null;
	}
	
	private String name;
}

