import java.awt.*;
import java.util.ArrayList;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Rect 
{
    Color c; 
    int num;
    Rectangle r;
    int x, y, width;
    int index;
     //int width = 600;
    int height = 600+50;
    int realWidth =680;
    
    public Rect(int len)
    {
      num = len;
    }
    public Rect(int x, int y, int width)
    {
        r = new Rectangle(x, y, width, num);
    }
    
    public void setWidth(int wid)
    {
       width = wid;    
    }
    public int getIndex()
    {
        return index;
        
    }
    public void setIndex(int i)
    {
        index = i;
    }
    
    public int getNum()
    {
        return num;
    }
    public void setNum(int n)
    {
        num = n;
    }
    public void setColor(Color co)
    {
        c = co;
    }
    public Color getColor()
    {
        return c;
    }
    public void drawMe(Graphics g)
    {
        g.setColor(getColor());
        Rectangle r = new Rectangle(10+(width)*getIndex()+40,height - getNum() , width-1, getNum());
        g.fillRect(r.x, r.y, (int)r.getWidth(), (int)r.getHeight());
    }
}