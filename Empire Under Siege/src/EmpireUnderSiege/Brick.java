package EmpireUnderSiege;

import java.awt.Color;
import java.util.ArrayList;

public class Brick extends CollideableObject
{
	public int hits;
	public static final int BRICK_X = 75;
	public static final int BRICK_OFFSET = 65;
	
  
	public Brick(int ex, int why, int health)
	{
		X = ex;
		Y = why;
		SizeX = BRICK_X;
		SizeY = 20;
		Vx = 0;
		Vy = 0;
		shape = Shape.RECTANGLE;
		hits = health;
		color = getColor();
	}

	public Color getColor()
	{
		switch(hits)
		{
		case 4:
			return Color.RED;
		case 3:
			return Color.MAGENTA;
		case 2:
			return Color.GREEN;
		}
		return Color.YELLOW;
	}
	
	public void move(ArrayList<CollideableObject> stuff, int width,int height)
	{
		//
	}
	
	public void hitBrick()
	{
		hits--;
		color = getColor();
	}
	
}
