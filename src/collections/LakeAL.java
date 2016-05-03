//7장 실습

package collections;

import sun.java2d.loops.DrawLine;

import java.util.ArrayList;
import java.util.Iterator;
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

interface MoveDrawable extends Movable, Drawable {}

class MyRock extends MyObject implements Drawable {
    public MyRock(String name, String shape, int x, int y) {
        super(name, shape, x, y);
    }

    public void display(int x, int y) {
        if (this.x == x && this.y == y) {
            System.out.print(shape);
        }
    }
}

class MyFish extends MyObject implements MoveDrawable {
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

public class LakeAL {
    private int width;
    private int height;

    private ArrayList<MyObject> myobjects = new ArrayList<>();


    public LakeAL(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addMyObject(MyObject obj) {
    /*    if (obj instanceof Drawable) {
           myobjects.add((collections.MyObject)obj);    //업캐스팅 해야돼 뒤에다 집어넣어
       }
       if (obj instanceof Movable) {
          addMovable((Movable)obj);
        }*/

        myobjects.add(obj);  //일단 add
    }

 /*   public void addMovable(Movable m) {
        if (movables_num >= max_objects)
            return;
        movables[movables_num++] = m;
    }*/

    public void moveObjects() {
     Iterator<MyObject> it=myobjects.iterator();
        while(it.hasNext()) {
            MyObject obj = it.next();
            if (obj instanceof Movable) {

                Movable m = (Movable) obj;
                m.move(width, height);
                //((Movable)obj).move(width, height);  //위에 두줄과 같음
            }}

        }
    



    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for(MyObject obj:myobjects){

                    if(obj instanceof Drawable){
                        ((Drawable)obj).display(j,i);
                    }
                }

                System.out.print(" ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void main(String args[]) {
        LakeAL lake = new LakeAL(80, 20);
        MyFish f = new MyFish("FIsh", "<#--<", 1, 1);
        lake.addMyObject(f);
        lake.addMyObject(new MyRock("Rock", "(##)", 10, 10));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveObjects();
            lake.display();
            scanner.next();
        }
    }
}
