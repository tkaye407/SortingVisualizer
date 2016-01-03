import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class MergeSort extends Sort
{
    private String name = "Merge Sort";
    public int num; 
    long initialTime;
    public MergeSort(JLabel label)
    {
        super(label);
    }

    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        initialTime = System.currentTimeMillis();
        Sort(arr, canvas, 0, arr.length-1);
    }

    public void Sort(Rect[] arr, SorterCanvas canvas, int low, int high)
    {
        if (low >= high)
            return;
        int mid = (int)((low+high)/2);
        Sort(arr, canvas, low, mid);
        Sort(arr, canvas, mid+1, high);

        while(low <=mid && mid+1<= high)
        {
            if (arr[mid+1].getNum()>arr[low].getNum())
            {
                low++;
            }   
            else
            {
                Rect temp = arr[mid+1];
                for (int test = mid; test>=low; test--)
                {
                    arr[test+1] = arr[test];
                    num++;
                    timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                    canvas.repaint();
                    
                    try{ Thread.sleep(3); }
                    catch(Exception e) {}
                }
                arr[low] = temp;
                mid++;
                low++;
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

    
 