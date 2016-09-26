import java.util.ArrayList;
public class Inventory {
	
	/**
	 * Creates an inventory object that contains an array of items 
	 * @param Item[] x an array of items that are entered from other classes
	 */
	
	//  List<String> list = new ArrayList<String>();
	public Inventory(Item[] x ){  //or MOB
		ArrayList myInventory = new ArrayList  (40);
		
		for (int n=0; n <= x.length; n++){
			myInventory.add(x[n]);
		}
	}
	public Item getItem(String x){
		for(Item i : this){
		x.equalsIgnoreCase(i.getName());
		this.remove(i);
		return i;
	} return null;
	}
	
	public Item getItemName(String x){
		for(Item i : this){
			x.equalsIgnoreCase(i.getName());
			return i;
		} return null;
		}
	public null add(Item item){
		myInventory.add(item);
	}
}
