package EmpireUnderSiege;

import java.awt.event.*;

public class SiegeKeyboardController implements KeyListener
{
	protected SiegeModel model;
	protected SiegeView view;
	
	public SiegeKeyboardController(SiegeModel model, SiegeView view) {
		this.model = model;
		this.view = view;
	}
	
	@Override
	public void keyTyped(KeyEvent e) 
	
	{
		//don't do anything
	}
	
	@Override
	public void keyPressed(KeyEvent e) 
	
	{
		int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) 
        {
        	model.PaddleLeft();
        }

        else if (key == KeyEvent.VK_RIGHT) 
        {
        	model.PaddleRight();
        }
        
        else if (key == KeyEvent.VK_SPACE)
        {
        	model.Pause();
        }
        
        else if (key == KeyEvent.VK_ESCAPE)
        {
        	System.exit(0);
        }
        	
        	
        else if (key == KeyEvent.VK_UP)
        {
        	model.NextLevel();
        }
        
        else if (key == KeyEvent.VK_ESCAPE)
        {
        	model.GameOver();
        }
        
	}
	
	@Override
	public void keyReleased(KeyEvent e) 
	
	{
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) 
        {
        	model.StopPaddle();
        }

        else if (key == KeyEvent.VK_RIGHT) 
        {
        	model.StopPaddle();
        }
	}
}
