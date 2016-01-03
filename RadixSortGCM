import java.io.*;
import java.awt.*;
import javax.swing.*;
public class RadixSortGCM extends Sort
{
    private String name = " Radix Sort (GCM)";
    public int num; 
    public RadixSortGCM(JLabel label)
    {
        super(label);
    }

    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        int highest = 0;
                long initialTime = System.currentTimeMillis();
        for(int a = 0; a< arr.length; a++)
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
        Sort(arr, canvas, expo, 0,  arr.length-1); 
    }

    public void Sort(Rect[] arr, SorterCanvas canvas, int ex, int low, int stop)
    {
        if(low>=stop || ex>=0)
        return;
        
        int highest = 0;
        Bucket[] buckets = new Bucket[10];
        for(int i = 0; i<10; i++)
        {
            buckets[i] = new Bucket();
            }
 
        for(int i = 0; i<stop; i++)
        {
            Rect items = arr[i];
            int  item = items.getNum();
            int buck = (item/((int)(Math.pow(10, ex))));
            buck = buck%10;
            buckets[buck].addEnd(items);
        }
        for(int j = 0; j<buckets.length; j++)
        {
            Bucket b = buckets[j];
            int index = 0;
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
        int start = 0;
        ex--;
        for(Bucket b: buckets)
        {
            Sort(arr, canvas, ex, start, start+b.getSize());
            start+=b.getSize();
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

