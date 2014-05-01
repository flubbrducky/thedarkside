package EmpireUnderSiege;

public class Level1 extends Level
{

	public Level1(SiegeModel m)
	{
		model = m;
		
		//enemy bricks
		for (int i = 0, health = 1; i < 5; i++) 
		{
			if (i < 3)
				health++;
			else
				health--;
			
			model.data.add(new Brick(((Brick.BRICK_X) * i) + 160,
					Brick.BRICK_OFFSET, health));
		}

		// friendly bricks
		for (int i = 0, health = 1; i < 5; i++) 
		{
			if (i < 3)
				health++;
			else
				health--;

			model.data.add(new Brick(((Brick.BRICK_X) * i) + 160,
					800 - Brick.BRICK_OFFSET, health));
		}
	}
}
