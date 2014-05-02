package EmpireUnderSiege;

<<<<<<< HEAD
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
	for (int i = 0; i < 7; i++)
	  {
	    Brick e = new Brick((75*i) + 50, 30);
	    eBricks.add(e);
	  }
	for(int i = 0; i < 8; i++){
		Brick e = new Brick((75*i)+25, 50);
		eBricks.add(e);
	}
	for(int i = 0; i<7; i++){
		Brick e = new Brick((75*i)+75, 70);
		eBricks.add(e);
	}
	for(int i = 0; i<7; i++){
		Brick e = new Brick((75*i)+50, 90);
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
}

public ArrayList<Brick> getEnemyBricks(){
	return eBricks;
}

public ArrayList<Brick> getFriendlyBricks(){
	return fBricks;
}
}
=======
import java.util.ArrayList;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.util.ArrayList;
//import javax.swing.JPanel;

public class Level2 extends Level //extends JPanel
{
	public Level2()
	{	
		dat = new ArrayList<CollideableObject>();
		number = 2;
		ballStart = 30;
		
		//enemy bricks
		for (int i = 0, health = 1; i < 7; i++){
			Brick e = new Brick((75*i) + 50, 30, health);
			dat.add(e);
		}
		for(int i = 0, health = 1; i < 8; i++){
			Brick e = new Brick((75*i)+25, 50, health);
			dat.add(e);
		}
		for(int i = 0, health = 1; i<7; i++){
			Brick e = new Brick((75*i)+75, 70, health);
			dat.add(e);
		}
		for(int i = 0, health = 1; i<7; i++){
			Brick e = new Brick((75*i)+50, 90, health);
			dat.add(e);
		}

		// friendly bricks
		for (int i = 0, health = 1; i < 7; i++){
			Brick e = new Brick((75*i) + 50, 700, health);
			dat.add(e);
		}
		for(int i = 0, health = 1; i < 8; i++){
			Brick e = new Brick((75*i)+25, 680, health);
			dat.add(e);
		}
	}
}
>>>>>>> Brick-Remake
