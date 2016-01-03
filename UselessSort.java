import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public class UselessSort extends Sort
{
    private String name = "               Select Sort:";
    public int num; 
    public UselessSort(JLabel label)
    {
        super(label);
    }
   
    public void Sort(Rect[] arr, SorterCanvas canvas)
    {
        num++;
        canvas.repaint();
        try{ Thread.sleep(10); }
        catch(Exception e) {}
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
   
