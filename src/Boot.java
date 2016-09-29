
import java.lang.Math;


public class Boot {
	
	Boot() {
		//ITEM CREATION
		
		Item sub = new Item("JohnnyJim'sSub");
		Item onion = new Item("Onion");
		Item snack = new Item("ScoobySnack");
		
		//ROOM CREATION
		
		Room kitchen = new Room("kitchen", "This is a  Kitchen");
		Room diningRoom = new Room("dining room", "This is a Dining Room");
		Room study = new Room("study", "This is a Study");
		Room hall = new Room ("hall", "This is a Hallway");
		
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
		
		
		// filling rooms 
		kitchen.addExit(e1);
		kitchen.addExit(e2);
		kitchen.addItem(snack);
		
		diningRoom.addExit(e3);
		diningRoom.addExit(e4);
		diningRoom.addItem(onion);
		
		study.addExit(e5);
		study.addExit(e6);
		study.addItem(sub);
		
		hall.addExit(e7);
		hall.addExit(e8);
		
		
		Player player1 = new Player();
		
		int startLoc = (int)((double)Math.random()*10)%3;
		
		if (startLoc ==1){
			 player1.setLocation(kitchen);
		}else if (startLoc == 2){
			 player1.setLocation(diningRoom);
		}else if (startLoc == 3) {
			 player1.setLocation(study);
		}else if (startLoc == 4){
			player1.setLocation(hall);
		}else  player1.setLocation(hall);
					
		
		
		
		
		/* --I don't think we need this because start items are fed into constructor-- Ben
		p.addItem(sub);
		p.addItem(onion);
		p.addItem(snack);
		*/
		
		UI ui = new UI(player1);
		
		
		
		
	}
}

