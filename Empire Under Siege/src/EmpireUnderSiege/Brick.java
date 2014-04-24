package EmpireUnderSiege;

import java.awt.Rectangle;
import java.awt.Stroke;

class Brick
{
  int x, y;
  
  Brick(int ex, int why)
  {
    this.x = ex;
    this.y = why;

  }
   
  void show()
  {
    Rectangle rectangle = new Rectangle(x, y, 75, 20);
  }

   
  boolean touches(Ball b)
  {
    float p1 = x;
    float p2 = x + 75;
    if (((b.Y + b.SIZE) >= y) && ((b.Y + b.SIZE) <= y + 20))
    {
      if ((b.X >= p1) && (b.X <= p2))
      {
        return true;
      }
      else
      {
        return false;
      }
    }
    else
    {
      return false;
    }
  
   }
     
}
