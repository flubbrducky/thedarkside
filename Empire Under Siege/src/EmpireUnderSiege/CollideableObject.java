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

	public Impact hasCollided(CollideableObject a) {
		if (a.shape == Shape.CIRCLE && shape == Shape.CIRCLE) 
		{
			return Impact.NONE;
		} 
		else 
		{
			if (X + SizeX >= a.X && X <= a.X + a.SizeX) 
			{
				if (Y + SizeY >= a.Y && Y <= a.Y + a.SizeY) 
				{
					if (X + SizeX - Vx <= a.X || X - Vx >= a.X + a.SizeX) 
					{
						return Impact.XMPACT;
					} 
					else 
					
					{
						return Impact.YMPACT;
					}
				}
			}
		}
		return Impact.NONE;
	}

	public Impact hitWall(int width, int height) 
	{
		
		if (X <= 0)
			return Impact.LEFT;

		else if (X >= 700 -SizeX)
			return Impact.RIGHT;

		if (Y <= 0 || Y +(SizeY*2)  >= height-(SizeY*4)) {
			return Impact.YMPACT;
		}
		return Impact.NONE;
	}

	public abstract void move(SiegeModel model, int width,
			int height);

}