package EmpireUnderSiege;

import java.awt.Color;
import java.util.ArrayList;



public class Ball extends CollideableObject
{
	protected final int VELOCITY = 3;
	protected final int SIZE = 12;
	public Ball(int ex, int why)
	{
		shape = Shape.CIRCLE;
		X = ex;
		Y = why;
		Vx = VELOCITY;
		Vy = -VELOCITY;
		SizeX = SIZE;
		SizeY = SIZE;
		color = Color.GRAY;
	}
	
	public void move(ArrayList<CollideableObject> debris, int width, int height)
	{
		for(CollideableObject a : debris)
		{
			if (this.equals(a))
				continue;
			switch(hasCollided(a))
			{
			case XMPACT:
				Vx *= -1;
				break;
			case YMPACT:
				Vy *= -1;
				break;
			case BOTH:
				Vx *= -1;
				Vy *= -1;
				break;
			}
		}
		switch(hitWall(width, height))
		{
		case LEFT:
		case RIGHT:
			Vx *= -1;
			break;	
		case YMPACT:
			Vy *= -1;
			break;
		}
		
		X += Vx;
		Y += Vy;
	}
}