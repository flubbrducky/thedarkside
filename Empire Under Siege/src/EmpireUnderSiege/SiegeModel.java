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
	protected int score = 0;
	protected GameStatus win;
	protected GameStatus lose;

	// the panel
	protected int width, height;

	// the game
	protected boolean pause;

	// all collideable objects
	protected ArrayList<CollideableObject> data;

	public SiegeModel(int w, int h) throws IOException 
	{
		backgroundImage = ImageIO.read(new File("wallpaper.jpg"));
		paddle = new Paddle(w / 2, h / 2);
		ball = new Ball(w / 2, h / 2 - 15);
		data = new ArrayList<CollideableObject>();
		data.add(paddle);
		data.add(ball);
		// level 1


		

		width = w;
		height = h;
		pause = true;
		win = GameStatus.ACTIVE;
		lose = GameStatus.ACTIVE;
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
}