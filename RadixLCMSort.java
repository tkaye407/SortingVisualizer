import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class RadixLCMSort extends Sort
{
    private String name = "Radix Sort (LCM)";
    public int num; 
    public RadixLCMSort(JLabel label)
    {
        super(label);
    }
   
    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        Bucket[] buckets = new Bucket[10];
        long initialTime = System.currentTimeMillis();
        timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
        int expo = 1; 
        boolean sorted = false;
        for(int i = 0; i<10; i++)
        {
            buckets[i] = new Bucket();
        }
        while(!sorted)
        {
              timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
            sorted = true;
            for(Rect items: arr)
            {
                            timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                int item = items.getNum();
                int buck = (item / expo) % 10;
                if(buck>0)
                    sorted = false;
                buckets[buck].addEnd(items);
            }
            expo *=10;
            int index = 0;
            for(Bucket b: buckets)
            {
                timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                while(b.isFilled())
                {
                    timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                    arr[index] = b.removeLast(); 
                    index++;
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
   
