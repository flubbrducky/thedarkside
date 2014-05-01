package EmpireUnderSiege;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Level2 extends JPanel{
	
	ArrayList eBricks;
	ArrayList fBricks;
	

public Level2(){	
	eBricks = new ArrayList();
	for (int i = 0; i < 6; i++)
	  {
	    Brick e = new Brick((75*i) + 50, 30);
	    eBricks.add(e);
	  }
	for(int i = 0; i < 8; i++){
		Brick e = new Brick((75*i)+50, 100);
		eBricks.add(e);
	}
	for(int i = 0; i<5; i++){
		Brick e = new Brick((75*i)+50, 170);
		eBricks.add(e);
	}
	
	fBricks = new ArrayList();
	// friendly bricks
	for (int i = 0; i < 6; i++)
	  {
	    Brick f = new Brick((75*i) + 50, 700);
	    fBricks.add(f);
	  }
	for(int i = 0; i < 8; i++){
		Brick f = new Brick((75*i)+50, 620);
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
