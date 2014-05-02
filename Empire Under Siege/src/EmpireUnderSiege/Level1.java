package EmpireUnderSiege;

import java.util.ArrayList;

public class Level1 extends Level
{
	
	public Level1()
	{
		dat = new ArrayList<CollideableObject>();
		number = 1;
		ballStart = 0;
		
		//enemy bricks
		for (int i = 0, health = 1; i < 5; i++) 
		{
			if (i < 3)
				health++;
			else
				health--;
			
			dat.add(new Brick(((Brick.BRICK_X) * i) + 160,
					Brick.BRICK_OFFSET, health));
		}

		// friendly bricks
		for (int i = 0, health = 1; i < 5; i++) 
		{
			if (i < 3)
				health++;
			else
				health--;

			dat.add(new Brick(((Brick.BRICK_X) * i) + 160,
					800 - Brick.BRICK_OFFSET, health));
		}
	}
}
