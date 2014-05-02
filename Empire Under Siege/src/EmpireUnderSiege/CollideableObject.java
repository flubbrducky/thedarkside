package EmpireUnderSiege;

import java.awt.Color;
import java.lang.Math.*;
import java.util.ArrayList;

public abstract class CollideableObject {
	public int X, Y;
	public int SizeX, SizeY;
	public int Vx, Vy;
	public Shape shape;
	public Color color;

	/**
	 * @param a Either the paddle or a brick
	 */
	public Impact hasCollided(CollideableObject a) {
		if (a.shape == Shape.CIRCLE && shape == Shape.CIRCLE) 
		{
			return Impact.NONE; //balls cannot collide with each other
		} 
		else 
		{
			if (X + SizeX >= a.X && X <= a.X + a.SizeX) // if the ball's x-position
			{											// is within the bounds of a
				if (Y + SizeY >= a.Y && Y <= a.Y + a.SizeY) // if the ball's y-position
				{											// is within the bounds of a
					if (X + SizeX - Vx <= a.X || X - Vx >= a.X + a.SizeX)
					{						
						if(Y + SizeY - Vy <= a.Y || Y - Vy >= a.Y + a.SizeY)
						{
							return Impact.BOTH;// if ball is about to collide with edge of a
						}
						return Impact.XMPACT;// if ball is about to collide with a from side
					} 
					else 
					{
						return Impact.YMPACT; //ball is about to collide with a from top or bottom
					}
				}
			}
		}
		return Impact.NONE;
	}

	public Impact hitWall(int width, int height) 
	{
		
		if (X <= 0)
		{
			if(Y <= 0 || Y +(SizeY*2)  >= height - (SizeY*4))
				return Impact.BOTH; //ball about to hit corner
			return Impact.LEFT;
		}

		else if (X >= 700 - SizeX)
		{
			if(Y <= 0 || Y +(SizeY*2)  >= height - (SizeY*4))
				return Impact.BOTH; //ball about to hit corner
			return Impact.RIGHT;
		}

		else if (Y <= 0)
			return Impact.TOP;
		
		else if (Y +(SizeY*2)  >= height-(SizeY*4))
			return Impact.BOTTOM;
		
		return Impact.NONE;
	}

	public abstract void move(SiegeModel model, int width,
			int height);

}