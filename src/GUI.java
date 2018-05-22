import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class GUI implements Observer {// ActionListener{

	private JPanel jPanel = new JPanel();
	private JFrame bigBox = new JFrame();
	private GridLayout gridLayout = new GridLayout(2, 3);
	private BorderLayout borderLayout = new BorderLayout();

	private JLabel mobPicture = new JLabel();
	private JLabel roomPicture = new JLabel();
	private JLabel shrekPicture = new JLabel();
	private JTextArea textOutput = new JTextArea();
	private DefaultCaret caret = (DefaultCaret) textOutput.getCaret();
	private JTextField uiLine = new JTextField();
	private FieldListener listener;
	private Player player;
	private JTextArea roomInventory = new JTextArea();
	private JTextArea playerInventory = new JTextArea();
	// private Scanner reader = new Scanner(System.in);
	// private boolean endGame = false;
	private JScrollPane scrollPane = new JScrollPane(textOutput);
	private GameObservable obs;
	//private  Timer timer = new Timer(1000,this);
	private ArrayList<MOB> mobs = new ArrayList<MOB>();
	private boolean aTwoPlayers;

	/**
	 * constructor for GUI that creates the big image box for the game has
	 * components that are in this box
	 * 
	 * @param p
	 * 
	 */
	public GUI(Player p, GameObservable observable,boolean twoPlayers) {

		player = p;
		aTwoPlayers = twoPlayers;
		obs = observable;
		obs.addObserver(this);
		listener = new FieldListener(uiLine, p, obs, this);
		bigBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// playerInventory.setBackground(new Color (102,51,0,100));
		// textOutput.setForeground(new Color (71,82,0,74));
		// roomInventory.setBackground(new Color (102,51,0,100));

		jPanel.setLayout(gridLayout);
		bigBox.setLayout(borderLayout);
		if(!twoPlayers){
		bigBox.setBounds(0, 0, 625, 750);
		}else {
			bigBox.setBounds(625, 0, 625, 750);
		}
		uiLine.addActionListener(listener);

		// Adds Images to JLable Fields
		try {
			BufferedImage shrek = ImageIO.read(new File("Images/shrek.png"));
			shrekPicture.setIcon(new ImageIcon(shrek));
			shrekPicture.setText("Shrek Is Love");
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedImage mob = ImageIO.read(new File("Images/mob.jpg"));
			mobPicture.setIcon(new ImageIcon(mob));

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Row 1
		jPanel.add(mobPicture);
		jPanel.add(shrekPicture);
		jPanel.add(roomPicture);
		// Row 2

		jPanel.add(playerInventory);
		jPanel.add(scrollPane);
		jPanel.add(roomInventory);

		bigBox.add(uiLine, BorderLayout.PAGE_END);
		bigBox.add(jPanel, BorderLayout.CENTER);

		bigBox.setVisible(true);
		jPanel.setVisible(true);

		updateRoomIcon(p.getRoom());

		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		textOutput.setLineWrap(true);
		textOutput.setWrapStyleWord(true);
		textOutput.append(
				"Your eyes open and a musky stench fills your lungs. " + "\n Welcome to Tom's Swamp, are you new here? "
						+ "\n A raspy voice stings your ears. \n You whip your head around to find... "
						+ "\n NOTHING (AHHHHH) #dontdie #YOLO \n \n" + player.getDescription()
						+ "\n Valid cmds: open ___, get__, drop___,add   , lost \n");
		textOutput.setEditable(false);

		playerInventory.setLineWrap(true);
		playerInventory.setWrapStyleWord(true);
		playerInventory.setEditable(false);
		playerInventory.append("Player's Inventory");

		roomInventory.setLineWrap(true);
		roomInventory.setWrapStyleWord(true);
		roomInventory.setEditable(false);
		updateRoomTextArea(p.getRoom().getRoomInventory(), p.getRoom().stringMobList());
		updateMobIcon(p.getRoom());

	}

	/**
	 * updates the text area by appending the string we put in
	 * 
	 * @param x
	 */
	public void updateTextArea(String x) {
		textOutput.append(x);
		
	}
	/**
	 * updates the game icon so that you know you are in the same room as another player
	 */
	public void makeTwoPlayer() throws IOException{
		

		if(aTwoPlayers){
		try{
			BufferedImage scooby = ImageIO.read(new File("Images/funnyScooby.png"));
			shrekPicture.setIcon(new ImageIcon(scooby));
		}catch (IOException e) {
			e.printStackTrace();
		}
		}else{
			try{
				BufferedImage scooby = ImageIO.read(new File("Images/daphnie.jpg"));
				shrekPicture.setIcon(new ImageIcon(scooby));
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	
	/**
	 * makeShrekGIF() makes the shrek picture an ogre of a time
	 */
	public void makeShrekGIF() {
		try {
			URL gif = new URL("https://media.giphy.com/media/MDXomrcGshGso/giphy.gif");
			shrekPicture.setIcon(new ImageIcon(gif));

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * makes greatness
	 */
	public void makeGreatness(){
		try{
			BufferedImage greatness = ImageIO.read(new File("Images/evil.png"));
			shrekPicture.setIcon(new ImageIcon(greatness));
			mobPicture.setIcon(new ImageIcon(greatness));
			roomPicture.setIcon(new ImageIcon(greatness));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * updatePlayerTextArea updates the player Inventory list in the GUI
	 * 
	 * @param x
	 */
	public void updatePlayerTextArea(String x) {

		playerInventory.setText("Player's Inventory \n \n" + x);

	}

	/**
	 * updateRoomTextArea updates the room Inventory list in the GUI
	 * 
	 * @param x
	 */
	public void updateRoomTextArea(String x, String y) {
		roomInventory.setText("");
		roomInventory.setText("Room's Inventory \n \n" + x + "\n \n" + "other mobs \n\n" + y);

	}

	/**
	 * updates the roomIcon by finding the room file p
	 * 
	 * @param r
	 */
	public void updateRoomIcon(Room r) {
		try {
			BufferedImage roomIcon = ImageIO.read(new File(r.getFilepath()));
			roomPicture.setIcon(new ImageIcon(roomIcon));
			roomPicture.setText(player.location());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	/**
	 * updates the general icon
	 */
	public void updateGeneralIcon(){
			try{
				BufferedImage greatness = ImageIO.read(new File("Images/finalPTwo.jpg"));
				shrekPicture.setIcon(new ImageIcon(greatness));
			}catch (IOException e) {
				e.printStackTrace();
			}
		}

	/**
	 * updateMobIcon updates the mob icon in the GUI
	 * 
	 * @param r
	 */
	public void updateMobIcon(Room r) {
		if (r.getRoom().equals("Swamp King's Lair")){
			try{
				BufferedImage greatness = ImageIO.read(new File("Images/finalP1.jpg"));
				mobPicture.setIcon(new ImageIcon(greatness));
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
		else{	
		mobs = r.getMobList();

		if (mobs.size() >= 1) {
			MOB m = mobs.get(0);
			if (mobs.size() > 1) {
				//timer.setInitialDelay(10);
				//timer.start();
				try {

					BufferedImage mobIcon = ImageIO.read(new File("Images/shrekSquad.jpg"));
					mobPicture.setIcon(new ImageIcon(mobIcon));
					mobPicture.setText("the whole squad gettin turnt");

				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {

				try {
					BufferedImage mobIcon = ImageIO.read(new File(m.getMobFilepath()));
					mobPicture.setIcon(new ImageIcon(mobIcon));
					mobPicture.setText(m.getMobName());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			BufferedImage mobIcon;
			try {
				mobIcon = ImageIO.read(new File("Images/mob.jpg"));
				mobPicture.setIcon(new ImageIcon(mobIcon));
				mobPicture.setText("");
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		}
	}

	/**
	 * clears the ui line
	 */
	public void clearUIline() {
		uiLine.setText("");
	}
	/**
	 * clear's text area
	 */
	public void clearTextArea(){
		textOutput.setText("");
	}
	/**
	 * closes the GUI
	 */
	public void close() {
		bigBox.dispose();
	}
	/**
	 * exit for player that closes both GUI's
	 */
	public void exit(){
		obs.terminate();
		close();	
	}
	/**
	 * makes the gui main picture the default picture
	 */
	public void defaultPicture(){
	try {
		BufferedImage shrek = ImageIO.read(new File("Images/shrek.png"));
		shrekPicture.setIcon(new ImageIcon(shrek));
		shrekPicture.setText("Shrek Is Love");
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	/**
	 * updates the entire gui
	 */
	public void update(Observable o, Object arg) {

		// updateMobIcon(player.getRoom()== mob.getRoom());
		updateRoomTextArea(player.getRoom().getRoomInventory(), player.getRoom().stringMobList());
		updatePlayerTextArea(player.getPlayerInventory());
		updateMobIcon(player.getRoom());
		if (player.location().equals("Swamp King's Lair")){
			try{
				BufferedImage greatness = ImageIO.read(new File("Images/finalP1.jpg"));
				mobPicture.setIcon(new ImageIcon(greatness));
			}catch (IOException e) {
				e.printStackTrace();
			}
		}else{	
		if(player.playersInSameRoom()){
			
			try {
				this.makeTwoPlayer();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			this.defaultPicture();
			
		}
		

	}
	}

	//@Override
//	public void actionPerformed(ActionEvent arg0) {
		// change picture in this method
	
	//}
}