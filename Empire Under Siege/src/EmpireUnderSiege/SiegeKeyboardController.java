package EmpireUnderSiege;

import java.awt.event.*;

public class SiegeKeyboardController implements KeyListener
{
	protected SiegeModel model;
	protected SiegeView view;
	protected boolean movin;
	
	@Override
	public void keyTyped(KeyEvent e) 
	
	{
		if(1==1); //key == spacebar
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	
	{
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) 
        {
        	model.setPaddle(model.setPaddle(model.paddleX - model.paddleSpeed), model.paddleY);
        }

        else if (key == KeyEvent.VK_RIGHT) 
        {
        	model.setPaddle(model.setPaddle(model.paddleX + model.paddleSpeed), model.paddleY);
        }
        
        else if (key == KeyEvent.VK_SPACE)
        {
        	model.pause = (!model.pause);
        }
        
        else if (key == KeyEvent.VK_UP)
        {
        	model.gotThePower();
        }
        
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	
	{
		//don't do sheet
	}
}
