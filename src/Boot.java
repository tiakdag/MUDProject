

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.*;


public class Boot implements ActionListener {
	
	private Player player;
	private GameObservable observable = new GameObservable();
	private Player secondPlayer;
	private MOB aShrek;
	private OffensiveMOB aPussInBoots;
	private DefensiveMob aGingy;
	private LockedMOB aScooby;
	private ThiefMOB aScrappy;
	private MOB velma;
	private MOB lord;
	private DefensiveMob sludge;
	private Room room = new Room("Room of sadness"," so lonely","");
	private boolean playerswitch;
	private JFrame aBox = new JFrame();
	private GUI gui;
	private GUI gui2;
	private Room finalcombatArenaP1 = new Room ("Swamp King's Lair", "A room strewn with bodies", "Images/finalP1.jpg");
	private Room finalcombatArenaP3 = new Room("Swamp King's Lair", "A room strewn with bodies", "Images/finalP3.jpg");
	private ArrayList<MOB> mobList = new ArrayList<MOB>();
	/**
	 * Boot creates the objects that are in the game
	 */
	 
	Boot() {
		
		//Observer creation
		GameObservable obs = new GameObservable();
		observable = obs;
		
		//ITEM CREATION
		Item sub = new Item("Johnny Jim's Sub",1,0);
		Item onion = new Item("Onion",0,1);
		Item snack = new Item("Scooby Snack",1,0);
		Item rustySword = new Item("Rusty Foil",3,0);
		Item bagOfBeans = new Item("Bag of beans",0,1);
		Item cue = new Item("pool cue",2,0);
		Item tomato = new Item ("Rotton tomato",0,1);
		Item shirt = new Item ("Koscielny's indestructible kit",0,100);
		Item rubberBall = new Item("rubber ball of FUN",2,0);
		Item balloonFrog = new Item("A balloon....but wait it's a frog",0,5);
		Item cobWebs = new Item("A bouquet of webs",2,0);
		Item car = new Item("machine of mystery",3,3);
		Item hankerchief = new Item("Fred's hankerchief",0,2);
		
		
		//ROOM CREATION
		Room kitchen = new Room("kitchen", "This is a  Kitchen", "Images/kitchenIcon.jpg");
		Room diningRoom = new Room("dining room", "This is a Dining Room", "Images/dinningRoom.jpg");
		Room study = new Room("study", "This is a Study", "Images/study.jpg");
		Room hall = new Room ("hall", "This is a Hallway", "Images/hall.jpg");
		Room basement = new Room ("basement","This is a basement", "Images/basement.jpg");
		Room ballRoom = new Room ("ball room", "This is a ball room","Images/ballRoom.jpg");
		Room gameRoom = new Room ("game room", "This is a game room", "Images/gameRoom.jpg");
		Room garden = new Room ("garden","A tomato garden", "Images/garden.jpg");
		Room soccerField = new Room("soccer pitch","Arsenal stadium", "Images/soccer.jpg");
		Room ballPit = new Room("ball pit","a fun pit of balls","Images/ballPit.jpg");
		Room stairStart = new Room("stairway to heaven","a small staircase","Images/startStair.jpg");
		Room middleStair = new Room("More stairs","deceptively large staircase","Images/middleStair.jpg");
		Room moreStair = new Room("Guess what more stairs","damn more stairs","Images/MORESTAIRS.jpg");	
		Room tallestTower = new Room("SALVATION","WE MADE IT", "Images/tallestTower.png");
		Room secretRoom = new Room("panic room","a panic room","Images/secret.jpg");
		Room attic = new Room("attic","a place of the most dust","Images/attic.jpg");
		Room bedRoom = new Room("bedroom", "a place ment for sleep","Images/bedRoom.jpg");
		Room atrium  = new Room("atrium","a big ole room", "Images/atrium.jpg");
		Room bathRoom = new Room("bathroom", "where weird stuff happens", "Images/bathroom.jpg");
		Room pool = new Room("swimming pool", "swim area YAY", "Images/pool.jpg");
		
		//EXIT CREATION
		
		//Kitchen's Exits
		Exit e1 = new Exit(diningRoom, "Double Door",true,0);
		Exit e2 = new Exit(hall, "Servants Passageway",true,0);
		Exit e9 = new Exit(basement, "Creepy Old Door",false,1);
		//Dinning Room's Exits
		Exit e3 = new Exit(kitchen , "Double Door",true,0);
		Exit e4 = new Exit(study, "Ornate Archway",true,0);
		//Study's Exits
		Exit e5 = new Exit(diningRoom, "Ornate Archway",true,0);
		Exit e6 = new Exit(hall, "Big Ole Door",true,0);
		Exit toPanicRoom = new Exit(secretRoom, "suspicious book", false, 1);
		//Hall's Exits
		Exit e7 = new Exit(study, "Big Ole Door",true,0);
		Exit e8 = new Exit(kitchen, "Servants Passageway",true,0);
		Exit e11 = new Exit(ballRoom, "Decorated Door",true, 0);
		//Basement's Exits
		Exit e10= new Exit(kitchen ,"Creepy Old Door",true,0 );
		Exit toGarden = new Exit(garden,"Splintered Door",true, 0);
		//ballRoom's exits
		Exit e12 = new Exit(hall, "Decorated Door", true, 0);
		Exit e13 = new Exit(gameRoom, "Revolving Door",true,0);
		Exit startStairs = new Exit(stairStart,"Stairway to heaven",true,0);
		//GameRoom's exits
		Exit e14 = new Exit(ballRoom, "Revolving Door",true,0);
		Exit toBallPit = new Exit(ballPit, "Door of the most fun",false,2);
		Exit gameToPool = new Exit(pool, "conner 204",true,0);
		
		//Garden's exits
		Exit gardenExit1 = new Exit(basement,"Splintered Door",true,0);
		Exit toStadium = new Exit(soccerField, "Sparkely Amazing Door",false,4);
		//Arsenal stadium exits
		Exit stadiumExit1 = new Exit(garden, "Sparkely Amazing Door",true,0);
		
		//ball pit's exits
		Exit ballPitExit = new Exit(gameRoom,"Door of the most fun",true,0);
		
		// stairs exits locks the stairs till you get a mob
		Exit stairsToBallRoom = new Exit(ballRoom,"Stairway to heaven",true,0);
		Exit toMoreStairs = new Exit(middleStair,"Door to more stairs",true,0);
		
		//middle stairs
		Exit backToStart = new Exit(stairStart,"Door to more stairs",true,0);
		Exit toTheMostStairs = new Exit(moreStair,"more more stairs",true,0);
		//more stairs
		Exit toMiddle = new Exit(middleStair,"more more stairs",true,0);
		Exit toTower = new Exit(tallestTower,"SALVATION",true,0);
		
		// tower exits
		Exit backToStairs = new Exit(moreStair,"SALVATION",true,0);
		Exit toBathRoom = new Exit(bathRoom,"jeffery 301",true,0);
		
		//Secretroom's exits
		Exit toStudy = new Exit(study,"suspicious book", true, 0);
		Exit toAttic = new Exit(attic,"rickety door",false, 2);
		Exit toBedRoom = new Exit(bedRoom,"strange cabinet",true,0);
		
		//attic's exits
		Exit fromAtticToSecret = new Exit(secretRoom,"rickety door",true,0);
		
		//bed room's exits
		Exit bedToSecret = new Exit(secretRoom,"strange cabinet",true, 0);
		Exit bedToAtrium = new Exit(atrium, "door of wonderment",true,0);
		
		//Atrium's exits
		Exit atriumToBed = new Exit(bedRoom,"door of wonderment",true,0);
		Exit atriumToBath = new Exit(bathRoom,"glass door",true,0);
		Exit atriumToPool = new Exit(pool,"wooden gate", true,0);
		
		//bathRoom's exits
		Exit bathToAtrium = new Exit(atrium,"glass door",true,0);
		Exit bathToPool = new Exit(pool, "gamble apartment door", true,0);
		Exit bathToTall = new Exit(tallestTower,"jeffery 301", true,0);
		
		//pool's exits
		Exit poolToAtrium = new Exit(atrium, "wooden gate", true,0);
		Exit poolToBath = new Exit(bathRoom ,"gamble apartment door", true,0);
		Exit poolToGame = new Exit(gameRoom,"conner 204",true,0);
		
		
		// filling rooms 
		kitchen.addExit(e1);
		kitchen.addExit(e2);
		kitchen.addExit(e9);
		kitchen.addItem(snack);
		
		diningRoom.addExit(e3);
		diningRoom.addExit(e4);
		diningRoom.addItem(onion);
		
		study.addExit(e5);
		study.addExit(e6);
		study.addExit(toPanicRoom);
		study.addItem(sub);
		
		hall.addExit(e7);
		hall.addExit(e8);
		hall.addExit(e11);
		
		
		basement.addItem(bagOfBeans);
		basement.addItem(rustySword);
		basement.addExit(e10);
		basement.addExit(toGarden);
		
		ballRoom.addExit(e12);
		ballRoom.addExit(e13);
		ballRoom.addExit(startStairs);
		
		gameRoom.addExit(e14);
		gameRoom.addExit(toBallPit);
		gameRoom.addExit(gameToPool);
		gameRoom.addItem(cue);
		
		garden.addExit(gardenExit1);
		garden.addExit(toStadium);
		garden.addItem(tomato);
		
		soccerField.addItem(shirt);
		soccerField.addExit(stadiumExit1);
		
		ballPit.addExit(ballPitExit);
		ballPit.addItem(rubberBall);
		
		stairStart.addExit(stairsToBallRoom);
		stairStart.addExit(toMoreStairs);
		
		middleStair.addExit(backToStart);
		middleStair.addExit(toTheMostStairs);
		
		moreStair.addExit(toMiddle);
		moreStair.addExit(toTower);
		
		tallestTower.addExit(backToStairs);
		tallestTower.addExit(toBathRoom);
		
		secretRoom.addExit(toStudy);
		secretRoom.addExit(toAttic);
		secretRoom.addExit(toBedRoom);
		secretRoom.addItem(balloonFrog);
		
		attic.addExit(fromAtticToSecret);
		attic.addItem(cobWebs);
		
		bedRoom.addExit(bedToSecret);
		bedRoom.addExit(bedToAtrium);
		
		atrium.addExit(atriumToBed);
		atrium.addExit(atriumToBath);
		atrium.addExit(atriumToPool);
		atrium.addItem(car);
		
		bathRoom.addExit(bathToAtrium);
		bathRoom.addExit(bathToPool);
		bathRoom.addExit(bathToTall);
		bathRoom.addItem(hankerchief);
		
		
		pool.addExit(poolToBath);
		pool.addExit(poolToGame);
		pool.addExit(poolToAtrium);
		// create player
		ReentrantLock lock = new ReentrantLock();
		
		Player player1 = new Player(lock,this,observable);
		player = player1;
		
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
		
		
		Player player2 = new Player(lock,this,observable);
		secondPlayer = player2;
		int p2StartLoc = (int)((double)Math.random()*10)%3;
		if (p2StartLoc == 1 ){
			secondPlayer.setLocation(atrium);
		}else {
			secondPlayer.setLocation(ballRoom);
		}
		
		
	
		//Create MOBS
		 MOB shrek = new MOB("Shrek", "neutral", "Images/danielShrek.png",observable,20,kitchen,lock,1,1);
		 aShrek = shrek;
		 OffensiveMOB pussInBoots = new OffensiveMOB("Puss In Boots", "offensive", "Images/PussinBoots.jpg",observable,20,diningRoom,lock,10,0);
		 aPussInBoots = pussInBoots;
		 DefensiveMob gingy = new DefensiveMob("Gingy","defensive","Images/gingyPicture.jpg",observable,20,hall,lock,0,10);
		 aGingy = gingy;
		 LockedMOB scooby = new LockedMOB("Scooby","locked","Images/scooby.jpg",observable,20,study,lock, false, 2,5,5);
		 aScooby = scooby;
		ThiefMOB scrappy = new ThiefMOB("Scrappy","thief","Images/scrappy.jpg",obs,20,study,lock,1,1);
		 aScrappy = scrappy;
		 MOB aVelma = new MOB("Velma","neutral","Images/velma.png",observable,20,bathRoom,lock,1,1);
		 velma = aVelma;
		 MOB aLord = new MOB("Lord Farquaad","neutral","Images/lord.jpeg",observable, 20,atrium,lock,1,1);
		 lord = aLord;
		 DefensiveMob aSludge = new DefensiveMob("Sludge Monster","defensive","Images/tar.jpg",observable,20,ballPit,lock,0,10);
		sludge = aSludge;
		
		 //MOB Array
		
		mobList.add(shrek);
		mobList.add(pussInBoots);
		mobList.add(gingy);
		mobList.add(scooby);
		mobList.add(scrappy);
		mobList.add(aSludge);
		mobList.add(aVelma);
		mobList.add(aLord);
		
		
	//Add Observers
		obs.addObserver(player1);
		obs.addObserver(player2);
		obs.addObserver(shrek);
		obs.addObserver(pussInBoots);
		obs.addObserver(gingy);
		obs.addObserver(scooby);
		obs.addObserver(scrappy);
		 obs.addObserver(aSludge);
		 obs.addObserver(aVelma);
		 obs.addObserver(aLord);
		
		
		 
		JPanel panel = new JPanel();
		
		JButton button = new JButton();
		JButton secondButton = new JButton();
		button = new JButton("One");
		secondButton = new JButton("Two");
		aBox.setBounds(0,0,150,150);
		panel.add(button);
		panel.add(secondButton);
		aBox.add(panel);
		panel.setVisible(true);
		aBox.setVisible(true);
		button.addActionListener(this);
		secondButton.addActionListener(this);
		aBox.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	/**
	 * listens for those buttons to be pressed with a gental care
	 */
	public void actionPerformed(ActionEvent arg0) {
		String bossMan = arg0.getActionCommand();
		if(bossMan.equals("One")){
			playerswitch = true;
		}else {
			playerswitch = false;
		}
		aBox.dispose();
		start();
	}
	/**
	 * initiallize the game for one or two players
	 */
	private void start(){
		if(playerswitch){
			aShrek.start();
			aPussInBoots.start();
			aGingy.start();
			aScooby.start();
			aScrappy.start();
			velma.start();
			lord.start();
			sludge.start();
			secondPlayer.setLocation(room);
			gui = new GUI(player,observable,false);
		}else {
			aShrek.start();
			aPussInBoots.start();
			aGingy.start();
			aScooby.start();
			aScrappy.start(); 
			velma.start();
			lord.start();
			sludge.start();
			
			
			gui = new GUI(player,observable,false);
			gui2 = new GUI(secondPlayer,observable,true);
		}
	}
	/**
	 * exit both GUI's
	 */
	public void exitAll(){
		if(!playerswitch){
			gui.exit();
			gui2.exit();
		}
	}
	/**
	 * checks to see if players are in the same location
	 * @return
	 */
	public boolean sameLocation(){
		if(player.location()==secondPlayer.location()){
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * see's if the mobs still have that sweet American freedom
	 * @return
	 */
	public boolean activeMobs(){
		for(int i = 0 ; i < mobList.size();i++){
			if(mobList.get(i).stillRunning == false){//find boolean that work
					mobList.remove(i);	
					}
			
		}
		if(!mobList.isEmpty()){
			return true;
		}else return false;
	}
	/**
	 * single player last resort
	 */
	public void onePlayerFinalBattleLastResort(){
		observable.terminate();
		player.setLocation(finalcombatArenaP1);
		observable.alertObservers();
		gui.clearTextArea();
		gui.updateTextArea("\nThis is the final showdown against tom \n");
		gui.updateGeneralIcon();
		gui.updateRoomIcon(finalcombatArenaP3);
		gui.updateMobIcon(finalcombatArenaP1);
		
		
		if(player.getTotalCombatScore()> 60){
			gui.updateTextArea("\nCongradulations, you have become king of Tom's swamp");
			gui.updateMobIcon(finalcombatArenaP1);
		}else{
			gui.updateTextArea("\nOh no Tom has defeated you with his arsenal of knowledge");
			gui.updateMobIcon(finalcombatArenaP1);
		}
	}
	/**
	 * sets the one person final battle
	 */
	public void onePlayerFinalBattle(){
		if(activeMobs()==false){
		
		player.setLocation(finalcombatArenaP1);
		gui.clearTextArea();
		gui.updateMobIcon(finalcombatArenaP1);
		gui.updateGeneralIcon();
		gui.updateRoomIcon(finalcombatArenaP3);
		gui.updateTextArea("\nThis is the final showdown against tom \n");
		observable.terminate();
		if(player.getTotalCombatScore()> 60){
			gui.updateTextArea("\nCongradulations, you have become king of Tom's swamp");
		}else{
			gui.updateTextArea("\nOh no Tom has defeated you with his arsenal of knowledge");
		}
		}
	}
	/**
	 * sets the two person final battle
	 */
	public void twoPlayerFinalBattle(){
		if(activeMobs()==false){
		observable.terminate();
		player.setLocation(finalcombatArenaP1);
		secondPlayer.setLocation(finalcombatArenaP1);
		observable.terminate();
		gui.clearTextArea();
		gui2.clearTextArea();
		gui.updateMobIcon(finalcombatArenaP1);
		gui.updateGeneralIcon();
		gui.updateRoomIcon(finalcombatArenaP3);
		gui2.updateMobIcon(finalcombatArenaP1);
		gui2.updateGeneralIcon();
		gui2.updateRoomIcon(finalcombatArenaP3);
		if(player.getTotalCombatScore()>secondPlayer.getTotalCombatScore()){
			gui.updateTextArea("\nCongradulations, you have become king of Tom's swamp");
			gui2.updateTextArea("\nOh no, you have lost, the power of Tom's swamp is not yours");
		}else if (player.getTotalCombatScore()<secondPlayer.getTotalCombatScore()){
			
			gui.updateTextArea("\nOh no, you have lost, the power of Tom's swamp is not yours");
			gui2.updateTextArea("\nCongradulations, you have become king of Tom's swamp");
		}else {
			gui.updateTextArea("\nSomehow you knuckleheads have tied, how I have no idea");
			gui2.updateTextArea("\nSomehow you knuckleheads have tied, how I have no idea");
		}
	}
	}
	/**
	 * two player last resort
	 */
	public void twoPlayerFinalBattleLastResort(){
		player.setLocation(finalcombatArenaP1);
		secondPlayer.setLocation(finalcombatArenaP1);
		observable.terminate();
		gui.clearTextArea();
		gui2.clearTextArea();
		gui.updateMobIcon(finalcombatArenaP1);
		gui.updateGeneralIcon();
		gui.updateRoomIcon(finalcombatArenaP3);
		gui2.updateMobIcon(finalcombatArenaP1);
		gui2.updateGeneralIcon();
		gui2.updateRoomIcon(finalcombatArenaP3);
		if(player.getTotalCombatScore()>secondPlayer.getTotalCombatScore()){
			gui.updateTextArea("\nCongradulations, you have become king of Tom's swamp");
			gui2.updateTextArea("\nOh no, you have lost, the power of Tom's swamp is not yours");
		}else if (player.getTotalCombatScore()<secondPlayer.getTotalCombatScore()){
			
			gui.updateTextArea("\nOh no, you have lost, the power of Tom's swamp is not yours");
			gui2.updateTextArea("\nCongradulations, you have become king of Tom's swamp");
		}else {
			gui.updateTextArea("\nSomehow you knuckleheads have tied, how I have no idea");
			gui2.updateTextArea("\nSomehow you knuckleheads have tied, how I have no idea");
		}
	
	}
	/**
	 * final battle decides what final battle there is
	 */
	public void finalBattle(){
		if(playerswitch == false){
			twoPlayerFinalBattle();
		}else{
			onePlayerFinalBattle();
		}
	}
}
