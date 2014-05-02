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
	protected int level;

	// the panel
	protected int width, height;

	// the game
	protected boolean pause;

	// all collideable objects
	protected ArrayList<CollideableObject> data;

	public SiegeModel(int w, int h, int lvl) throws IOException 
	{
		backgroundImage = ImageIO.read(new File("wallpaper.jpg"));
		paddle = new Paddle(w / 2, h / 2);
		ball = new Ball(w / 2, h / 2 - 15);
		data = new ArrayList<CollideableObject>();
		data.add(paddle);
		data.add(ball);
		level = lvl;
		score = 0;
		width = w;
		height = h;
		pause = true;
		win = GameStatus.ACTIVE;
		lose = GameStatus.ACTIVE;
		switch(level)
		{
		case 1:
			new Level1(this);
			break;
		case 2:
			new Level2(this);
			break;
		case 3:
			new Level3(this);
			break;
		case 4:
			//FUCK I'M TIRED I JUST WANT THIS TO FUCKING WORK ALREADY
		}
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

	public void moveModel() 
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
	
	public void NextLevel()
	{
		data.remove(ball);
	}
	
	
}