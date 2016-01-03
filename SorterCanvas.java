import java.awt.*;
import java.util.ArrayList;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import java.util.Random;

public class SorterCanvas extends Canvas

{
    Rect[] array;
    int width = 600;
    int wid;
    int height = width+50;
    int realWidth = width+80;
    //ArrayList<Rectangle> rects = new ArrayList<Rectangle>();
    int red, green; 
    int max = Integer.MAX_VALUE-2;
    Random rand = new Random();
    

    
    public SorterCanvas()
    {
        setSize(realWidth,height);
        clearVals();

    }

    public void setRed(int r)
    {
        red = r;
    }

    public void setGreen(int g)
    {
        green = g;
    }

    public void clearVals()
    {
        green = max;
        red = max;
    }

    public void paint(Graphics g)
    {
        //rects.clear();
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, realWidth+20, height);
        if(array.length != 0)
            wid = (int)((realWidth/array.length));
        for (int i = 0; i<array.length; i++)
        {
            //Rectangle r = new Rectangle(10+(wid)*i,height - array[i] , wid-1, array[i]);
            array[i].setIndex(i);
            array[i].setWidth(wid);
            array[i].drawMe(g);
            //rects.add(r);
        }
    }
}
