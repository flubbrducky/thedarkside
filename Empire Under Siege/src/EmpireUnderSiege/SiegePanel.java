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
        g.drawString("Level 1", 10, 20); 
		
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
				g.setColor(Color.RED.brighter());
				g.fillOval(oh.X-2, oh.Y-2, oh.SizeX+3, oh.SizeY+3);
				g.setColor(Color.WHITE);
				g.fillOval(oh.X, oh.Y, oh.SizeX, oh.SizeY);
				break;
			}
		}

	 }
	
		
		
}