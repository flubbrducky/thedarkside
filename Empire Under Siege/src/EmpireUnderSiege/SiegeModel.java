package EmpireUnderSiege;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class SiegeModel 
{

	protected Image backgroundImage;
	protected Paddle paddle;
	protected Ball ball;
	protected int score;
	protected GameStatus win;
	protected GameStatus lose;
	protected Level level;

	// the panel
	protected int width, height;

	// the game
	protected boolean pause;

	// all collideable objects
	protected ArrayList<CollideableObject> data;

	public SiegeModel(int w, int h, Level l) throws IOException 
	{
		level = l;
		backgroundImage = ImageIO.read(new File("wallpaper.jpg"));
		data = new ArrayList<CollideableObject>();
		score = 0;
		width = w;
		height = h;
		pause = true;
		paddle = new Paddle(width / 2, height / 2);
		ball = new Ball(width / 2 + level.ballStart, height / 2 - 15);
		win = GameStatus.ACTIVE;
		lose = GameStatus.ACTIVE;
		InitLvl();
	}

	public ArrayList<CollideableObject> GetData() 
	{
		return data;
	}

	public Ball getBall() 
	{
		return ball;
	}

	public int getScore()
	{
		return score;
	}

	public void PlusScore() 
	{
		score += 10;
	}

	public void MinusScore() 
	{
		score -= 10;
	}
	
	public void GameOver()
	{
		System.exit(0);
	}

	public void MoveModel() 
	{
		if(win == GameStatus.VICTORY || lose == GameStatus.DEFEAT)
			pause = true;
		if(!pause)
		{
			CollideableObject q;
			int i = 0;
			win = GameStatus.VICTORY;
			lose = GameStatus.DEFEAT;
			while (i < data.size()) 
			{
				q = data.get(i);
				if (q.color != Color.BLUE && q.color != Color.GRAY) //if q is a brick
				{
					if (q.Y < Brick.BRICK_OFFSET + 400) //q is an enemy brick
						 win = GameStatus.ACTIVE;
					else 								//q is a friendly brick
						lose = GameStatus.ACTIVE;
					if (((Brick) q).hits == 0) //removes bricks without throwing NullPointerException
					{
						data.remove(q);
						i++;
						continue;
					}
				}
				q.move(this, width, height);
				i++;
			}
		}
	}

	public void PaddleLeft() 
	{
		paddle.Vx = paddle.SPEED * -1;
	}

	public void PaddleRight() 
	{
		paddle.Vx = paddle.SPEED;
	}

	public void StopPaddle() 
	{
		paddle.Vx = 0;
	}

	public int GetWidth() 
	{
		return width;
	}

	public int GetHeight() 
	{
		return height;
	}

	public void Pause() 
	{
		pause = !pause;
	}
	
	public void InitLvl()
	{
		pause = true;
		win = GameStatus.ACTIVE;
		lose = GameStatus.ACTIVE;
		paddle = new Paddle(width / 2, height / 2);
		ball = new Ball(width / 2 + level.ballStart, height / 2 - 15);
		data.add(paddle);
		data.add(ball);
		for(CollideableObject brick : level.build())
			data.add(brick);
	}
	
	public void NextLevel()
	{
		if(win == GameStatus.VICTORY)
		{
			data.clear();
			switch(level.number)
			{
			case 1:
				level = new Level2();
				InitLvl();
				break;
			case 2:
				level = new Level3();
				InitLvl();
				break;
			case 3:
				GameOver();
				break;
			}
		}
		else if(lose == GameStatus.DEFEAT)
		{
			data.clear();
			score = 0;
			switch(level.number)
			{
			case 1:
				level = new Level1();
				InitLvl();
				break;
			case 2:
				level = new Level2();
				InitLvl();
				break;
			case 3:
				level = new Level3();
				InitLvl();
				break;
			}
		}
	}
	
	
}