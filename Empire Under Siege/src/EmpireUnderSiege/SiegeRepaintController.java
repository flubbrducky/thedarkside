package EmpireUnderSiege;

import java.awt.event.*;

public class SiegeRepaintController implements ActionListener
{
	protected SiegeModel model;
	protected SiegeView view;
	
	/**
	 * @param model the model of this Siege game
	 * @param view the view of this Siege game
	 */
	public SiegeRepaintController(SiegeModel model, SiegeView view) {
		this.model = model;
		this.view = view;
	}
	
	/**
	 * Perform the needed actions when the timer goes off.
	 * When the timer goes off, move the ball to its next position,
	 * determine if the number of hits or misses changed,
	 * and repaint the window.
	 */
	public void actionPerformed(ActionEvent event) 
	{
		if(!model.pause)
		{
			model.moveModel();
			view.repaint();
		}
	}
}
