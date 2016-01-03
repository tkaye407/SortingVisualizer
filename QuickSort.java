import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class QuickSort extends Sort
{
    private String name = "Quick Sort";
    public int num; 
    long initialTime;
    public QuickSort(JLabel label)
    {
        super(label);
    }
    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        initialTime = System.currentTimeMillis();
        Sort(arr, canvas, 0, arr.length-1);
    }

    
    public void Sort(Rect[] a, SorterCanvas canvas, int start, int end)
    {
        if(start<end)
        {
            timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
            int q=partition(a, canvas, start,end);
            Sort(a, canvas, start,q);
            Sort(a, canvas, q+1,end);
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

    public int partition(Rect[] a, Canvas canvas, int start, int end) {

        int x = a[start].getNum();
        int i = start-1 ;
        int j = end+1 ;

        while (true) {
                        timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
            i++;
            while ( i< end && a[i].getNum() < x)
                i++;
            j--;
            while (j>start && a[j].getNum() > x)
                j--;

            if (i < j)
            {
                            timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                swap(a, i, j);
                //num++;
                canvas.repaint();
                try{ Thread.sleep(50); }
                catch(Exception e) {}
            }
            else
                return j;
        }

    }
    public void swap(Rect[] arr, int i, int j)
    {
        Rect temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
}

