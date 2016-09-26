import java.util.*;


public class Boot {
	
	private Boot() {
		Item sub = new item("Johnny Jim's sub");
		Item onion = new item("Onion");
		Item snack = new item("Scooby Snack");
		
		
		Room kitchen = new room("kitchen", [sub]);
		Room diningRoom = new room("dining room", [onion]);
		Room masterBedRoom = new room("master bed room", [snack]);
		
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


