package classes; 
 
  import java.util.Scanner; 

 abstract class MyObject { 
     protected String name; 
     protected String shape; 
     protected int x, y; 
     public MyObject(String name, String shape, int x, int y) { 
         this.name = name; 
         this.shape = shape; 
         this.x = x; 
         this.y = y; 
     } 
 } 

 interface Movable { 
     void move(int width, int height); 
 } 
 
 interface Drawable { 
     void display(int x, int y); 
 } 
 
 interface MoveDrawable extends Drawable, Movable{ 
     void move(int width, int height); 
     void display(int x, int y); 
 } 
 
 class MyRock extends MyObject implements  Drawable { 
     public MyRock(String name, String shape, int x, int y) { 
         super(name, shape, x, y); 
     } 
 
     public void display(int x, int y) { 
         if (this.x == x && this.y == y) { 
             System.out.print(shape); 
         } 
     } 
 } 

 class Plankon extends MyObject implements Movable, Drawable { 
     public Plankon(String name, String shape, int x, int y) { 
         super(name, shape, x, y); 
     } 

     public void move(int width, int height) { 
         double rand = Math.random(); 
         if (rand < 0.5) 
             x++; 
         else 
             y++; 
         if (x >= width) 
             x = 0; 
         if (y >= height) 
             y = 0; 
     } 
 
     public void display(int x, int y) { 
         if (this.x == x && this.y == y) { 
             System.out.print(shape); 
         } 
     } 
 } 

 class MyFish extends MyObject implements Movable, Drawable { 
     public MyFish(String name, String shape, int x, int y) { 
         super(name, shape, x, y); 
     } 

     public void move(int width, int height) { 
         double rand = Math.random(); 
         if (rand < 0.5) 
             x++; 
         else 
             y++; 
         if (x >= width) 
             x = 0; 
         if (y >= height) 
             y = 0; 
     } 

     public void display(int x, int y) { 
         if (this.x == x && this.y == y) { 
             System.out.print(shape); 
         } 
     } 
 } 

 class Diver extends MyObject implements Movable, Drawable{ 
     public Diver(String name, String shape, int x, int y) { 
         super(name, shape, x, y); 
     } 
 
     public void move(int width, int height) { 
         double rand = Math.random(); 
         if (rand < 0.5) 
             x++; 
         else 
             y++; 
         if (x >= width) 
             x = 0; 
         if (y >= height) 
             y = 0; 
     } 

     public void display(int x, int y) { 
         if (this.x == x && this.y == y) { 
             System.out.print(shape); 
         } 
     } 
 } 

 public class Lake_If { 
     private int width; 
     private int height; 
     private final int max_objects = 10; 
     private Drawable[] drawables = new Drawable[max_objects]; 
     private int drawables_num = 0; 
     private Movable[] movables = new Movable[max_objects]; 
     private int movables_num = 0; 

     public Lake_If(int width, int height) { 
         this.width = width; 
         this.height = height; 
     } 

     public void addDrawable(Drawable d) { 
         if (drawables_num >= max_objects) 
             return; 
         drawables[drawables_num++] = d; 
     } 

     public void addMovable(Movable m) { 
         if (movables_num >= max_objects) 
             return; 
         movables[movables_num++] = m; 
     } 

     public void moveFish() { 
         for (int i = 0; i < movables_num; i++) 
             movables[i].move(width, height); 
     } 

     public void display() { 
         for (int i = 0; i < width; i++) 
             System.out.print("-"); 
         System.out.println(); 
         for (int i = 0; i < height; i++) { 
             System.out.print("|"); 
             for (int j = 0; j < width; j++) { 
                 for (int d = 0; d < drawables_num; d++) 
                     drawables[d].display(j, i); 
                 System.out.print(" "); 
             } 
             System.out.println("|"); 
         } 
         for (int i = 0; i < width; i++) 
             System.out.print("-"); 
         System.out.println(); 
     } 

     public static void main(String args[]) { 
         Lake_If lake = new Lake_If(80, 20); 
         Plankon f = new Plankon("", "", 0,0 ); 
         Diver e = new Diver("Dr", "0--<",5 ,5 ); 
         MyFish g = new MyFish("Fish", "<--<",5 ,5 ); 
         lake.addDrawable(f); 
         lake.addMovable(f); 
         lake.addDrawable(e); 
         lake.addMovable(e); 
         lake.addDrawable(g); 
         lake.addMovable(g); 
 
         lake.addDrawable(new MyRock("Rock", "(##)", 10, 10)); 

         Scanner scanner = new Scanner(System.in); 
         while (true) { 
             lake.moveFish(); 
             lake.display(); 
             scanner.next(); 
         } 
     } 
  } 
