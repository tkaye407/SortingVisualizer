import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class BogoSort extends Sort
{
    private String name = "Bogo Sort";
    public int num;
    public BogoSort(JLabel label)
    {
        super(label);
    }
   
    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
                long initialTime = System.currentTimeMillis();
        while(!isSorted(arr))
        {
          shuffle(arr); 
          timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
           num++;
        canvas.repaint();
        try{ Thread.sleep(1); }
        catch(Exception e) {}
        }
    }
    
    public void shuffle(Rect[] arr)
    {
        int i = arr.length-1;
        while(i>0)
        {
            swap(arr, i, (int)(Math.random()*(arr.length-1)));
            i--;
        }
    }
    public boolean isSorted(Rect[] arr)
    {
        for(int i = 1; i< arr.length; i++)
        {
            if(arr[i-1].getNum() > arr[i].getNum())
                return false;
                
           
        }
        return false;
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
    public void swap(Rect[] arr, int i, int j)
    {
        Rect temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }   
}