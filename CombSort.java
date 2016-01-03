import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class CombSort extends Sort
{
    private String name = "Comb Sort";
    public int num; 
    public CombSort(JLabel label)
    {
        super(label);
    }

    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        int gap = arr.length;
        boolean swapped = true;
                long initialTime = System.currentTimeMillis();
        while (gap > 1 || swapped) {
            timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
            if (gap > 1) {
                gap = (int) (gap / 1.3);
            }
            swapped = false;
            for (int i = 0; i + gap < arr.length; i++) {
                if (arr[i].getNum() > (arr[i + gap].getNum()) ){
                                timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
                    swap(arr, i, i+gap);
                    num++;
                    canvas.repaint();
                    try{ Thread.sleep(20); }
                    catch(Exception e) {}
                    swapped = true;
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


