import java.util.*;

public class UI {

	private Scanner reader = new Scanner(System.in);
	private boolean endGame = false;
	
  /**
   * UI is a class that constructs a scanner that starts the game 
   * @param p
   */
	public UI(Player p){
	  System.out.println("Your eyes slide open and a musky stench fills your lungs.");
	  System.out.println("Welcome to the Swamp, are you new here?");
	  System.out.println("A raspy voice stings your ears. You whip your head around to find");
	  System.out.println("...NOTHING (AHHHHH) #dontdie #YOLO");
	  
	  //This method will keep going until the player types "exit"
	  while(!endGame){
		  String y = p.getDescription();
		  System.out.println(y);
		  System.out.println("What do you do next?");
		  System.out.println("Valid cmds: move ___, get__, drop___, lost");
		  String cmd = reader.next();
		  
		  if (cmd.equalsIgnoreCase("exit")){
			  endGame = true;
		  }
		  else if (cmd.equalsIgnoreCase("move")){
			  String moveRequest = reader.next();
			  boolean bool = p.moveRooms(moveRequest);
			  if (bool == true){
				  String roomName = p.location();
				  System.out.println("You have moved into the " + roomName);
			  }
			  else{
				  System.out.println("Yo dum dum, you cant open that/it don't exist");
			  }
			  //eventually this will have to increment some kind of turn counter so that MOBs are signaled to also move
		  }
		  else if (cmd.equalsIgnoreCase("get")){
			  String itemRequest = reader.next();
			  boolean bool = p.pickUpItem(itemRequest);
			  if (bool == true){
				  System.out.println("You have picked up a glorious " + itemRequest);
			  }
			  else{
				  System.out.println("Yo dum dum, you cant get that/it don't exist");
			  }
		  }
		  else if (cmd.equalsIgnoreCase("drop")){
			  String dropRequest = reader.next();
			  boolean bool = p.dropItem(dropRequest);
			  if (bool == true){
				  System.out.println("You have sucessfully dropped that useless old " + dropRequest);
			  }
			  else{
				  System.out.println("Yo dum dum, you cant drop what you don't have");
			  }
		  }
		  else if (cmd.equalsIgnoreCase("lost")){
			  System.out.println("You are currently in what appears to be a " + p.location());
		  }
		  //Add search case later (make sure search and move eventually progress "turn counter" so that MOBs can move
		  else{
			  System.out.println("Command not recognized");
		  }
			  
		  //System.out.println(p.getDiscription()) <-- need to write this method to get the disc from the players current room. 
	  
	  }//End While loop
	  System.out.println("GAME OGRE");
	  
	  
  }



}
