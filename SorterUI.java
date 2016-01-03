import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import java.util.Random;

public class SorterUI
{
    Rect[] array;
    Random rand = new Random();

    Color[] colors = {
            Color.RED, Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,Color.RED,
            Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,Color.ORANGE,
            Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,Color.YELLOW,
            Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,Color.GREEN,
            Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,Color.BLUE,
            //Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN, Color.CYAN, 
            Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,Color.MAGENTA,
        };
    //Color.PINK, Color.PINK, Color.PINK, Color.PINK, Color.PINK, Color.PINK, Color.PINK, Color.PINK, Color.PINK, Color.PINK };

    //Color[] colors = {Color.RED, Color.ORANGE,Color.YELLOW,Color.GREEN,Color.BLUE, Color.CYAN, 
    //Color.CYAN, Color.MAGENTA,Color.PINK };
    //Sort currSort;
    JLabel Time = new JLabel("            Time Since Start: "); //time since sort
    Sort useless = new UselessSort(Time);;
    Sort s1 = new InsertionSort(Time);
    Sort s2 = new SelectionSort(Time);
    Sort s3 = new CocktailSort(Time);
    Sort s4 = new BubbleSort(Time);
    Sort s5 = new MergeSort(Time);
    Sort s52 = new BottomUpMergeSort(Time);
    Sort s6 = new RadixLCMSort(Time);
    //Sort s7 = new RadixSortGCM(Time);
    Sort s8 = new QuickSort(Time);
    Sort s9 = new OddEvenSort(Time);
    Sort s10 = new GnomeSort(Time);
    Sort s11 = new BogoSort(Time);
    Sort s12 = new RadixInsertionSort(Time);
    Sort s13 = new RadixMerge(Time);
    Sort s14 = new CombSort(Time);
    Sort currSort = s2;
   
    Sort[] sorts = {useless, s1, s2, s3, s4, s5, s52, s6, s8, s9, s10, s11, s12, s13, s14};
    SorterCanvas canvas = new SorterCanvas();
    long initialTime;
    long time;

    JLabel Name = new JLabel("                Sort: " + currSort);  //sortname

    JLabel Number = new JLabel("         Number of Values: 100" );  //number of values
    JButton restartButton = new JButton("Generate Random Array");
    JButton startButton = new JButton("Sort");
    JFrame frame = new JFrame("Sorter");
    JPanel topPanel = new JPanel();
    JPanel thePanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JComboBox combo = new JComboBox(sorts);

    public static void main(String[] args)
    {
        SorterUI sui = new SorterUI();
    }

    public SorterUI()
    {
        array = new Rect[100];
        canvas.array = this.array;

        combo.addItemListener(new ItemListener(){
                public void itemStateChanged(ItemEvent e){

                    if(e.getStateChange()==ItemEvent.SELECTED){
                        //System.out.println("HIHIHIH");//Do what ever you want :))
                        currSort = (Sort)e.getItem(); 

                        //System.out.println(e.getItem());
                        //System.out.println("done");
                    }
                }
            });

        restartButton.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    generateRandArray();
                }
            }
        );

        startButton.addActionListener( new ActionListener()
            {
                public void actionPerformed(ActionEvent e)
                {
                    sort();
                }
            }
        );

        
        generateRandArray();

        //restartButton.addActionListener(this);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,700);

        topPanel.setLayout( new GridLayout(1,1) );
        topPanel.add(canvas);

        thePanel.setLayout( new BorderLayout() );

        bottomPanel.setLayout(new GridLayout(2,3));
        bottomPanel.add(combo);
        bottomPanel.add(restartButton);
        bottomPanel.add(startButton);
        bottomPanel.add(Name);
        bottomPanel.add(Time);
        bottomPanel.add(Number);

        thePanel.add(topPanel, BorderLayout.CENTER);
        thePanel.add(bottomPanel, BorderLayout.SOUTH);

        frame.add(thePanel);
        frame.setFocusable(true);
        frame.requestFocusInWindow();

        frame.setVisible(true);
        //frame.addKeyListener(this);
        //restartButton.addActionListener(this);

    }

    public void generateRandArray()
    {
        int index = 0;
        for(int i = 0; i<100; i++)
        {
            Color c = selectColor(index);
            index++;

            array[i] = new Rect(getRand(580, 50));
            array[i].setColor(c);
        }
        canvas.repaint();
    }

    public int getRand(int range, int low)
    {
        int n = (int)((Math.random()*range)+low);
        return n;
    }

    public void repaint()
    {
        canvas.repaint();
    }

    public void sort()
    {
        initialTime = System.currentTimeMillis();
        //System.out.println(initialTime);
        Thread t = new Thread(new Runnable()
                { 
                    public void run()
                    { 

                        currSort.Sort(array, canvas); 

                    }
                });
        t.start();

        //System.out.println("Sorted");
        canvas.repaint();
    }

    public Color selectColor(int index)
    {
        //int rand = (int)(Math.random()*colors.length);
        Color c; 
        if(index == 0)
        {
            c=new Color(
                170 + rand.nextInt(80),
                20 + rand.nextInt(100),
                20 + rand.nextInt(100),
                20 + rand.nextInt(100));
        }
        else if(index ==1)
        {
            c=new Color(
                20 + rand.nextInt(100),
                170 + rand.nextInt(80),
                20 + rand.nextInt(100),
                20 + rand.nextInt(100));
        }
        else if(index == 2)
        {
            c=new Color(
                20 + rand.nextInt(100),
                20 + rand.nextInt(100),
                170 + rand.nextInt(80),
                20 + rand.nextInt(100));
        }
        else 
        {
            c=new Color(
                20 + rand.nextInt(100),
                20 + rand.nextInt(100),
                20 + rand.nextInt(100),
                170 + rand.nextInt(80));
        }
        index = index%(colors.length-1);
        // return c;
        return colors[index];

    }
}
