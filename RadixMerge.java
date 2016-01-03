import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class RadixMerge extends Sort
{
    private String name = "Radix Sort (Merge)";
    public int num; 
    public RadixMerge(JLabel label)
    {
        super(label);
    }

    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        Sort(arr, canvas, arr.length-1); 
    }

    public void Sort(Rect[] arr, SorterCanvas canvas, int stop)
    {
        int highest = 0;
        Bucket[] buckets = new Bucket[10];

        boolean sorted = false;
        for(int i = 0; i<10; i++)
        {
            buckets[i] = new Bucket();
        }
        for(int a = 0; a< stop; a++)
        {
            int ar = arr[a].getNum();
            if(ar>highest)
            {
                highest = ar; 
            }
        }
        int expo = 0;
        boolean done = false;
        while(!done)
        {
            highest = highest/10;
            expo++;
            if(highest<=0)
                done = true;
        }
        expo--;
        sorted = true;
        for(int i = 0; i<stop; i++)
        {
            Rect items = arr[i];
           int  item = items.getNum();
            int buck = (item/((int)(Math.pow(10, expo))));
            buck = buck%10;
            buckets[buck].addEnd(items);
        }
        
        int index = 0;
        for(int j = 0; j<buckets.length; j++)
        {
            Bucket b = buckets[j];
            while(b.isFilled())
            {
                arr[index] = b.removeLast(); 
                index++;
                num++;
                canvas.repaint();
                try{ Thread.sleep(10); }
                catch(Exception e) {}
            }
        }
        MergeSort m = new MergeSort(timeLabel);
        m.Sort(arr, canvas);
        
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

