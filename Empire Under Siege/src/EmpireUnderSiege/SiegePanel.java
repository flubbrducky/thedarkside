package EmpireUnderSiege;

import java.awt.*;
import java.io.File;

import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SiegePanel extends JPanel {
	protected SiegeModel model;
	protected SiegeView view;
	protected Level2 level2;
	boolean win = false;
 
	/**
	 * Set up the instance variables and the focus.
	 * 
	 * @param model
	 *            the model of this Siege game
	 * @param view
	 *            the view of this Siege game
	 */
	public SiegePanel(SiegeModel model, SiegeView view, Level2 level2) {
		this.model = model;
		this.view = view;
		this.level2 = level2;
		// so this JPanel can listen to the keyboard
		this.setFocusable(true);
	}

	/**
	 * Draw the paddle and the ball. Pay attention to whether flipVertical is
	 * true or not.
	 */
	public void paintComponent(Graphics g) {
		if (win != true){
		super.paintComponent(g);
	    g.drawImage(model.backgroundImage, 0, 0, this);
		g.setColor(Color.BLACK);
		Font font = new Font("Courier", Font.PLAIN, 20);
        g.setFont(font);
 
        g.drawString("Level 1", 10, 20); 
		
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
		ArrayList<Brick> eBricks = model.getEnemyBricks();
		ArrayList<Brick> fBricks = model.getFriendlyBricks();
		Ball ball = model.getBall();
		

       
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
		        model.endGame();
		        win = true;
		}
		}else{
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
			}
			if (eBricks2.size() == 0) { 
		        	g.setColor(Color.RED);
			        g.setFont(new Font("SanSerif", Font.BOLD, 96));
			        g.drawString("YOU WIN!", 100, 400);
			        g.setFont(new Font("SanSerif", Font.BOLD, 25));
	    	        g.drawString("Press Escape to exit!", 200, 450);
			        model.endGame();
			}
		}
	 }
	
		
		
	}
