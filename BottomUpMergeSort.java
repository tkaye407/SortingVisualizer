import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class BottomUpMergeSort extends Sort
{
    private String name = "Bottom-Up Merge Sort";
    public int num; 
    long initialTime;
    public BottomUpMergeSort(JLabel label)
    {
        super(label);
    }

    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        initialTime = System.currentTimeMillis();
        Sort(arr, canvas, 0, arr.length-1);
    }

    private void merge(Rect[] a, Rect[] aux, int lo, int mid, int hi, SorterCanvas canvas)
    {
        for (int k = lo; k <= hi; k++)
        {
            aux[k] = new Rect(a[k].getNum());
            aux[k].setColor(a[k].getColor());
        }   

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if      (i > mid) a[k] = aux[j++];
            else if (j > hi)  a[k] = aux[i++];
            else if (aux[j].getNum() < aux[i].getNum()) a[k] = aux[j++];
            else                                        a[k] = aux[i++];
            try{ Thread.sleep(8); }
            catch(Exception e) {}
            timeLabel.setText("Time Elapsed (ms): "+(System.currentTimeMillis() - initialTime));
            canvas.repaint();
        }
    }

    public void Sort(Rect[] a, SorterCanvas canvas, int low, int high)
    {
        int N = a.length;
        Rect[] aux = new Rect[N];
        for (int sz = 1; sz < N; sz = sz+sz)
            for (int lo = 0; lo < N-sz; lo += sz+sz)
                merge(a, aux, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1), canvas);
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

    
 