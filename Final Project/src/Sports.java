
public class Sports extends GameList
{
	private boolean team;
	private String sport;
	
	public boolean getTeam()
	{
		return team;
	}
	
	public void setTeam(boolean newTeam)
	{
		team= newTeam;
	}
	
	public String getSport()
	{
		return sport;
	}
	
	public void setSport(String newSport)
	{
		sport= newSport;
	}
	public void display()
	{
		super.display();
		System.out.println("Sport: "+ sport);
		if(team)
		{
			System.out.println("This game is based on a team sport.");
		}
	}
	Sports()
	{
		super();
		super.setGenre("Sports");
	}
}
