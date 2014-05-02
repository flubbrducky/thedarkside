package EmpireUnderSiege;

import java.awt.event.*;

public class SiegePopupController extends MouseAdapter
{
	protected SiegeModel model;
	protected SiegeView view;
	
	/**
	 * @param model the model of this Siege game
	 * @param view the view of this Siege game
	 */
	public SiegePopupController(SiegeModel model, SiegeView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Go back to the view object to do the pop up menu.
	 */
    public void mousePressed(MouseEvent event) { 
       view.checkForTriggerEvent(event); // check for trigger
    } // end method mousePressed

    /**
     * Go back to the view object to do the pop up menu.
     */
    public void mouseReleased(MouseEvent event) { 
       view.checkForTriggerEvent(event); // check for trigger
    } // end method mouseReleased
}