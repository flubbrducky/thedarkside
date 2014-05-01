package EmpireUnderSiege;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Level3 extends JPanel{
	
	ArrayList eBricks;
	ArrayList fBricks;
	

public Level3(){	
	eBricks = new ArrayList();
	for (int i = 0; i < 7; i++)
	  {
	    Brick e = new Brick((75*i) + 50, 30);
	    eBricks.add(e);
	  }
	for(int i = 0; i < 3; i++){
		Brick e = new Brick((75*i)+25, 50);
		eBricks.add(e);
	}
	for(int i = 0; i<8; i++){
		Brick e = new Brick((75*i)+75, 70);
		eBricks.add(e);
	}
	for(int i = 0; i<2; i++){
		Brick e = new Brick((75*i)+50, 90);
		eBricks.add(e);
	}
	for(int i = 0; i < 3; i++){
		Brick e = new Brick((75*i)+400, 50);
		eBricks.add(e);
	}
	for (int i = 0; i < 2; i++){
		Brick e = new Brick((75*i)+450, 90);
		eBricks.add(e);
	}
	for (int i = 0; i < 8; i++){
		Brick e = new Brick((75*i)+25, 110);
		eBricks.add(e);
	}
	
	fBricks = new ArrayList();
	// friendly bricks
	for (int i = 0; i < 7; i++)
	  {
	    Brick f = new Brick((75*i) + 50, 700);
	    fBricks.add(f);
	  }
	for(int i = 0; i < 8; i++){
		Brick f = new Brick((75*i)+25, 680);
		fBricks.add(f);
	}
	for(int i = 0; i < 7; i++){
		Brick f = new Brick((75*i)+30, 660);
		fBricks.add(f);
	}
	for(int i = 0; i < 3; i++){
		Brick f = new Brick((75*i)+25, 640);
		fBricks.add(f);
	}
	for(int i = 0; i < 3; i++){
		Brick f = new Brick((75*i)+400, 640);
		fBricks.add(f);
	}
}

public ArrayList<Brick> getEnemyBricks(){
	return eBricks;
}

public ArrayList<Brick> getFriendlyBricks(){
	return fBricks;
}
}

