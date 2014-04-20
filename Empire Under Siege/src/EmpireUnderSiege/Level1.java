package EmpireUnderSiege;

import java.awt.*;
import javax.swing.*;


public class Level1 extends JPanel {
	protected static SiegeModel model;
	protected SiegeView view;
	
	public void Level1(SiegeModel model, SiegeView siegePanel) {
		this.model = model;
		this.view = siegePanel;
		this.setFocusable(true);
	}
	public static void paintCompenent(Graphics g){	
	int brX = model.getBrickX();
    int brY = model.getBrickY();
	for (int i = 0; i < 5; i++) {
		g.setColor(Color.RED);
		g.fillRect(brX, brY, 75,10 );
		brX += 101;
	}
	brX = model.getBrickX();
	brX -= 101;
	brY+=20;
	for(int i=0; i<7; i++){
		g.setColor(Color.RED);
		g.fillRect(brX,brY, 75, 10);
		brX += 101;
		}
	brX += 50;
	brY += 20;
	for(int i = 0; i<6; i++){
		g.setColor(Color.RED);
		g.fillRect(brX,brY, 75, 10);
		brX += 101;
	}
	}

		
}

