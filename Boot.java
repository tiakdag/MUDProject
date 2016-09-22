import java.util.*;


public class Boot {
	
	private Boot() {
		Room kitchen = new room("kitchen");
		Room diningRoom = new room("dining room");
		Room masterBedRoom = new room("master bed room");
		
		Item sub = new item("Johnny Jim's sub");
		Item onion = new item("Onion");
		Item snack = new item("Scooby Snack");
		
		Player player1 = new player();
		
		g.addExit(e1);
		
		p.addItem(sub);
		p.addItem(onion);
		p.addItem(snack);
		
		UI ui - new UI(new Scanner (system.in), p);
		
		system.out.println(p.addItem(sub));
		p.getItem(sub);
		
	}
}


