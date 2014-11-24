
public class RPG extends GameList
{
	private boolean jRPG;
	
	public boolean getJRPG()
	{
		return jRPG;
	}
	
	public void setJRPG(boolean newJRPG)
	{
		jRPG= newJRPG;
	}
	public void display()
	{
		super.display();
		if(jRPG)
		{
			System.out.println("This game is a JRPG.");
		}
		else
		{
			System.out.println("This game is a western RPG.");
		}
	}
	
	RPG()
	{
		super();
		super.setGenre("RPG");
		
		
	}
	
}
