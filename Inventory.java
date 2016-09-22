import java.util.ArrayList;
public class Inventory {
	
	/**
	 * Creates an inventory object that contains an array of items 
	 * @param Item[] x an array of items that are entered from other classes
	 */
	
	//  List<String> list = new ArrayList<String>();
	public Inventory(Item[] x ){  //or MOB
 		ArrayList myInventory = new ArrayList  (40);
	
		for (int i=0; i <= x.length; i++){
			myInventory.add(x[i]);
		}
	}
	public Item getItem(String x){
		if (this.contains(x)){
		this.remove(x);
		return ()
		}else return null;
	}
	
}
