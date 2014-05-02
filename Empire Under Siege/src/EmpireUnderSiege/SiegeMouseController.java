package EmpireUnderSiege;

import java.awt.event.*;

public class SiegeMouseController implements MouseListener
{
	protected SiegeModel model;
	protected SiegeView view;
	
	/**
	 * @param model the model of this Siege game
	 * @param view the view of this Siege game
	 */
	public SiegeMouseController(SiegeModel model, SiegeView view) {
		this.model = model;
		this.view = view;
	}
	
	/*
	 * MouseListener event handlers
	 */ 

	/**
	 * Go back to view for possible popup menu.
	 */
	public void mouseClicked(MouseEvent event) {
		view.checkForTriggerEvent(event);
	} // end method mouseClicked

	/**
	 * Go back to view for possible popup menu.
	 */
	public void mousePressed(MouseEvent event) {
		view.checkForTriggerEvent(event);
	} // end method mousePressed

	/**
	 * nothing to do for mouse release
	 */
	public void mouseReleased(MouseEvent event) {

	} // end method mouseReleased

	/**
	 * clear status bar
	 */
	public void mouseEntered(MouseEvent event) {
		view.setStatus("");
	} // end method mouseEntered

	/**
	 * does nothing
	 */
	public void mouseExited(MouseEvent event) {
	} // end method mouseExited

}