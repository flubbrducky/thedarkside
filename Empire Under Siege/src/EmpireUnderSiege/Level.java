package EmpireUnderSiege;

import java.util.ArrayList;

public abstract class Level 
{
	protected int number;
	protected int ballStart;
	protected ArrayList<CollideableObject> dat;
	
	public ArrayList<CollideableObject> build()
	{
		return dat;
	}
	
}