package EmpireUnderSiege;

import java.awt.Color;
import java.util.ArrayList;

public class Paddle extends CollideableObject 
{
	public final int SPEED = 10;
	
	public Paddle(int ex, int why)
	{
		shape = Shape.RECTANGLE;
		X = ex;
		Y = why;
		Vx = 0;
		Vy = 0;
		SizeX = 100;
		SizeY = 11;
		color = Color.BLUE;
	}
	
	public void move(ArrayList<CollideableObject> debris, int width, int height)
	{
		switch(hitWall(width, height))
		{
		case LEFT:
			X = 0;
			break;
		case RIGHT:
			X = width - (SizeX + 1);
			break;
		}
		
		X += Vx;
		Y += Vy;
	}
}
