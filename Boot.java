import java.util.*;
import java.Math.*;


public class Boot {
	
	private Boot() {
		Item sub = new item("Johnny Jim's sub");
		Item onion = new item("Onion");
		Item snack = new item("Scooby Snack");
		
		
		Room kitchen = new room("kitchen", [sub]);
		Room diningRoom = new room("dining room", [onion]);
		Room masterBedRoom = new room("master bed room", [snack]);
		
		Player player1 = new player();
		
		int startLoc = (int)((double)Math.rand()*10)%3;
		
		switch(startLoc){
			case 1: player1.setLocation(kitchen);
					break;
			case 2: player1.setLocation(diningRoom);
					break;
			case 3: player1.setLocation(masterBedRoom);
					break;
			default: player1.setLocation(kitchen);
					break;
		}
		
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


