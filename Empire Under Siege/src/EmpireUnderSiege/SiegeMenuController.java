package EmpireUnderSiege;

import java.awt.event.*;

public class SiegeMenuController extends KeyAdapter implements ActionListener,MouseListener, MouseMotionListener
{
	protected SiegeModel model;
	protected SiegeView view;
	
	/**
	 * @param model the model of this Siege game
	 * @param view the view of this Siege game
	 */
	public SiegeMenuController(SiegeModel model, SiegeView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Handle the menu item that was selected.
	 */
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		if (command.equals("Exit")) {
			view.dispose();
			System.exit(0);
		}
	}
	
	/**
	 * Handle the keyboard shortcut.
	 */
	public void keyTyped(KeyEvent event) {
		char c = event.getKeyChar();
		if (c == 'e' || c == KeyEvent.VK_ESCAPE) 
		{
			view.dispose();
			System.exit(0);
		}
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
