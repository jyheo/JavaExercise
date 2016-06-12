package gui;
 
 import javax.swing.*; 
 import java.awt.*; 
 import java.util.ArrayList;

 /** 
  * Created by jyheo on 2016-05-17. 
  */ 

 abstract class MyObject extends JButton { 
     protected String name; 
     protected String shape; 
     public MyObject(String name, String shape, int x, int y) { 
         super(shape); 
         setLocation(x, y); 
         setSize(70, 30); 
         setVisible(true); 
         this.name = name; 
         this.shape = shape; 
     } 
 
 
     public void new_move(int width, int height) {}; 
 } 
 
 
 class MyRock extends MyObject { 
     public MyRock(String name, String shape, int x, int y) { 
         super(name, shape, x, y); 
     } 
 } 
 
 
 class MyFish extends MyObject { 
     private int velocity_x = 10; 
     private int velocity_y = 10; 
 
 
     public MyFish(String name, String shape, int x, int y) { 
         super(name, shape, x, y); 
     } 
 
 
     public void new_move(int width, int height) { 
 // getX(), getY()        
         int x = getX(); 
         int y = getY(); 
         
  double rand = Math.random(); 
            
         if (rand < 0.5){
  x+= velocity_x;
  y+= velocity_y;
  } 
         else 
             y += 5;
         if (x + getWidth() >= width) { 
             x = width - getWidth(); 
             velocity_x = -velocity_x; 
         } else if (x <= 0) { 
             x = 0; 
             velocity_x = -velocity_x; 
         }
         if (y >= height) 
             y = 0; 
  velocity_y = -velocity_y;
 }
         setLocation(x, y); 
     } 
 }
 
 
 public class Lake_GUI extends JFrame { 
 /*private int width;
 private int height;     
 private ArrayList<MyObject> objects = new ArrayList<>(); 
 */
     public Lake_GUI(int width, int height) { 
         setTitle("Lake"); 
         setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
         getContentPane().setLayout(null); 
         setSize(width, height); 
         setVisible(true); 
     } 
 
     public void addMyObject(MyObject obj) { 
         getContentPane().add(obj); 
     } 
 
 
     public void moveObjects() { 
         for (Component com : getContentPane().getComponents()) { 
             if(com instanceof MyObject){ 
                 ((MyObject)com).new_move(getWidth(), getHeight()); 
             } 
              // getContentPane().getWidth(), getHeight()

        //for (Component c : getContentPane().getComponents()) {
        //
        //}
         } 
     } 
 
 
     public static void main(String args[]) throws InterruptedException { 
         Lake_GUI lake = new Lake_GUI(320, 240); 
         MyFish f = new MyFish("FIsh", "<#--<", 20, 20); 
         lake.addMyObject(f); 
         lake.addMyObject(new MyFish("HI", "<--<",20, 20)); 
         lake.addMyObject(new MyRock("Rock", "(##)", 100, 100)); 
 
 
         while (true) { 
             lake.moveObjects(); 
             Thread.sleep(100); 
         } 
     } 
 } 
