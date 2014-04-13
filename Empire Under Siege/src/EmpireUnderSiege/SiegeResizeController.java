package EmpireUnderSiege;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SiegeResizeController extends ComponentAdapter
{
	protected SiegeModel model;
	protected SiegeView view;
	
	/**
	 * @param model the model of this Siege game
	 * @param view the view of this Siege game
	 */
	public SiegeResizeController(SiegeModel model, SiegeView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Ensure that the model gets the correct size of the SiegePanel.
	 */
    public void componentResized(ComponentEvent event) {
    	Dimension size = view.getSiegePanelSize();
    	if (size.width != model.getWidth() || size.height != model.getHeight()) {
    		model.setSize(size.width, size.height);
    		view.setStatus("Size is " + size.width + " x " + size.height);
    	}
    }

}
