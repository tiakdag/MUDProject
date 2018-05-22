
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
		Exit e1 = new Exit(diningRoom, "DoubleDoorToDiningRoom");
		Exit e2 = new Exit(hall, "ServantsPassagewayToHall");
		//Dinning Room's Exits
		Exit e3 = new Exit(kitchen , "DoubleDoorToKitchen");
		Exit e4 = new Exit(study, "OrnateArchwayToStudy");
		//Study's Exits
		Exit e5 = new Exit(diningRoom, "OrnateArchwayToDiningRoom");
		Exit e6 = new Exit(hall, "BigOleDoorToHall");
		//Hall's Exits
		Exit e7 = new Exit(study, "BigOleDoorToStudy");
		Exit e8 = new Exit(kitchen, "ServantsPassagewayToKitchen");
		
		
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
		
		// create player
		Player player1 = new Player();
		
		// put player into a random room
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
					
		
		// create User interface
		UI ui = new UI(player1);
		
		
	}
}


