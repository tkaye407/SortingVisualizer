import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class RadixInsertionSort extends Sort
{
    private String name = "Radix Sort (Insertion)";
    public int num; 
    public RadixInsertionSort(JLabel label)
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
        long initialTime = System.currentTimeMillis();
        boolean sorted = false;
        for(int i = 0; i<10; i++)
        {
            buckets[i] = new Bucket();
        }
        for(int a = 0; a< stop; a++)
        {
            int ar = arr[a].getNum();
             timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
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
                        timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
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
                timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                arr[index] = b.removeLast(); 
                index++;
                num++;
                canvas.repaint();
                try{ Thread.sleep(10); }
                catch(Exception e) {}
            }
        }
        int left;
        for (int right = 1; right<arr.length; right++)
        {
            Rect temp = arr[right];
            left = right-1;
            while(left>-1 && temp.getNum()<arr[left].getNum())
            {
                            timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                arr[left+1] = arr[left];
                left--;
                num++;
                //canvas.red = right;
                //canvas.setGreen(right);
                //canvas.setRed(left);
                canvas.repaint();
                try{ Thread.sleep(10); }
                catch(Exception e) {}
            }  
            arr[left+1] = temp;
            
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

