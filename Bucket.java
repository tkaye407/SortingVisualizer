import java.util.ArrayList;
public class Bucket
{
    ArrayList<Rect> list  = new ArrayList<Rect>();
    public Bucket()
    {
        
    }
    
    public boolean isFilled()
    {
        if(list.size()>0)
        {
            return true;
        }
        return false;
    }
    
    public Rect getFirst()
    {
  
            return list.get(0);
       
    }
    
    public void addEnd(Rect r)
    {
        
        list.add(r);
        
    }
    
    public Rect removeLast()
    {
        Rect i = getFirst();
        list.remove(0);
        return i;
        
    }
    
    public int getSize()
    {
        return list.size();
    }
    
    
}