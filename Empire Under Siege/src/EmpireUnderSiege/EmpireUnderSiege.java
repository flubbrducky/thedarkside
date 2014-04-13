package EmpireUnderSiege;

import javax.swing.*;


public class EmpireUnderSiege 
{
	public static void main(String[] args) {
		/* create new model, view and controller */
		SiegeModel model = new SiegeModel();
		SiegeView view = new SiegeView(model);
		SiegeMouseController mouseController = 
				new SiegeMouseController(model, view);
		SiegeResizeController resizeController = 
				new SiegeResizeController(model, view);
		SiegeMenuController menuController = 
				new SiegeMenuController(model, view);
		SiegePopupController popupController = 
				new SiegePopupController(model, view);
		SiegeRepaintController repaintController = 
				new SiegeRepaintController(model, view);
		
		// repaint timer so that the window will update every 25 ms
	    new Timer(25, repaintController).start();
		
		/* register other controllers as listeners */
		view.registerListeners(mouseController, resizeController,
				menuController, popupController);
		
		/* start it up */
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setSize(400, 300);
		view.setVisible(true);
	}
}
