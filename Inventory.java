import java.util.ArrayList;
public class Inventory {
	
	/**
	 * Creates an inventory object that contains an array of items 
	 * @param Item[] x an array of items that are entered from other classes
	 */
	Item [] items;
	//  List<String> list = new ArrayList<String>();
	public Inventory(Item[] x ){  //or MOB
		ArrayList myInventory = new ArrayList  (40);
		myInventory = items;
		for (int n=0; n <= x.length; n++){
			myInventory.add(x[n]);
		}
	} 
/**
 * get the item 
 * @param String x
 * @return the name of the item in the index
 */
	public Item getItem(String x){
		for(Item i : this){
		x.equalsIgnoreCase(i.getName());
		this.remove(i);
		return i;
	} return null;
	}
	/**
	 * getItemName
	 * @param String x
	 * @return the name of the item
	 */
	public Item getItemName(String x){
		for(Item i : this){
			x.equalsIgnoreCase(i.getName());
			return i;
		} return null;
		}
	public void add(Item item){
		myInventory.add(item);
	}
	
	public Inventory getInventory(){
		return items;
	}
}

