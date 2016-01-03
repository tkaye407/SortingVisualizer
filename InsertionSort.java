import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class InsertionSort extends Sort
{
    private String name = "Insertion Sort";
    public int num; 
   public InsertionSort(JLabel label)
    {
        super(label);
    }
    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        int left;
                long initialTime = System.currentTimeMillis();
        for (int right = 1; right<arr.length; right++)
        {
            Rect temp = arr[right];
            left = right-1;
            while(left>-1 && temp.getNum()<arr[left].getNum())
            {
                arr[left+1] = arr[left];
                left--;
                num++;
                timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                //canvas.red = right;
                canvas.setGreen(right-1);
                canvas.setRed(left);
                canvas.repaint();
                //SoundUtils.tone(400, 2000);
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
    public void swap(Rect[] arr, int i, int j)
    {
        int temp = arr[i].getNum();
        arr[i].setNum(arr[j].getNum());
        arr[j].setNum(temp);

    }
}
   
