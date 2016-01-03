import java.io.*;
import java.awt.*;
import javax.swing.JLabel;
public abstract class Sort
{
    public JLabel timeLabel;
    public Sort(JLabel l)
    {
        timeLabel = l;
    }
    
    public abstract String getName();
    public abstract void Sort(Rect[] arr, SorterCanvas canvas);
    public abstract String toString();
    public abstract int getNum();
    
}
