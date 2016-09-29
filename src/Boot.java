import java.util.*;
import java.Math.*;


public class Boot {
	
	private Boot() {
		//ITEM CREATION
		
		Item sub = new Item("Johnny Jim's sub");
		Item onion = new Item("Onion");
		Item snack = new Item("Scooby Snack");
		
		//ROOM CREATION
		
		Room kitchen = new Room("kitchen", [sub], "This is a  Kitchen");
		Room diningRoom = new Room("dining room", [onion], "This is a Dining Room");
		Room study = new Room("study", snack, "This is a Study");
		Room hall = new Room ("hall", null, "This is a Hallway");
		
		//EXIT CREATION
		
		//Kitchen's Exits
		Exit e1 = new Exit(diningRoom, "DoubleDoor");
		Exit e2 = new Exit(hall, "ServantsPassageway");
		//Dinning Room's Exits
		Exit e3 = new Exit(kitchen , "DoubleDoor");
		Exit e4 = new Exit(study, "OrnateArchway");
		//Study's Exits
		Exit e5 = new Exit(diningRoom, "OrnateArchway");
		Exit e6 = new Exit(hall, "BigOleDoor");
		//Hall's Exits
		Exit e7 = new Exit(study, "BigOleDoor");
		Exit e8 = new Exit(kitchen, "ServantsPassageway");
		
		
		
		Player player1 = new Player();
		
		int startLoc = (int)((double)Math.rand()*10)%3;
		
		if (startLoc =1){
			 player1.setLocation(kitchen);
		}else if (startLoc = 2){
			 player1.setLocation(diningRoom);
		}else if (startLoc = 3) {
			 player1.setLocation(masterBedRoom);
		}else if (startLoc = 4){
			player1.setLocation(hall);
		}else  player1.setLocation(hall);
					
		
		
		g.addExit(e1); //This is not right (nothing called 'g')
		
		/* --I don't think we need this because start items are fed into constructor-- Ben
		p.addItem(sub);
		p.addItem(onion);
		p.addItem(snack);
		*/
		
		UI ui = new UI(new Scanner (system.in), p);
		
		system.out.println(p.addItem(sub));
		p.getItem(sub);
		
	}
}

