package EmpireUnderSiege;

import java.io.IOException;

import javax.swing.*;


public class EmpireUnderSiege 
{
	public static void main(String[] args) throws IOException {
		/* create new model, view and controller */
		SiegeModel model = new SiegeModel(870, 850);

		
		SiegeView view = new SiegeView(model);

		
		SiegeMouseController mouseController = 
				new SiegeMouseController(model, view);
		
		SiegeMenuController menuController = 
				new SiegeMenuController(model, view);
		
		SiegeKeyboardController keyController =
				new SiegeKeyboardController(model, view);
		
		SiegePopupController popupController = 
				new SiegePopupController(model, view);
		
		SiegeRepaintController repaintController = 
				new SiegeRepaintController(model, view);
		
		// repaint timer so that the window will update every 17 ms
	    new Timer(17, repaintController).start();
		
		/* register other controllers as listeners */
		view.registerListeners(mouseController, keyController,
				menuController, popupController);
		
		/* start it up */
		view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		view.setVisible(true);
	}
}
