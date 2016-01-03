import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class OddEvenSort extends Sort
{
    private String name = "Odd-Even Sort";
    public int num; 
    public OddEvenSort(JLabel label)
    {
        super(label);
    }

    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        boolean sorted = false;
                long initialTime = System.currentTimeMillis();
        while(!sorted)
        {
            timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
            sorted=true;
            for(int i = 1; i < arr.length-1; i += 2)
            {
                if(arr[i].getNum() > arr[i+1].getNum())
                {
                                timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                    swap(arr, i, i+1);
                    num++;
                    canvas.repaint();
                    try{ Thread.sleep(3); }
                    catch(Exception e) {}
                    sorted = false;
                }
            }

            for(int i = 0; i < arr.length-1; i += 2)
            {
                if(arr[i].getNum() > arr[i+1].getNum())
                {
                                timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                    swap(arr, i, i+1);
                    num++;
                    canvas.repaint();
                    try{ Thread.sleep(10); }
                    catch(Exception e) {}
                    sorted = false;
                }
            }
        }

    }

    public int getNum()
    {
        return num; 
    }

    public void swap(Rect[] arr, int i, int j)
    {
        Rect temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

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

