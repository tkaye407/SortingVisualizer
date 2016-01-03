import java.awt.*;
import java.io.*;
import javax.swing.JLabel;
public class SelectionSort extends Sort
{
    private String name = "Selection Sort";
    public int num;
    
    public SelectionSort(JLabel label)
    {
        super(label);
    }
    
    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        long initialTime = System.currentTimeMillis();
        for (int left = 0; left<arr.length; left++)
        {
            for(int right = left+1; right<arr.length; right++)
            {
                timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                Rect temp2 = arr[right];
                if (arr[left].getNum()>temp2.getNum())
                {
                    Rect temporary = arr[left];
                    arr[left] = temp2; 
                    arr[right] = temporary; 
                    num++;
                    try{ Thread.sleep(10); }
                    catch(Exception e) {}    
                    canvas.repaint();
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
    public void swap(Rect[] arr, int i, int j)
    {
        Rect temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}
   