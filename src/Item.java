/** A class that creates an item 
 * 
 * @author takdag
 *
 */
public class Item {
private Item y;
private String name;
private String type;
private int offense;
private int defense;

	/**
 * Constructs a Item object that has a name and can be picked up.
 * @param x the name of the object that will be picked up
 */
	public Item(String x, int aItemOffense, int aItemDefense){
		name = x;
		type = "item";
		offense =aItemOffense;
		defense =aItemDefense;
	}
	/**
	 * get's mobs defense
	 * @return
	 */
	public int getDefense(){
		return defense;
	}
	/**
	 * get's mobs offense
	 * @return
	 */
	public int getOffense(){
		return offense;
	}
	
	
	/**
	 * constructs an item object for a mob
	 * @param m
	 */
	public Item(MOB m){
		name = m.getMobName();
		type = "MOB";
		offense = m.getOffense();
		defense = m.getDefense();
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
	public String getItem(String x){
		if (x == name){
			return x;
		}else return null;
	}
	
	
}

