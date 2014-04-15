package EmpireUnderSiege;

import java.awt.event.*;

public class SiegeMenuController extends KeyAdapter implements ActionListener
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
		} else if (command.equals("Pause/Continue")) {
			model.setPause(! model.getPause());
		} else if (command.equals("Flip Vertically")) {
			view.setFlipVertical(! view.getFlipVertical());
		}
	}
	
	/**
	 * Handle the keyboard shortcut.
	 */
	public void keyTyped(KeyEvent event) {
		char c = event.getKeyChar();
		if (c == 'e' || c == KeyEvent.VK_ESCAPE) {
			view.dispose();
			System.exit(0);
		} else if (c == KeyEvent.VK_SPACE || c == 'p') {
			model.setPause(! model.getPause());
		} else if (c == 'f' || c == 'F') {
			view.setFlipVertical(! view.getFlipVertical());
		}
	}

}
