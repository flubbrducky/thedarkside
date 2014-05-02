package EmpireUnderSiege;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
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
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
	
		
		g.drawImage(model.backgroundImage, 0, 0, this);
		g.setColor(Color.WHITE);
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
				g.fillRect(oh.X, oh.Y, oh.SizeX, oh.SizeY);
				g.setColor(Color.BLACK);
				g.drawRect(oh.X, oh.Y, oh.SizeX - 1, oh.SizeY - 1);
				break;
			case CIRCLE:
				g.setColor(Color.RED.brighter());
				g.fillOval(oh.X-2, oh.Y-2, oh.SizeX+3, oh.SizeY+3);
				g.setColor(Color.WHITE);
				g.fillOval(oh.X, oh.Y, oh.SizeX, oh.SizeY);
				break;
			}
		}
		
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
			}
		}
		
	 }
		
}