package EmpireUnderSiege;

import java.util.ArrayList;

public class SiegeModel {
	
	protected Paddle paddle;
	
	protected Ball ball;
	
	// the bricks

	ArrayList eBricks;
	ArrayList fBricks;
	
	// the panel
	protected int width, height;

	// the game
	protected boolean pause;
	
	protected ArrayList<CollideableObject> data;

	public SiegeModel(int w, int h)
	{
		paddle = new Paddle(w/2, h/2);
		ball = new Ball(w/2, h/2 + 15);
		eBricks = new ArrayList();
		data = new ArrayList<CollideableObject>();
		data.add(paddle);
		data.add(ball);
		//enemy bricks
		for (int i = 0; i < 6; i++)
		  {
		    Brick e = new Brick((100*i) + 50, 30);
		    eBricks.add(e);
		  }
		
		fBricks = new ArrayList();
		// friendly bricks
		for (int i = 0; i < 6; i++)
		  {
		    Brick f = new Brick((100*i) + 50, 700);
		    fBricks.add(f);
		  }

		width = w;
		height = h;
		pause = false;
	}

	public ArrayList<CollideableObject> GetData()
	{
		return data;
	}
	
	public Ball getBall(){
		return ball;
	}
	
	public ArrayList<Brick> getEnemyBricks(){
		return eBricks;
	}
	
	public ArrayList<Brick> getFriendlyBricks(){
		return fBricks;
	}
	
	public void moveModel()
	{
		for(CollideableObject q : data)
		q.move(data, width, height);
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
