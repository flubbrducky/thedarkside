package EmpireUnderSiege;

import java.awt.*;
import java.io.File;
<<<<<<< HEAD

=======
>>>>>>> Brick-Remake
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SiegePanel extends JPanel {
	protected SiegeModel model;
	protected SiegeView view;
	protected Level2 level2;
	protected Level3 level3;
	boolean win = false;
	boolean win1 = false;
	boolean win2 = false;
 
	/**
	 * Set up the instance variables and the focus.
	 * 
	 * @param model
	 *            the model of this Siege game
	 * @param view
	 *            the view of this Siege game
	 */
	public SiegePanel(SiegeModel model, SiegeView view, Level2 level2, Level3 level3) {
		this.model = model;
		this.view = view;
		this.level2 = level2;
		this.level3 = level3;
		// so this JPanel can listen to the keyboard
		this.setFocusable(true);
	}

	/**
	 * Draw the paddle and the ball. Pay attention to whether flipVertical is
	 * true or not.
	 */
<<<<<<< HEAD
	public void paintComponent(Graphics g) {
		if (win != true){
		super.paintComponent(g);
	    g.drawImage(model.backgroundImage, 0, 0, this);
		g.setColor(Color.BLACK);
=======
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
		
		g.drawImage(model.backgroundImage, 0, 0, this);
		g.setColor(Color.WHITE);
>>>>>>> Brick-Remake
		Font font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
        g.setColor(Color.BLACK);
        g.drawString("Score:" + model.getScore(), 575, 20);  
        g.drawString("Level " + model.level.number, 10, 20); 
		
		g.setColor(Color.GRAY.brighter());
		for(CollideableObject oh : model.data)
		{
			g.setColor(oh.color);
			switch(oh.shape)
			{
			case RECTANGLE:	
				g.setColor(Color.GRAY.brighter());
				g.fillRect(oh.X, oh.Y, oh.SizeX, oh.SizeY);
				g.setColor(Color.BLACK);
				g.drawRect(oh.X, oh.Y, oh.SizeX - 1, oh.SizeY - 1);
				break;
			case CIRCLE:
<<<<<<< HEAD
				g.setColor(Color.BLUE.brighter());
				g.fillOval(oh.X-2, oh.Y-2, oh.SizeX+3, oh.SizeY+3);
				g.setColor(Color.RED);
=======
				g.setColor(Color.RED.brighter());
				g.fillOval(oh.X-2, oh.Y-2, oh.SizeX+3, oh.SizeY+3);
				g.setColor(Color.WHITE);
>>>>>>> Brick-Remake
				g.fillOval(oh.X, oh.Y, oh.SizeX, oh.SizeY);
		
				break;
			}
		}
		
<<<<<<< HEAD

       
		// draw the enemy bricks
		for (int i = 0; i < eBricks.size(); i++)
		  {
			g.setColor(Color.BLACK);
	        g.drawString("Score:" + model.getScore(), 575, 20); 
			g.setColor(Color.BLUE);
		    Brick b = (Brick) eBricks.get(i);
		    b.show();
		    if (b.touches(ball))
		    {
		      ball.Vy *= -1;
		        eBricks.remove(b);
		        model.PlusScore();
		    } else {
		    	g.fillRect(b.x, b.y, 75, 20);
		    	g.setColor(Color.BLACK);
		    	g.drawRect(b.x, b.y, 75, 20);
		      }
		    }
		  
		g.setColor(Color.RED);
		// draw the friendly bricks
		for (int i = 0; i < fBricks.size(); i++)
		  {
		    Brick b = (Brick) fBricks.get(i);
		    b.show();
		    if (b.touches(ball))
		    {
		      ball.Vy *= -1;
		        fBricks.remove(b);
		        model.MinusScore();
		    } else {
		    	g.fillRect(b.x, b.y, 75, 20);
		    	g.setColor(Color.BLACK);
		    	g.drawRect(b.x, b.y, 75, 20);
		      }
		   }
		
		if (fBricks.size() == 0) {
	        		g.setColor(Color.BLUE);
	    	        g.setFont(new Font("SanSerif", Font.BOLD, 96));
	    	        g.drawString("GAME OVER", 50, 400);
	    	        g.setFont(new Font("SanSerif", Font.BOLD, 25));
	    	        g.drawString("Press Escape to exit!", 200, 450);
	    	        model.endGame();
		}
		if (eBricks.size() == 0) { 
	        	g.setColor(Color.RED);
		        g.setFont(new Font("SanSerif", Font.BOLD, 96));
		        g.drawString("YOU WIN!", 100, 400);
		        g.setFont(new Font("SanSerif", Font.BOLD, 25));
    	        g.drawString("Press Escape to exit!", 200, 450);
		      //  model.endGame();
    	        win = true;
		        
		}
		}else if(win1 != true){
			super.paintComponent(g);
		    g.drawImage(model.backgroundImage, 0, 0, this);
			g.setColor(Color.BLACK);
			Font font = new Font("Courier", Font.PLAIN, 20);
	        g.setFont(font);
	 
	        g.drawString("Level 2", 10, 20); 
			
			g.setColor(Color.GRAY.brighter());
			for(CollideableObject oh : model.GetData())
			{
				g.setColor(oh.color);
				switch(oh.shape)
				{
				case RECTANGLE:	
					g.setColor(Color.GRAY.brighter());
					g.fillRect(oh.X, oh.Y, oh.SizeX, oh.SizeY);
					break;
				case CIRCLE:
					g.setColor(Color.BLUE.brighter());
					g.fillOval(oh.X-2, oh.Y-2, oh.SizeX+3, oh.SizeY+3);
					g.setColor(Color.RED);
					g.fillOval(oh.X, oh.Y, oh.SizeX, oh.SizeY);
			
					break;
				}
			}
			ArrayList<Brick> eBricks2 = level2.getEnemyBricks();
			ArrayList<Brick> fBricks2 = level2.getFriendlyBricks();
			Ball ball = model.getBall();
			

	       
			// draw the enemy bricks
			for (int i = 0; i < eBricks2.size(); i++)
			  {
				g.setColor(Color.BLACK);
		        g.drawString("Score:" + model.getScore(), 575, 20); 
				g.setColor(Color.BLUE);
			    Brick b = (Brick) eBricks2.get(i);
			    b.show();
			    if (b.touches(ball))
			    {
			      ball.Vy *= -1;
			        eBricks2.remove(b);
			        model.PlusScore();
			    } else {
			    	g.fillRect(b.x, b.y, 75, 20);
			    	g.setColor(Color.BLACK);
			    	g.drawRect(b.x, b.y, 75, 20);
			      }
			    }
			  
			g.setColor(Color.RED);
			// draw the friendly bricks
			for (int i = 0; i < fBricks2.size(); i++)
			  {
			    Brick b = (Brick) fBricks2.get(i);
			    b.show();
			    if (b.touches(ball))
			    {
			      ball.Vy *= -1;
			        fBricks2.remove(b);
			        model.MinusScore();
			    } else {
			    	g.fillRect(b.x, b.y, 75, 20);
			    	g.setColor(Color.BLACK);
			    	g.drawRect(b.x, b.y, 75, 20);
			      }
			   }
			
			if (fBricks2.size() == 0) {
		        		g.setColor(Color.BLUE);
		    	        g.setFont(new Font("SanSerif", Font.BOLD, 96));
		    	        g.drawString("GAME OVER", 50, 400);
		    	        g.setFont(new Font("SanSerif", Font.BOLD, 25));
		    	        g.drawString("Press Escape to exit!", 200, 450);
		    	        model.endGame();
		    	        win1 = false;
			}
			if (eBricks2.size() == 0) { 
		        	g.setColor(Color.RED);
			        g.setFont(new Font("SanSerif", Font.BOLD, 96));
			        g.drawString("YOU WIN!", 100, 400);
			        g.setFont(new Font("SanSerif", Font.BOLD, 25));
	    	        g.drawString("Press Escape to exit!", 200, 450);
			     //   model.endGame();
			        win1 = true;
			        win2 = true;
			}
		}else if(win2=true){
			super.paintComponent(g);
		    g.drawImage(model.backgroundImage, 0, 0, this);
			g.setColor(Color.BLACK);
			Font font = new Font("Courier", Font.PLAIN, 20);
	        g.setFont(font);
	 
	        g.drawString("Level 3", 10, 20); 
			
			g.setColor(Color.GRAY.brighter());
			for(CollideableObject oh : model.GetData())
			{
				g.setColor(oh.color);
				switch(oh.shape)
				{
				case RECTANGLE:	
					g.setColor(Color.GRAY.brighter());
					g.fillRect(oh.X, oh.Y, oh.SizeX, oh.SizeY);
					break;
				case CIRCLE:
					g.setColor(Color.BLUE.brighter());
					g.fillOval(oh.X-2, oh.Y-2, oh.SizeX+3, oh.SizeY+3);
					g.setColor(Color.RED);
					g.fillOval(oh.X, oh.Y, oh.SizeX, oh.SizeY);
			
					break;
				}
			}
			ArrayList<Brick> eBricks3 = level3.getEnemyBricks();
			ArrayList<Brick> fBricks3 = level3.getFriendlyBricks();
			Ball ball = model.getBall();
			

	       
			// draw the enemy bricks
			for (int i = 0; i < eBricks3.size(); i++)
			  {
				g.setColor(Color.BLACK);
		        g.drawString("Score:" + model.getScore(), 575, 20); 
				g.setColor(Color.BLUE);
			    Brick b = (Brick) eBricks3.get(i);
			    b.show();
			    if (b.touches(ball))
			    {
			      ball.Vy *= -1;
			        eBricks3.remove(b);
			        model.PlusScore();
			    } else {
			    	g.fillRect(b.x, b.y, 75, 20);
			    	g.setColor(Color.BLACK);
			    	g.drawRect(b.x, b.y, 75, 20);
			      }
			    }
			  
			g.setColor(Color.RED);
			// draw the friendly bricks
			for (int i = 0; i < fBricks3.size(); i++)
			  {
			    Brick b = (Brick) fBricks3.get(i);
			    b.show();
			    if (b.touches(ball))
			    {
			      ball.Vy *= -1;
			        fBricks3.remove(b);
			        model.MinusScore();
			    } else {
			    	g.fillRect(b.x, b.y, 75, 20);
			    	g.setColor(Color.BLACK);
			    	g.drawRect(b.x, b.y, 75, 20);
			      }
			   }
			
			if (fBricks3.size() == 0) {
		        		g.setColor(Color.BLUE);
		    	        g.setFont(new Font("SanSerif", Font.BOLD, 96));
		    	        g.drawString("GAME OVER", 50, 400);
		    	        g.setFont(new Font("SanSerif", Font.BOLD, 25));
		    	        g.drawString("Press Escape to exit!", 200, 450);
		    	        model.endGame();
			}
			if (eBricks3.size() == 0) { 
		        	g.setColor(Color.RED);
			        g.setFont(new Font("SanSerif", Font.BOLD, 96));
			        g.drawString("YOU WIN!", 100, 400);
			        g.setFont(new Font("SanSerif", Font.BOLD, 25));
	    	        g.drawString("Press Escape to exit!", 200, 450);
			        model.endGame();
=======
		if(model.lose == GameStatus.DEFEAT)
		{
			g.setColor(Color.RED);
			g.setFont(new Font("SanSerif", Font.BOLD, 96));
	        g.drawString("GAME OVER", 50, 400);
	        g.setFont(new Font("SanSerif", Font.BOLD, 25));
	        g.drawString("Press Up-Arrow to start over!", 200, 450);
		}
		
		else if(model.win == GameStatus.VICTORY)
		{
			if(model.level.number == 3)
			{
				g.setColor(Color.RED);
				g.setFont(new Font("SanSerif", Font.BOLD, 96));
		        g.drawString("YOU WIN!", 100, 400);
		        g.setFont(new Font("SanSerif", Font.BOLD, 25));
		        g.drawString("Press Escape to exit!", 200, 450);
			}
			else
			{
				g.setColor(Color.RED);
				g.setFont(new Font("SanSerif", Font.BOLD, 96));
		        g.drawString("YOU WIN!", 100, 400);
		        g.setFont(new Font("SanSerif", Font.BOLD, 25));
		        g.drawString("Press Up-Arrow to Start Next Level!", 200, 450);
>>>>>>> Brick-Remake
			}
		}
	 }
		
}
