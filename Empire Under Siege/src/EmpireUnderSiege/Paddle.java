package EmpireUnderSiege;

import java.awt.Color;
import java.util.ArrayList;

public class Paddle extends CollideableObject 
{
	public static final int SPEED = 10;
	public static final int WIDTH = 100;
	
	public Paddle(int ex, int why)
	{
		shape = Shape.RECTANGLE;
		X = ex;
		Y = why;
		Vx = 0;
		Vy = 0;
		SizeX = 75;
		SizeY = 10;
		color = Color.BLUE;
	}
	
	public void move(SiegeModel model, int width, int height)
	{
		switch(hitWall(700, height))
		{
		case LEFT:
			X = 0;
			break;
		case RIGHT:
			X = 700 - (SizeX + 11);
			break;
		}
		
		X += Vx;
		Y += Vy;
	}
}