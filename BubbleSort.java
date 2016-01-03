import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class BubbleSort extends Sort
{
    private String name = "Bubble Sort";
    public int num; 
   public BubbleSort(JLabel label)
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
            for(int i = 1; i<n; i++)
            {
                if (arr[i-1].getNum() > arr[i].getNum())
                {
                    timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                    Rect temp = arr[i]; 
                    arr[i] = arr[i-1];
                    arr[i-1] = temp; 
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
   







  