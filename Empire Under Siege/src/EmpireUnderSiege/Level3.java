package EmpireUnderSiege;

<<<<<<< HEAD
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

=======
import java.util.ArrayList;

//import java.awt.Color;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.util.ArrayList;
//import javax.swing.JPanel;

public class Level3 extends Level
{

	public Level3()
	{	
		dat = new ArrayList<CollideableObject>();
		number = 3;
		ballStart = 0;
		
		for (int i = 0, health = 1; i < 7; i++)
		{
			Brick e = new Brick((75*i) + 50, 30, health);
			dat.add(e);;
		}
		for(int i = 0, health = 1; i < 3; i++){
			Brick e = new Brick((75*i)+25, 50, health);
			dat.add(e);;
		}
		for(int i = 0, health = 1; i<8; i++){
			Brick e = new Brick((75*i)+75, 70, health);
			dat.add(e);;
		}
		for(int i = 0, health = 1; i<2; i++){
			Brick e = new Brick((75*i)+50, 90, health);
			dat.add(e);;
		}
		for(int i = 0, health = 1; i < 3; i++){
			Brick e = new Brick((75*i)+400, 50, health);
			dat.add(e);;
		}
		for (int i = 0, health = 1; i < 2; i++){
			Brick e = new Brick((75*i)+450, 90, health);
			dat.add(e);;
		}
		for (int i = 0, health = 1; i < 8; i++){
			Brick e = new Brick((75*i)+25, 110, health);
			dat.add(e);;
		}

		// friendly bricks
		for (int i = 0, health = 1; i < 7; i++)
		{
			Brick f = new Brick((75*i) + 50, 700, health);
			dat.add(f);;
		}
		for(int i = 0, health = 1; i < 8; i++){
			Brick f = new Brick((75*i)+25, 680, health);
			dat.add(f);;
		}
		for(int i = 0, health = 1; i < 7; i++){
			Brick f = new Brick((75*i)+30, 660, health);
			dat.add(f);;
		}
		for(int i = 0, health = 1; i < 3; i++){
			Brick f = new Brick((75*i)+25, 640, health);
			dat.add(f);;
		}
		for(int i = 0, health = 1; i < 3; i++){
			Brick f = new Brick((75*i)+400, 640, health);
			dat.add(f);;
		}
	}
}
>>>>>>> Brick-Remake
