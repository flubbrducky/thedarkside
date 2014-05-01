package EmpireUnderSiege;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.util.ArrayList;
//import javax.swing.JPanel;

public class Level2 extends Level //extends JPanel
{
	public Level2(SiegeModel m)
	{	
		model = m;
		
		//enemy bricks
		for (int i = 0, health = 1; i < 7; i++){
			Brick e = new Brick((75*i) + 50, 30, health);
			model.data.add(e);
		}
		for(int i = 0, health = 1; i < 8; i++){
			Brick e = new Brick((75*i)+25, 50, health);
			model.data.add(e);
		}
		for(int i = 0, health = 1; i<7; i++){
			Brick e = new Brick((75*i)+75, 70, health);
			model.data.add(e);
		}
		for(int i = 0, health = 1; i<7; i++){
			Brick e = new Brick((75*i)+50, 90, health);
			model.data.add(e);
		}

		// friendly bricks
		for (int i = 0, health = 1; i < 7; i++){
			Brick e = new Brick((75*i) + 50, 700, health);
			model.data.add(e);
		}
		for(int i = 0, health = 1; i < 8; i++){
			Brick e = new Brick((75*i)+25, 680, health);
			model.data.add(e);
		}
	}
}