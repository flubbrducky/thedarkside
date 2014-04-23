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
		if (a.shape == Shape.CIRCLE && shape == Shape.CIRCLE) {
			// if(Math.sqrt(Math.pow((X-a.X),2) + Math.pow((Y-a.Y),2)) <= (SizeX
			// + a.SizeX))
			// {
			return Impact.NONE;
			// }
		} else {
			// collision with bottom of object
			if (X + SizeX >= a.X && X + SizeX <= a.X + a.SizeX && Y >= a.Y
					&& Y <= a.Y + a.SizeY) {
				return Impact.YMPACT;
			}
			// collision with top of object
			if (Y + SizeX >= a.Y && X >= a.X && X <= a.X + a.SizeX
					&& Y + SizeX <= a.Y + a.SizeY) {
				return Impact.YMPACT;
			}

		}
		return Impact.NONE;
	}

	public Impact hitWall(int width, int height) {
		if (X <= 0)
			return Impact.LEFT;

		else if (X + SizeX >= width)
			return Impact.RIGHT;

		if (Y <= 0 || Y + SizeY >= height) {
			return Impact.YMPACT;
		}
		return Impact.NONE;
	}

	public abstract void move(ArrayList<CollideableObject> stuff, int width,
			int height);

}
// Side collision, top n bottom collision, rectangle on rectangle put in a move
// method in 