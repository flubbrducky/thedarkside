package EmpireUnderSiege;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class SiegePanel extends JPanel {
	protected SiegeModel model;
	protected SiegeView view;

	/**
	 * Set up the instance variables and the focus.
	 * 
	 * @param model
	 *            the model of this Siege game
	 * @param view
	 *            the view of this Siege game
	 */
	public SiegePanel(SiegeModel model, SiegeView view) {
		this.model = model;
		this.view = view;

		// so this JPanel can listen to the keyboard
		this.setFocusable(true);
	}

	/**
	 * Draw the paddle and the ball. Pay attention to whether flipVertical is
	 * true or not.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.GRAY.brighter());
		
		for(CollideableObject oh : model.GetData())
		{
			g.setColor(oh.color);
			switch(oh.shape)
			{
			case RECTANGLE:	
				g.fillRect(oh.X, oh.Y, oh.SizeX, oh.SizeY);
				break;
			case CIRCLE:
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
			g.setColor(Color.RED);
		    Brick b = (Brick) eBricks.get(i);
		    b.show();
		    if (b.touches(ball))
		    {
		      ball.Vy *= -1;
		        eBricks.remove(b);
		    } else {
		    	g.fillRect(b.x, b.y, 75, 20);
		      }
		    }
		  
		g.setColor(Color.GREEN);
		// draw the friendly bricks
		for (int i = 0; i < fBricks.size(); i++)
		  {
		    Brick b = (Brick) fBricks.get(i);
		    b.show();
		    if (b.touches(ball))
		    {
		      ball.Vy *= -1;
		        fBricks.remove(b);
		    } else {
		    	g.fillRect(b.x, b.y, 75, 20);
		      }
		   }
	 }
	
		
		
	}
