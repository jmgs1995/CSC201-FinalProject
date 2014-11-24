import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class UIClass 
{
	static GameList[] list= new GameList[100];
	static int listPosition=0;
	public static void main(String[] args) throws AWTException
	{
		int answer;
		String genre;
		boolean programContinues=true;
		RPG FinalFantasy= new RPG();
		FinalFantasy.setName("Final Fantasy");
		FinalFantasy.setScore(100);
		FinalFantasy.setJRPG(true);
		list[0]= FinalFantasy;
		RPG Skyrim= new RPG();
		Skyrim.setName("Skyrim");
		Skyrim.setScore(90);
		Skyrim.setJRPG(false);
		list[1]= Skyrim;
		Shooter cod= new Shooter();
		cod.setName("Call of duty");
		cod.setScore(95);
		cod.setFPS(true);
		list[2]= cod;
		Shooter gow= new Shooter();
		gow.setName("Gears of war");
		gow.setScore(80);
		gow.setFPS(false);
		list[3]= gow;
		Sports fifa= new Sports();
		fifa.setName("FIFA");
		fifa.setScore(80);
		fifa.setTeam(true);
		fifa.setSport("Soccer");
		list[4]= fifa;
		Sports stb= new Sports();
		stb.setName("Super Tennis Bros.");
		stb.setScore(100);
		stb.setTeam(false);
		stb.setSport("Table Tennis");
		list[5]=stb;
		Puzzles phoenix = new Puzzles();
		phoenix.setName("Phoenix Wright");
		phoenix.setScore(91);
		list[6]= phoenix;
		Puzzles candyCrush= new Puzzles();
		candyCrush.setName("Candy Crush Saga");
		candyCrush.setScore(50);
		list[7]= candyCrush;
		listPosition=7;
		bannerMain();
		loadMain();		
		while(programContinues)
		{
			Scanner intKey = new Scanner(System.in);
		
			answer=intKey.nextInt();
			
			if(answer==1)
			{
				wipeConsole();
				bannerMain();
				Scanner keyboard = new Scanner(System.in);
				String introMessageA = "ADDING A GAME TO THE DATABASE";
				String introMessageB = " ENTER A GENRE FROM BELOW: ";
				String introMenuOptionA = "1) RPG ";
				String introMenuOptionB = "2) SPORTS";
				String introMenuOptionC = "3) SHOOTER ";
				String introMenuOptionD = "4) JRPG";
				String introMenuOptionE = "5) PUZZLE";
				String[] introOptionPane = new String[7];
				
				introOptionPane[0] = introMessageA;
				introOptionPane[1] = introMessageB;
				introOptionPane[2] = introMenuOptionA;
				introOptionPane[3] = introMenuOptionB;
				introOptionPane[4] = introMenuOptionC;
				introOptionPane[5] = introMenuOptionD;
				introOptionPane[6] = introMenuOptionE;
				int udBorder = introMessageA.length()+10;
				int lrBorder;
				
				try 
				{
				    TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) 
				{/*Handle exception*/}
				for (int i = 0; i < udBorder; i++) {
					System.out.print("=");
				}
				System.out.println("=");
			
				for (int i = 0; i < 7; i++) {
					lrBorder = (udBorder - introOptionPane[i].length()) / 2;
					for (int j = 0; j < lrBorder; j++) {
						System.out.print("=");
					}
					System.out.print(introOptionPane[i]);
					for (int k = 0; k < lrBorder-1; k++) {
						System.out.print("=");
					}
					System.out.print("=");
					System.out.println("=");
				}
				
				for (int i = 0; i < udBorder; i++) {
					System.out.print("=");
				}
				System.out.println("=");
				genre=keyboard.next();
				
				if(genre.equalsIgnoreCase("RPG")||genre.equalsIgnoreCase("1"))
				{
					RPG game = new RPG();
					game.setJRPG(false);
					setNewRPG(game);
					
				}
				
				if(genre.equalsIgnoreCase("Sports")||genre.equalsIgnoreCase("2"))
				{
					Sports game = new Sports();
					setNewSport(game);

				}
				
				if(genre.equalsIgnoreCase("Shooter")||genre.equalsIgnoreCase("3"))
				{
					Shooter game = new Shooter();
					setNewShooter(game);

				}
				
				if(genre.equalsIgnoreCase("jRPG")||genre.equalsIgnoreCase("4"))
				{
					RPG game = new RPG();
					game.setJRPG(true);
					setNewRPG(game);

				}
				
				if(genre.equalsIgnoreCase("puzzle")||genre.equalsIgnoreCase("5"))
				{
					Puzzles game = new Puzzles();
					setNewPuzzle(game);
				}
			}
			
			if(answer==2)
			{
			System.out.println("Choose the index number of the game to delete");
				printAllNoTimeDelay();
				int delIndex = intKey.nextInt();
				if (delIndex>listPosition)
				{
					System.out.println("There is no game at the specified index.");
				}
				else
				{
					for( int i= delIndex; i< listPosition;i++)
					{
						list[i]= list[i+1];
						listPosition--;
						wipeConsole();
						printAllNoTimeDelay();
						
					}
					System.out.println("Are you finished?(yes / no)");
					String confirm= intKey.nextLine();
					if(confirm.equalsIgnoreCase("yes"))
					{
						exitProgram();
					}
					else if (confirm.equalsIgnoreCase("no"))
					{
						returnToMain();
					}
				}	
			}
			
			if(answer==3)
			{
				
			}
			
			if(answer==4)
			{
				printAllNoTimeDelay();
			}
			if(answer==5)
			{
				exitProgram();
				programContinues=false;
			}
		}
	}
	
	public static void bannerMain() {
		System.out.println("      ---------------------------");
		System.out.println("     |NVCC'S GAME DATABASE EDITOR|");
		System.out.println("      ---------------------------\n");
	}
	
	public static void loadMain() {
		Scanner keyboard = new Scanner(System.in);
		String introMessage = "Welcome to Game Search Engine";
		String introMenuOptionA = "1) ADD ";
		String introMenuOptionB = " 2) REMOVE ";
		String introMenuOptionC = "3) FAVORITES ";
		String introMenuOptionD = "4) PRINT LIST";
		String introMenuOptionE = "5) END PROGRAM ";
		String[] introOptionPane = new String[6];
		
		introOptionPane[0] = introMessage;
		introOptionPane[1] = introMenuOptionA;
		introOptionPane[2] = introMenuOptionB;
		introOptionPane[3] = introMenuOptionC;
		introOptionPane[4] = introMenuOptionD;
		introOptionPane[5] = introMenuOptionE;
		int udBorder = introMessage.length()+10;
		int lrBorder;

		try 
		{
		    TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) 
		{/*Handle exception*/}
		for (int i = 0; i < udBorder; i++) {
			System.out.print("="); // TOP ROW: =========================
		}
		System.out.println("=");
		for (int i = 0; i < 6; i++) {
			lrBorder = (udBorder - introOptionPane[i].length()) / 2;
			for (int j = 0; j < lrBorder; j++) {
				System.out.print("=");
			}
			System.out.print(introOptionPane[i]);
			for (int k = 0; k < lrBorder-1; k++) {
				System.out.print("=");
			}
			System.out.print("=");
			System.out.println("=");
		}
		for (int i = 0; i < udBorder; i++) {
			System.out.print("=");
		}
		System.out.println("=");
		
		System.out.println("Directions: With this program you are able to\n\t    add, remove, and favorite our database.");
	}
	
	public static void printAllNoTimeDelay() {
		for(int i=0; i<=listPosition;i++) {
			System.out.println("Showing Index: " + i);
			list[i].display();
			System.out.println("--------------------------------");
		}
	}
	
	public static void returnToMain() {
		Scanner returnKey = new Scanner(System.in);
		System.out.println("To return to main screen, press 0");
		System.out.println("To exit from the program, press 1");
		System.out.println("To return to the previous menu, press 2");
		int returnTo = returnKey.nextInt();
		if (returnTo == 0) {
			bannerMain();
			loadMain();
		}
		else if (returnTo == 1) {
			exitProgram();
			
		}
		else if (returnTo == 2) {
			showPrevious();
		}	
	}
	
	public static void exitProgram() {
		System.out.println("You have decided to end the program.");
			try	{
		    	TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {/*Handle exception*/}
				System.out.println("This is the final list you have decide to end the program with:");
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (InterruptedException e) {/*Handle exception*/}
				System.out.print("Printing...");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {/*Handle exception*/}
				System.out.println(" ...\n");
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e) {/*Handle exception*/}
				for(int i=0; i<=listPosition;i++)
				{
					list[i].display();
					System.out.println("--------------------------------");
					try 
					{
					    TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e) 
					{/*Handle exception*/}
				}
				
	}
	
	public static void showPrevious() {
		
	}
	
	public static void wipeConsole() throws AWTException{
		Robot robbie = new Robot();
        //shows the Console View
        robbie.keyPress(KeyEvent.VK_ALT);
        robbie.keyPress(KeyEvent.VK_SHIFT);
        robbie.keyPress(KeyEvent.VK_Q);
        robbie.keyRelease(KeyEvent.VK_ALT);
        robbie.keyPress(KeyEvent.VK_SHIFT);
        robbie.keyPress(KeyEvent.VK_Q);
        robbie.keyPress(KeyEvent.VK_C);
        robbie.keyRelease(KeyEvent.VK_C);

        //clears the console
        robbie.keyPress(KeyEvent.VK_SHIFT);
        robbie.keyPress(KeyEvent.VK_F10);
        robbie.keyRelease(KeyEvent.VK_SHIFT);
        robbie.keyRelease(KeyEvent.VK_F10);
        robbie.keyPress(KeyEvent.VK_R);
        robbie.keyRelease(KeyEvent.VK_R);
    }
    
	public static void setNewRPG(RPG game)
	{
		
		Scanner stringKey = new Scanner(System.in);
		System.out.println("What is the name of the game?");
		String gameName=stringKey.nextLine();
		game.setName(gameName);
		System.out.println("What would you score "+gameName+"?");
		game.setScore(stringKey.nextInt());
		
		listPosition+=1;
		
		list[listPosition]=game;
		returnToMain();
	}
	
	public static void setNewShooter(Shooter game)
	{
		Scanner stringKey = new Scanner(System.in);

		System.out.println("What is the name of the game?");
		String gameName=stringKey.nextLine();
		stringKey.nextLine();
		
		game.setName(gameName);
		
		System.out.println("What would you score "+gameName+"?");
		game.setScore(stringKey.nextInt());
		stringKey.nextLine();

		
		System.out.println("Is this game a first-person shooter?(yes/no)");
		gameName=stringKey.nextLine();
		stringKey.nextLine();
		
		if(gameName.equalsIgnoreCase("yes"))
		{
			game.setFPS(true);
		}
		else
		{
			game.setFPS(false);
		}
		listPosition+=1;
		list[listPosition]=game;
		returnToMain();
	}
	
	public static void setNewSport(Sports game)
	{
		Scanner stringKey = new Scanner(System.in);

		System.out.println("What is the name of the game?");
		String gameName=stringKey.nextLine();
		stringKey.nextLine();
		
		game.setName(gameName);
		
		System.out.println("What would you score "+gameName+"?");
		game.setScore(stringKey.nextInt());
		stringKey.nextLine();
		
		System.out.println("What sport is this game?");
		game.setSport(stringKey.nextLine());
		stringKey.nextLine();
		
		System.out.println("Is this game a team based game?(yes/no)");
		gameName=stringKey.nextLine();
		stringKey.nextLine();
		
		
		if(gameName.equalsIgnoreCase("yes"))
		{
			game.setTeam(true);
		}
		else
		{
			game.setTeam(false);
		}
		
		listPosition+=1;
		
		list[listPosition]=game;
		returnToMain();
	}
	
	public static void setNewPuzzle(Puzzles game)
	{
		Scanner stringKey = new Scanner(System.in);

		System.out.println("What is the name of the game?");
		String gameName=stringKey.nextLine();
		stringKey.nextLine();
		game.setName(gameName);
		System.out.println("What would you score "+gameName+"?");
		game.setScore(stringKey.nextInt());

		listPosition+=1;
		
		list[listPosition]=game;
		returnToMain();
	}

}

/*if(genre.equalsIgnoreCase("RPG"))
{
RPG game = new RPG();
return game;
}
if(genre.equalsIgnoreCase("Sports"))
{

}
if(genre.equalsIgnoreCase("Shooter"))
{

}
if(genre.equalsIgnoreCase("jRPG"))
{

}
if(genre.equalsIgnoreCase("puzzle"))
{
//Puzzles game = new Puzzles();
//return game;
}*/
