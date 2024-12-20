import java.util.*;
class Exorcist{
	static Scanner scanner=new Scanner(System.in);
	static String ANSI_RED="\u001B[31m";
	static String ANSI_GREEN="\u001B[32m";
	static String ANSI_BLUE="\u001B[34m";
	static String ANSI_CYAN="\u001B[36m";
	static String ANSI_WHITE="\u001B[37m";
	static String weapon="Knife";
	static int potions=0;
	static boolean firstTime=true;
	static boolean foundPotion1=false;
	static boolean foundPotion2=false;
	static boolean foundPotionsStorageRoom=false;
	static boolean foundPotion5=false;
	static boolean foundADemon=false;
	static boolean killedDemon1=false;
	static boolean killedDemon2=false;
	static boolean killedDemon3=false;
	static boolean killedDemon4=false;
	static boolean killedDemon5=false;
	static String changed1="unfound";
	static String changed2="unfound";
	static String changed3="unfound";
	static String changed4="unfound";
	static String changed5="unfound";
	static String human1="unfound";
	static String human2="unfound";
	static String human3="unfound";
	static String human4="unfound";
	static String human5="unfound";
	static boolean killedBoss=false;
	static String choice;
	//Main Method
	public static void main(String[] args){
		System.out.print("\033[H\033[2J");  
		System.out.flush();
		startingRoom();
	}
	//General Methods
	public static void clearScreen(){
		System.out.println(ANSI_RED+"[ENTER]"+ANSI_WHITE);
		scanner.nextLine();
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	public static void displayInventory(){
		System.out.println(ANSI_BLUE+"Your Inventory");
		System.out.println(ANSI_WHITE+weapon);
		System.out.println("Exorcist Potions: "+potions);
	}
	public static void fight(){
		if(weapon.equals("Shotgun")){
			System.out.println(ANSI_GREEN+"You shoot them, they die."+ANSI_WHITE);
		}else{
			Random rand=new Random();
			boolean randomBool=rand.nextBoolean();
			if(randomBool){
				System.out.println(ANSI_GREEN+"You stab them, they die."+ANSI_WHITE);
			}else{
				System.out.println(ANSI_RED+"Your puny knife was no match, and they killed you.");
				deathScreen();
			}
		}
	}
	public static void deathScreen(){
		clearScreen();
		System.out.print(ANSI_RED);
		String mes="""
				Game Over!
				Better luck next time, valiant player.""";
		for(int i=0; i<mes.length(); i++){
			System.out.print(mes.charAt(i));
			try{
				Thread.sleep(75);
			}catch(InterruptedException e){
			}
		}
		System.out.println();
		displayStats();
		System.out.println(ANSI_WHITE);
		System.exit(0);
	}
	public static void invalidOption(){
		System.out.println(ANSI_RED+"""
				Your brain is confused by the invalid option.
				You die of confusion.""");
		deathScreen();
	}
	public static void displayStats(){
		int score=0;
		int demonsKilled=0;
		int humansSaved=0;
		int changedKilled=0;
		int changedSaved=0;
		int bossesKilled=0;
		if(killedBoss){
			score+=20;
			bossesKilled+=1;
		}
		if(killedDemon1){
			demonsKilled+=1;
		}
		if(killedDemon2){
			demonsKilled+=1;
		}
		if(killedDemon3){
			demonsKilled+=1;
		}
		if(killedDemon4){
			demonsKilled+=1;
		}
		if(killedDemon5){
			demonsKilled+=1;
		}
		if(human1.equals("saved")){
			humansSaved+=1;
		}
		if(human2.equals("saved")){
			humansSaved+=1;
		}
		if(human3.equals("saved")){
			humansSaved+=1;
		}
		if(human4.equals("saved")){
			humansSaved+=1;
		}
		if(human5.equals("saved")){
			humansSaved+=1;
		}
		if(changed1.equals("saved")){
			changedSaved+=1;
		}else if(changed1.equals("dead")){
			changedKilled+=1;
		}
		if(changed2.equals("saved")){
			changedSaved+=1;
		}else if(changed2.equals("dead")){
			changedKilled+=1;
		}
		if(changed3.equals("saved")){
			changedSaved+=1;
		}else if(changed3.equals("dead")){
			changedKilled+=1;
		}
		if(changed4.equals("saved")){
			changedSaved+=1;
		}else if(changed4.equals("dead")){
			changedKilled+=1;
		}
		if(changed5.equals("saved")){
			changedSaved+=1;
		}else if(changed5.equals("dead")){
			changedKilled+=1;
		}
		score+=(humansSaved*2)+(changedSaved*2)+changedKilled+(demonsKilled*2);
		int scorePercentage=score*2;
		String mes="""
				Your Stats
				Humans Saved -"""+" "+humansSaved
				+"\n+"+humansSaved*2
				+"\nChanged Humans Saved - "+changedSaved
				+"\n+"+changedSaved*2
				+"\nChanged Humans Killed - "+changedKilled
				+"\n+"+changedKilled
				+"\nDemons Killed - "+demonsKilled
				+"\n+"+demonsKilled*2
				+"\nBosses Killed - "+bossesKilled
				+"\n+"+bossesKilled*20
				+"\nPoints - "+score+"/50";
		for(int i=0; i<mes.length(); i++){
			System.out.print(mes.charAt(i));
			try{
				Thread.sleep(75);
			}catch(InterruptedException e){
			}
		}
		System.out.println();
		int num=0;
		System.out.print("Score: ");
		while(scorePercentage>=num){
			System.out.print(num);
			System.out.print("%");
			System.out.print("\b\b");
			if(num>=10){
				System.out.print("\b");
			}
			num+=1;
			try{
				Thread.sleep(75);
			}catch(InterruptedException e){
			}
		}
	}
	//Room Methods
	public static void startingRoom(){
		if(firstTime){
			System.out.println(ANSI_CYAN+"""
					You wake up in a strange place...
					It's a small, dim room.
					You have a knife in your hand...""");
			clearScreen();
		}else{
			System.out.println(ANSI_CYAN+"You enter the room you started in."+ANSI_WHITE);
		}
		if(!foundPotion1){
			System.out.println(ANSI_CYAN+"You see a potion. What do you do?"+ANSI_WHITE);
			System.out.println("""
					[1] Pick up the potion
					[2] Ignore the potion""");
			choice=scanner.nextLine();
			if(choice.equals("1")){
				foundPotion1=true;
				System.out.println(ANSI_CYAN+"You pick up the potion."+ANSI_WHITE);
				potions+=1;
				displayInventory();
			}else{
				System.out.println(ANSI_CYAN+"You do not pick up the potion."+ANSI_WHITE);
			}
			clearScreen();
		}
		if(changed1.equals("unfound")){
			System.out.println(ANSI_CYAN+"""
					A creature comes toward you...
					It looks human... almost...
					Yet somehow different, twisted...
					It's getting closer, preparing to attack you.
					What do you do?"""+ANSI_WHITE);
			System.out.println("[1] Attack it");
			if(potions>0){
				System.out.println("[2] Throw potion at it");
			}
			choice=scanner.nextLine();
			if(choice.equals("1")){
				fight();
				changed1="dead";
			}else if(choice.equals("2") && potions>0){
				System.out.println(ANSI_CYAN+"Your potion heals the creature, who turns out to be a possessed human."+ANSI_WHITE);
				changed1="saved";
				potions-=1;
			}else{
				invalidOption();
			}
			displayInventory();
			clearScreen();
		}
		if(!firstTime){
			clearScreen();
		}
		firstTime=false;
		hallway1();
	}
	public static void hallway1(){
		System.out.println(ANSI_CYAN+"You enter a hallway."+ANSI_WHITE);
		if(!foundPotion2){
			System.out.println(ANSI_CYAN+"You see a potion. What do you do?"+ANSI_WHITE);
			System.out.println("""
					[1] Pick up the potion
					[2] Ignore the potion""");
			choice=scanner.nextLine();
			if(choice.equals("1")){
				foundPotion2=true;
				System.out.println(ANSI_CYAN+"You pick up the potion."+ANSI_WHITE);
				potions+=1;
				displayInventory();
			}else{
				System.out.println(ANSI_CYAN+"You do not pick up the potion."+ANSI_WHITE);
			}
			clearScreen();
		}
		System.out.println(ANSI_CYAN+"""
				The hallway has three doors, all labelled,
				except the room you started in.
				Which do you choose?"""+ANSI_WHITE);
		System.out.println("""
				[1] Starting Room
				[2] Storage Room
				[3] Lab""");
		choice=scanner.nextLine();
		clearScreen();
		if(choice.equals("1")){
			startingRoom();
		}else if(choice.equals("2")){
			storage();
		}else if(choice.equals("3")){
			lab();
		}else{
			invalidOption();
		}
	}
	public static void storage(){
		System.out.println(ANSI_CYAN+"You enter the Storage Room."+ANSI_WHITE);
		if(!foundPotionsStorageRoom){
			System.out.println(ANSI_CYAN+"You see two potions. What do you do?"+ANSI_WHITE);
			System.out.println("""
					[1] Pick up the potions
					[2] Ignore the potions""");
			choice=scanner.nextLine();
			if(choice.equals("1")){
				foundPotionsStorageRoom=true;
				System.out.println(ANSI_CYAN+"You pick up the potions."+ANSI_WHITE);
				potions+=2;
				displayInventory();
			}else{
				System.out.println(ANSI_CYAN+"You do not pick up the potions."+ANSI_WHITE);
			}
			clearScreen();
		}
		if(changed2.equals("unfound")){
			System.out.println(ANSI_CYAN+"""
					Another of the changed humans comes toward you.
					What do you do?"""+ANSI_WHITE);
			System.out.println("[1] Attack it");
			if(potions>0){
				System.out.println("[2] Throw potion at it");
			}
			choice=scanner.nextLine();
			if(choice.equals("1")){
				fight();
				changed2="dead";
				System.out.println(ANSI_CYAN+"You saved two humans, who were hiding from their friend, the changed human."+ANSI_WHITE);
				human1="saved";
				human2="saved";
			}else if(choice.equals("2") && potions>0){
				System.out.println(ANSI_CYAN+"Your potion heals the changed human"+ANSI_WHITE);
				changed2="saved";
				System.out.println(ANSI_CYAN+"You also saved two humans, who were hiding from their friend, the changed human."+ANSI_WHITE);
				potions-=1;
				human1="saved";
				human2="saved";
			}else{
				invalidOption();
			}
			displayInventory();
			clearScreen();
		}
		System.out.println(ANSI_CYAN+"""
				There are two ways out of the Storage Room.
				Which do you take?"""+ANSI_WHITE);
		System.out.println("""
				[1] Hallway
				[2] Armory""");
		choice=scanner.nextLine();clearScreen();
		if(choice.equals("1")){
			hallway1();
		}else if(choice.equals("2")){
			armory();
		}else{
			invalidOption();
		}
	}
	public static void lab(){
		System.out.println(ANSI_CYAN+"You enter the Lab.");
		if(!killedDemon1){
			if(!foundADemon){
				foundADemon=true;
				System.out.println(ANSI_CYAN+"""
					A creature comes toward you...
					But it isn't like the changed humans.
					It's 7 feet tall, with bloodred skin
					and long, curled horns top its ugly head.
					It leaps out to attack you!"""+ANSI_WHITE);
			}else{
				System.out.println(ANSI_CYAN+"A demon leaps out to attack you!");
			}
			System.out.println("""
					There are three potions nearby.
					You could grab one, or use your weapon.
					What do you do?"""+ANSI_WHITE);
			System.out.println("""
					[1] Attack it
					[2] Use the red potion
					[3] Use the green potion
					[4] Use the blue potion""");
			choice=scanner.nextLine();
			if(choice.equals("1")){
				fight();
				System.out.println(ANSI_CYAN+"The two humans fighting the demon are saved."+ANSI_WHITE);
				human3="saved";
				human4="saved";
			}else if(choice.equals("2")){
				System.out.println(ANSI_RED+"The red potion explodes, and you die.");
				deathScreen();
			}else if(choice.equals("3")){
				System.out.println(ANSI_CYAN+"""
						The green potion was a magical potion, killing the demon,
						but leaving you and the two humans fighting the demon unharmed."""+ANSI_WHITE);
				human3="saved";
				human4="saved";
			}else if(choice.equals("4")){
				System.out.println(ANSI_CYAN+"""
						The blue potion explodes, filling the room with smoke.
						Of the two people trying to fight the demon that attacked you,
						only one survived."""+ANSI_WHITE);
				human3="saved";
				human4="dead";
			}else{
				invalidOption();
			}
			clearScreen();
			killedDemon1=true;
		}
		if(!foundPotion5){
			System.out.println(ANSI_CYAN+"You see a potion. What do you do?"+ANSI_WHITE);
			System.out.println("""
					[1] Pick up the potion
					[2] Ignore the potion""");
			choice=scanner.nextLine();
			if(choice.equals("1")){
				foundPotion5=true;
				System.out.println(ANSI_CYAN+"You pick up the potion."+ANSI_WHITE);
				potions+=1;
				displayInventory();
			}else{
				System.out.println(ANSI_CYAN+"You do not pick up the potion."+ANSI_WHITE);
			}
			clearScreen();
		}
		System.out.println(ANSI_CYAN+"""
				There a two ways out of the Lab.
				Which do you take?"""+ANSI_WHITE);
		System.out.println("""
				[1] Hallway
				[2] Computer Room""");
		choice=scanner.nextLine();
		clearScreen();
		if(choice.equals("1")){
			hallway1();
		}else if(choice.equals("2")){
			computer();
		}else{
			invalidOption();
		}
	}
	public static void armory(){
		System.out.println(ANSI_CYAN+"You enter the armory."+ANSI_WHITE);
		if(weapon.equals("Knife")){
			System.out.println(ANSI_CYAN+"You find a shotgun. Do you take it?"+ANSI_WHITE);
			System.out.println("""
					[1] Yes
					[2] No""");
			choice=scanner.nextLine();
			if(choice.equals("1")){
				System.out.println(ANSI_CYAN+"You take the shotgun. You no longer need your knife."+ANSI_WHITE);
				weapon="Shotgun";
			}else{
				System.out.println(ANSI_CYAN+"You do not take the shotgun."+ANSI_WHITE);
			}
			displayInventory();
			clearScreen();
		}
		if(!killedDemon2){
			if(!foundADemon){
				foundADemon=true;
				System.out.println(ANSI_CYAN+"""
						A creature comes toward you...
						But it isn't like the changed humans.
						It's 7 feet tall, with bloodred skin
						and long, curled horns top its ugly head.
						It leaps out to attack you!"""+ANSI_WHITE);
			}else{
				System.out.println(ANSI_CYAN+"A demon attacks you!");
			}
			System.out.println("What would you like to do?"+ANSI_WHITE);
			System.out.println("""
					[1] Attack it
					[2] Offer it a chocolate bar""");
			choice=scanner.nextLine();
			if(choice.equals("1")){
				fight();
			}else if(choice.equals("2")){
				System.out.println(ANSI_RED+"""
						That totally would have worked,
						but you don't have a chocolate bar.
						They kill you.""");
						deathScreen();
			}else{
				invalidOption();
			}
			clearScreen();
			killedDemon2=true;
		}
		System.out.println(ANSI_CYAN+"""
				There are two ways out of the Armory.
				Which do you take?"""+ANSI_WHITE);
		System.out.println("""
				[1] Hallway
				[2] Storage Room""");
		choice=scanner.nextLine();
		clearScreen();
		if(choice.equals("1")){
			hallway2();
		}else if(choice.equals("2")){
			storage();
		}else{
			invalidOption();
		}
	}
	public static void computer(){
		System.out.println(ANSI_CYAN+"You enter the Computer Room."+ANSI_WHITE);
		if(!killedDemon3){
			System.out.println(ANSI_CYAN+"""
					A demon springs from behind a row of computers to attack you!
					What would you like to do?"""+ANSI_WHITE);
			System.out.println("""
					[1] Attack it
					[2] Offer it a back massage""");
			choice=scanner.nextLine();
			if(choice.equals("1")){
				fight();
			}else if(choice.equals("2")){
				System.out.println(ANSI_RED+"""
						Sadly, you don't know how
						to do back massages.
						They kill you.""");
						deathScreen();
			}else{
				invalidOption();
			}
			clearScreen();
			killedDemon3=true;
		}
		System.out.println(ANSI_CYAN+"""
				There are two ways out of the Computer Room.
				Which do you take?"""+ANSI_WHITE);
		System.out.println("""
				[1] Hallway
				[2] Lab""");
		choice=scanner.nextLine();
		clearScreen();
		if(choice.equals("1")){
			hallway2();
		}else if(choice.equals("2")){
			lab();
		}else{
			invalidOption();
		}
	}
	public static void hallway2(){
		System.out.println(ANSI_CYAN+"You enter a pitch-black hallway."+ANSI_WHITE);
		if(changed3.equals("unfound")){
			System.out.println(ANSI_CYAN+"""
					You hear a changed human in the dark.
					What do you do?"""+ANSI_WHITE);
			System.out.println("[1] Attack it");
			if(potions>0){
				System.out.println("[2] Throw potion at it");
			}
			choice=scanner.nextLine();
			if(choice.equals("1")){
				fight();
				changed3="dead";
			}else if(choice.equals("2") && potions>0){
				potions-=1;
				System.out.println(ANSI_CYAN+"""
						You can't see it, so you will have
						to guess which side of the hall it's on.
						Which side do you throw the potion too?"""+ANSI_WHITE);
				System.out.println("""
						[1] Left
						[2] Right""");
				choice=scanner.nextLine();
				if(choice.equals("1")){
					System.out.println(ANSI_CYAN+"You hit the changed, who reverts back to a human."+ANSI_WHITE);
					changed3="saved";
				}else if(choice.equals("2")){
					System.out.println(ANSI_CYAN+"You missed. You now have two options."+ANSI_WHITE);
					System.out.println(ANSI_CYAN+"Which do you choose."+ANSI_WHITE);
					System.out.println("""
							[1] Attack it
							[2] Hide""");
					choice=scanner.nextLine();
					if(choice.equals("1")){
						fight();
						changed3="dead";
					}else if(choice.equals("2")){
						System.out.println(ANSI_RED+"The changed finds and kills you");
					}else{
						invalidOption();
					}
				}else{
					invalidOption();
				}
			}else{
				invalidOption();
			}
			displayInventory();
			clearScreen();
		}
		System.out.println(ANSI_CYAN+"""
				The hallway has three exits that
				you find searching in the dark.
				Which do you take?"""+ANSI_WHITE);
		System.out.println("""
				[1] Computer Room
				[2] Armory""");
		if(weapon.equals("Shotgun")){
			System.out.println("[3] Unmarked Door");
		}else{
			System.out.println("You need a Shotgun to break the lock on the third door");
		}
		choice=scanner.nextLine();
		clearScreen();
		if(choice.equals("1")){
			computer();
		}else if(choice.equals("2")){
			armory();
		}else if(choice.equals("3") && weapon.equals("Shotgun")){
			darkRoom();
		}else{
			invalidOption();
		}
	}
	public static void darkRoom(){
		System.out.println(ANSI_CYAN+"""
				You enter a dark room.
				Long shadows loom throughout the dark space."""+ANSI_WHITE);
		if(changed4.equals("unfound")){
			System.out.println(ANSI_CYAN+"""
					In the darkness, you see three figures.
					One is by itself, while the other two are
					near each other. Based on the sounds, you
					can tell one is a human and two are changed
					humans, but you can't tell who is where.
					What do you do?"""+ANSI_WHITE);
			System.out.println("""
					[1] Shoot the lone figure
					[2] Shoot the group of two""");
			if(potions>0){
				System.out.println("""
					[3] Throw a potion at the lone figure
					[4] Throw a potion at the group""");
			}
			choice=scanner.nextLine();
			clearScreen();
			if(choice.equals("1")){
				System.out.println(ANSI_GREEN+"You shoot the lone figure, who dies.");
				System.out.println(ANSI_CYAN+"""
					As they die, you realize they were a changed human.
					The other changed human kills the normal one.""");
				changed4="dead";
				human5="dead";
				System.out.println("What do you do in regards to the other changed?"+ANSI_WHITE);
				System.out.println("""
						[1] Shoot them
						[2] Throw a potion at them""");
				choice=scanner.nextLine();
				if(choice.equals("1")){
					fight();
					changed5="dead";
				}else if(choice.equals("2")){
					System.out.println(ANSI_CYAN+"You saved them."+ANSI_WHITE);
					changed5="saved";
				}else{
					invalidOption();
				}
			}else if(choice.equals("2")){
				System.out.println(ANSI_GREEN+"You shoot and kill them both.");
				System.out.println(ANSI_CYAN+"You realise one was a human and one was a changed.");
				changed5="dead";
				human5="dead";
				System.out.println("What do you do in regards to the other changed?"+ANSI_WHITE);
				System.out.println("""
						[1] Shoot them
						[2] Throw a potion at them""");
				choice=scanner.nextLine();
				if(choice.equals("1")){
					fight();
					changed4="dead";
				}else if(choice.equals("2")){
					System.out.println(ANSI_CYAN+"You saved them."+ANSI_WHITE);
					changed4="saved";
				}else{
					invalidOption();
				}
			}else if(choice.equals("3") && potions>0){
				potions-=1;
				System.out.println(ANSI_CYAN+"""
					You hit the lone figure, who turns out to be a changed human,
					with a potion, and they are healed. In the group of two figures,
					the other changed kills the human."""+ANSI_WHITE);
				changed4="saved";
				human5="dead";
				System.out.println("What do you do in regards to the other changed?"+ANSI_WHITE);
				System.out.println("""
						[1] Shoot them
						[2] Throw a potion at them""");
				choice=scanner.nextLine();
				if(choice.equals("1")){
					System.out.println(ANSI_GREEN+"You shoot them, they die."+ANSI_WHITE);
					changed5="dead";
				}else if(choice.equals("2")){
					System.out.println(ANSI_CYAN+"You saved them."+ANSI_WHITE);
					changed5="saved";
				}else{
					invalidOption();
				}
			}else if(choice.equals("4") && potions>0){
				potions-=1;
				System.out.println(ANSI_CYAN+"""
					You hit the group, which turns out to be a changed human and
					a normal human. Both are now saved. The lone figure, the other
					changed human, advances towards you."""+ANSI_WHITE);
				changed5="saved";
				human5="saved";
				System.out.println("What do you do in regards to the other changed?"+ANSI_WHITE);
				System.out.println("""
						[1] Shoot them
						[2] Throw a potion at them""");
				choice=scanner.nextLine();
				if(choice.equals("1")){
					System.out.println(ANSI_GREEN+"You shoot them, they die."+ANSI_WHITE);
					changed4="dead";
				}else if(choice.equals("2")){
					System.out.println(ANSI_CYAN+"You saved them."+ANSI_WHITE);
					changed4="saved";
				}else{
					invalidOption();
				}
			}else{
				invalidOption();
			}
		}
		clearScreen();
		System.out.println(ANSI_CYAN+"""
				There are two ways out of this room.
				One is the hallway you entered from,
				the other is a the door to a mysterious
				room whose label is scratched and
				broken beyond recognition.
				Which do you take?"""+ANSI_WHITE);
		System.out.println("""
				[1] Hallway
				[2] Mysterious Room""");
		choice=scanner.nextLine();
		clearScreen();
		if(choice.equals("1")){
			hallway2();
		}else if(choice.equals("2")){
			bossRoom();
		}else{
			invalidOption();
		}
	}
	public static void bossRoom(){
		System.out.println(ANSI_CYAN+"""
				You have entered the final room.
				There is no turning back.
				Fiery torches cast long, dancing
				shadows across the walls of a long,
				dark room. Two demons creep closer
				to you, their horns reflecting the
				torches' glow. The two of them begin
				running toward you, one on the left
				and one on the right, and one tosses
				a giant crate at you.
				What do you do?"""+ANSI_WHITE);
		System.out.println("""
				[1] Shoot the demon on the left
				[2] Shoot the demon on the right
				[3] Shoot the crate
				[4] Dodge the crate""");
		choice=scanner.nextLine();
		clearScreen();
		if(choice.equals("1") || choice.equals("2")){
			System.out.println(ANSI_GREEN+"You shoot them, they die."+ANSI_WHITE);
			killedDemon4=true;
			System.out.println(ANSI_RED+"The crate hit and killed you.");
			deathScreen();
		}else if(choice.equals("3")){
			System.out.println(ANSI_RED+"""
					Unfortunately for you, this isn't an
					arcade game, and you can't shoot inanimate
					objects to kill them. The crate hit and
					killed you.""");
			deathScreen();
		}else if(choice.equals("4")){
			System.out.println(ANSI_CYAN+"""
					You dodged the crate.
					What do you do now?"""+ANSI_WHITE);
			System.out.println("""
					[1] Shoot the left demon
					[2] Shoot the right demon""");
			choice=scanner.nextLine();
			if(choice.equals("1") || choice.equals("2")){
				System.out.println(ANSI_GREEN+"You shoot them, they die."+ANSI_WHITE);
				killedDemon4=true;
				System.out.println(ANSI_CYAN+"What do you do now?"+ANSI_WHITE);
				System.out.println("""
						[1] Shoot the other one
						[2] Break into song""");
				choice=scanner.nextLine();
				if(choice.equals("1")){
					System.out.println(ANSI_GREEN+"You shoot them, they die."+ANSI_WHITE);
					killedDemon5=true;
					clearScreen();
					finalBoss();
				}else if(choice.equals("2")){
					System.out.println(ANSI_RED+"""
							You have sick singing skills,
							but the demon kills you anyways.""");
					deathScreen();
				}else{
					invalidOption();
				}
			}else{
				invalidOption();
			}
		}else{
			invalidOption();
		}
	}
	public static void finalBoss(){
		System.out.println(ANSI_CYAN+"""
				You encounter the final boss...
				a ten-foot tall, human-like beast,
				with giant black horns and huge
				leathery wings. Its bloodred skin
				darkens in the heavy shadows.
				It bellows in fury, smoke billowing
				from its open mouth, as it flys
				towards you, clawed hands outstretched.
				What do you do?"""+ANSI_WHITE);
		System.out.println("""
				[1] Shoot its claws
				[2] Shoot its head
				[3] Shoot its heart""");
		choice=scanner.nextLine();
		clearScreen();
		if(choice.equals("1")){
			System.out.println(ANSI_RED+"""
					You hit its claws perfectly,
					but it just shot fire at you,
					and you died.""");
			deathScreen();
        }else if (choice.equals("3")){
			System.out.println(ANSI_RED+"""
					You hit its heart perfectly,
                    killing it, but not before it
                    shot fire at you and you died.""");
			deathScreen();
		}else if(choice.equals("2")){
			System.out.println(ANSI_CYAN+"""
					You hit its head, preventing
					it from using its fire breath
					and knocking it off balance. It
					lands near you, perfectly in range
					of your shotgun.
					What do you do"""+ANSI_WHITE);
			System.out.println("""
					[1] Shoot its heart
					[2] Shoot its head again""");
			choice=scanner.nextLine();
			System.out.println(ANSI_CYAN+"""
					You've had a hard time in this place,
					so it doesn't really matter where you hit.
					You win!"""+ANSI_WHITE);
			killedBoss=true;
			clearScreen();
			winScreen();
		}else{
			invalidOption();
		}
	}
	static public void winScreen(){
		System.out.print(ANSI_GREEN);
		String mes="""
				Congratulations player!
				You made it out alive,
				and saved many others!
				And you defeated countless
				enemies with your skill and
				smarts!""";
		for(int i=0; i<mes.length(); i++){
			System.out.print(mes.charAt(i));
			try{
				Thread.sleep(75);
			}catch(InterruptedException e){
			}
		}
		System.out.println();
		displayStats();
		System.out.println(ANSI_WHITE);
	}
}
