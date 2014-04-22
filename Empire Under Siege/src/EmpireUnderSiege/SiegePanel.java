package EmpireUnderSiege;

import java.awt.*;

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
		int x = (int) model.getPaddleX();
		int y = (int) model.getPaddleY();
		if (view.getFlipVertical()) {
			y = view.translateY(y) - model.getPaddleHeight();
		}
		g.fillRect(x, y, model.getPaddleWidth(), model.getPaddleHeight());
		g.setColor(Color.RED);
		x = (int) model.getBallX();
		y = (int) model.getBallY();
		if (view.getFlipVertical()) {
			y = view.translateY(y) - model.getBallDiameter();
		}

		g.fillOval(x, y, model.getBallDiameter(), model.getBallDiameter());
		
		int brX = model.getBrickX() - 75;
	    int brY = model.getBrickY();
	    
		for (int i = 0; i < 8; i++) {
			g.setColor(Color.RED);
			g.fillRect(brX, brY, model.brickWidth,model.brickHeight);
			brX += 76;
		}
		brX = model.getBrickX();
		brX -= 101;
		brY+=20;
		for(int i=0; i<9; i++){
			g.setColor(Color.RED);
			g.fillRect(brX,brY, model.brickWidth, model.brickHeight);
			brX += 76;
			}
		brX = model.getBrickX() - 75;
		brY += 20;
		for(int i = 0; i<8; i++){
			g.setColor(Color.RED);
			g.fillRect(brX,brY, model.brickWidth, model.brickHeight);
			brX += 76;
		}
		brX = model.getBrickX();
		brX -= 101;
		brY+=20;
		for(int i=0; i<9; i++){
			g.setColor(Color.RED);
			g.fillRect(brX,brY, model.brickWidth, model.brickHeight);
			brX += 76;
			}

	}
}
