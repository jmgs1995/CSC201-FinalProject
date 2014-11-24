
public class Shooter extends GameList
{
	private boolean fps;
	
	public boolean getFPS()
	{
		return fps;
	}
	
	public void setFPS(boolean newFPS)
	{
		fps=newFPS;
	}
	public void display()
	{
		super.display();
		if(fps)
		{
			System.out.println("This game is a first-person shooter.");
		}
		else
		{
			System.out.println("This game is a third-person shooter.");
		}
	}
	Shooter()
	{
		super();
		super.setGenre("Shooter");
	}
}
