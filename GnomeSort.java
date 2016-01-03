import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class GnomeSort extends Sort
{
    private String name = "Gnome Sort";
    public int num; 
public GnomeSort(JLabel label)
    {
        super(label);
    }
    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
                long initialTime = System.currentTimeMillis();
        int pos = 1;
        while(pos<arr.length)
        {
            timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
            if(arr[pos].getNum() >= arr[pos-1].getNum())
            {
                pos++;
            }
            else
            {
                swap(arr, pos, pos-1);

                num++;
                canvas.repaint();
                try{ Thread.sleep(5); }
                catch(Exception e) {}
                if(pos>1)
                    pos-=1;
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

