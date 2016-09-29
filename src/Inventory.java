import java.util.ArrayList;
public class Inventory {
	
	ArrayList<Item> myInventory;
	/**
	 * Creates an inventory object that contains an array of items 
	 * @param Item[] x an array of items that are entered from other classes
	 */
	
	//  List<String> list = new ArrayList<String>();
	public Inventory(){  //or MOB
		myInventory = new ArrayList <Item> (40);
	} 
/**
 * get the item 
 * @param x
 * @return
 */
	public Item getItem(String x){
		for(Item i : myInventory){
		x.equalsIgnoreCase(i.getName());
		myInventory.remove(i);
		return i;
	} return null;
	}
	/**
	 * getItemName checks the room's inventory for desired item
	 * @param x name of the item
	 * @return desired item or null if item is not in the room
	 */
	public Item getItemName(String x){
		for(Item i : myInventory){
			x.equalsIgnoreCase(i.getName());
			return i;
		} return null;
		}
	/**
	 * add, puts an item into an array of items
	 * @param item
	 */
	public void add(Item item){
		myInventory.add(item);
	}
	/**
	 * remove, takes out an item in the array of items
	 * @param item
	 */
	public void remove(Item item){
		myInventory.remove(item);
	}
	public String returnItemList(){
		String items = "";
		for (int i = 0; i < myInventory.size() ; i++){
			items = items +", "+ myInventory.get(i).getName();
		}
		return items;
	}
}
	
