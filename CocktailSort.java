import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class CocktailSort extends Sort
{
    private String name = "Cocktail Sort";
    public int num; 
    public CocktailSort(JLabel label)
    {
        super(label);
    }
   
    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        int n = arr.length;
        boolean isSorted = false; 
                long initialTime = System.currentTimeMillis();
        while(!isSorted)
        {
            isSorted = true; 
            for(int i = 0; i<(n-2); i++)
            {
                if (arr[i].getNum() > arr[i+1].getNum())
                {
                    timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                    Rect temp = arr[i]; 
                    arr[i] = arr[i+1];
                    arr[i+1] = temp; 
                    isSorted = false;
                    num++;
                    canvas.repaint();
                    try{ Thread.sleep(6); }
                    catch(Exception e) {}
                }
            }

            if(isSorted)
            {
                break;
            }

            for(int i = n-2; i>=0; i--)
            {
                if (arr[i].getNum() > arr[i+1].getNum())
                {
                                timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                    Rect temp = arr[i]; 
                    arr[i] = arr[i+1];
                    arr[i+1] = temp; 
                    isSorted = false;
                    num++;
                    canvas.repaint();
                    try{ Thread.sleep(10); }
                    catch(Exception e) {}
                }
            }
        }
    }
    public int getNum()
    {
        return num; 
    }
    public String getName()
    {
        return name;
    }
    public String toString()
    {
     return getName();   
    }
    
}
   
