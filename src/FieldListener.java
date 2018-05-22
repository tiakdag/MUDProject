
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.JTextField;
/* 
 * Class Description: This class is the action listener for the textView class.
 * It knows when the user inputs a value and reacts accordingly. 
 * 
 * 
 */

public class FieldListener implements ActionListener {
	private JTextField jtf;
	private String s;
	private boolean endGame;
	private Scanner reader = new Scanner(System.in);
	private Player p;
	private GUI myGUI;
	private String lineSpace = "\n------------------\n";
	private String standardEnding;
	private GameObservable obs;

	/**
	 * constructs the filedListener class which contains our game
	 * 
	 * @param j
	 *            JextField
	 * @param player
	 * @param gui
	 */

	public FieldListener(JTextField j, Player player, GameObservable observable, GUI gui) {
		jtf = j;
		endGame = false;
		myGUI = gui;
		p = player;
		standardEnding = "\n What do you do next? \n" + "\n Valid cmds: open ___, get__, drop___,add  ,  lost \n";
		obs = observable;
	}

	/**
	 * actionPerformed is the game
	 */
	public void actionPerformed(ActionEvent arg0) {
		s = jtf.getText();
		reader = new Scanner(s);
		String cmd = reader.next();
		String t = getArgument(s, cmd);
		myGUI.clearUIline();
		if (cmd.equalsIgnoreCase("exit")) {
			obs.terminate();
			myGUI.close();
			p.getBoot().exitAll();
		} else if (cmd.equalsIgnoreCase("open")) {
			String moveRequest = t;
			boolean bool = p.moveRooms(moveRequest);
			if (bool == true) {
				String roomName = p.location();
				myGUI.updateRoomIcon(p.getRoom());
				myGUI.updateRoomTextArea(p.getRoom().getRoomInventory(), p.getRoom().stringMobList());
				myGUI.updateTextArea(lineSpace + " You have moved into the " + roomName + "\n" + p.getDescription()
						+ standardEnding);
				myGUI.updateMobIcon(p.getRoom());
				obs.alertObservers();
			} else {
				myGUI.updateTextArea("\n Yo dum dum, you cant open that/it don't exist");
			}
			// eventually this will have to increment some kind of turn counter
			// so that MOBs are signaled to also move
		} else if (cmd.equalsIgnoreCase("get")) {
			String itemRequest = t;
			boolean bool = p.pickUpItem(itemRequest);
			if (bool == true) {
				myGUI.updateTextArea(
						lineSpace + "You have picked up a glorious " + itemRequest + "\n" + p.getDescription());
				// myGUI.updatePlayerTextArea("\n \n"+itemRequest);
				myGUI.updatePlayerTextArea(p.getPlayerInventory());
				myGUI.updateRoomTextArea(p.getRoom().getRoomInventory(), p.getRoom().stringMobList());
				obs.alertObservers();
			} else {
				myGUI.updateTextArea("\n Yo dum dum, you cant get that/it don't exist");
			}
		} else if (cmd.equalsIgnoreCase("drop")) {
			String dropRequest = t;
			boolean bool = p.dropItem(dropRequest);
			if (bool == true) {
				myGUI.updateTextArea(lineSpace + "You have sucessfully dropped that useless old " + dropRequest + "\n"
						+ p.getDescription());
				myGUI.updatePlayerTextArea(p.getPlayerInventory());
				myGUI.updateRoomTextArea(p.getRoom().getRoomInventory(), p.getRoom().stringMobList());
				obs.alertObservers();
			} else {
				myGUI.updateTextArea("\n Yo dum dum, you cant drop what you don't have");
			}
		} else if (cmd.equalsIgnoreCase("lost")) {
			myGUI.updateTextArea(
					lineSpace + "You are currently in what appears to be a " + p.location() + standardEnding);
		} else if (cmd.equalsIgnoreCase("42")) {
			myGUI.makeShrekGIF();
		} else if (cmd.equalsIgnoreCase("add")) {
			String mobRequest = t;
			boolean bool = p.addMob(mobRequest);
			if (bool == true) {
				if (p.getRoom().getMob(mobRequest).getMobDescription().equals("locked")
						&& p.getPartySize() < ((LockedMOB) (p.getRoom().getMob(mobRequest)))
								.getRequiredPartySizeForMob()) {
					myGUI.updateTextArea("\nYour squad isn't large enough to trap this MOB");
				} else if (p.getRoom().getMob(mobRequest).getMobDescription().equals("offensive")
						&& p.getDefensiveState() == false) {
					myGUI.updateTextArea(p.removeItemAt(0));
					obs.alertObservers();
				} else {
					if (p.getRoom().getMob(mobRequest).getMobDescription().equals("defensive")) {
						p.setDefensiveState(true);
					}

					Item mobItem = new Item(p.getRoom().getMob(mobRequest));
					p.addItem(mobItem);
					p.getMobItems(p.getRoom().getMob(mobRequest));
					p.incrementPartySize();
					p.getRoom().getMob(mobRequest).fatality();
					myGUI.updateTextArea(
							lineSpace + "You have added " + mobRequest + " to your party \n" + p.getDescription());
					myGUI.updatePlayerTextArea(p.getPlayerInventory());
					myGUI.updateRoomTextArea(p.getRoom().getRoomInventory(), p.getRoom().stringMobList());
					myGUI.updateMobIcon(p.getRoom());
					
					p.getBoot().finalBattle();
					obs.alertObservers();
				}
			} else {
				myGUI.updateTextArea("\n Yo dum dum, you cant get that/it don't exist");
			}
		} else if (cmd.equalsIgnoreCase("final")) {
			p.getBoot().twoPlayerFinalBattleLastResort();
		
		}else if (cmd.equalsIgnoreCase("single")){
			p.getBoot().onePlayerFinalBattleLastResort();
		}else if (cmd.equalsIgnoreCase("arsenal")) {
			myGUI.makeGreatness();
		} else {
			myGUI.updateTextArea(lineSpace + "Command not recognized");
		}

		// System.out.println(p.getDiscription()) <-- need to write this method
		// to get the disc from the players current room.

	}// End While loop

	/**
	 * getArgument lets the user type in spaces
	 * 
	 * @param s
	 * @param c
	 * @return
	 */
	private String getArgument(String s, String c) {
		for (int i = 0; i < c.length(); i++) {
			s = s.replace(c, " ");
		}
		String q = s.trim();
		return q;
	}

}