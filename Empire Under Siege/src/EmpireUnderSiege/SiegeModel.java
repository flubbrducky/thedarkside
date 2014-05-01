package EmpireUnderSiege;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.imageio.ImageIO;

public class SiegeModel {
	
	protected Image backgroundImage;
	protected Paddle paddle;
	protected Ball ball;
	static int score = 0;
	
	// the bricks
	ArrayList eBricks;
	ArrayList fBricks;
	
	// the panel
	protected int width, height;

	// the game
	protected boolean pause;
	
	protected ArrayList<CollideableObject> data;

	public SiegeModel(int w, int h) throws IOException 
	{
		backgroundImage = ImageIO.read(new File("wallpaper.jpg"));		  
		paddle = new Paddle(w/2, h/2);
		ball = new Ball(w/2, h/2 - 15);
		eBricks = new ArrayList();
		data = new ArrayList<CollideableObject>();
		data.add(paddle);
		data.add(ball);
		//enemy bricks
		for (int i = 0; i < 7; i++)
		  {
		    Brick e = new Brick((75*i) + 50, 30);
		    eBricks.add(e);
		  }
		
		fBricks = new ArrayList();
		// friendly bricks
		for (int i = 0; i < 7; i++)
		  {
		    Brick f = new Brick((75*i) + 50, 700);
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
	
	public int getScore(){
		return score;
	}
	
	public void PlusScore(){
		score += 10;
	}
	
	public void MinusScore(){
		score -= 10;
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
	
	public void endGame(){
		data.remove(ball);
	}
	
	public void Pause()  
	{
		
			try {
				if(!pause)
				Thread.sleep(1000);
				else{
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
