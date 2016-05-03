package methods;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by jyheo on 2016-05-01.
 */
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
    private final int max_objects = 10;
    private static ArrayList<MyObject> myobjects = new ArrayList<MyObject>();
    private int movables_num = 0;

    public LakeAL(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addMyObject(MyObject obj) {
        if (obj instanceof Drawable) {
           myobjects.add(obj);
           //myobjects.getClass().getInterfaces();
           //drawables.add((Drawable)obj);
           //myobjects.getClass().getInterfaces();
        }
        if (obj instanceof Movable) {
            addMovable((Movable)obj);
           // myobjects.getClass().getInterfaces();
        }
    }

    public void addMovable(Movable m) {
        if (movables_num >= max_objects)
            return;
        //myobjects.add((MyObject)m);
        movables_num++;
       
        
    }

    public void moveObjects() {
        for (int i = 0; i < movables_num; i++)
            ((Movable) myobjects.get(i)).move(width, height);
    }

    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                Iterator<MyObject> it = myobjects.iterator();
                while (it.hasNext()) {
                   Drawable d = (Drawable)it.next();
                    d.display(j, i);
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
        lake.addMyObject(f); //myobjects 의 ArrayList 에 추가 됨.
        lake.addMyObject(new MyRock("Rock", "(##)", 10, 10));
       
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveObjects();
            lake.display();
            scanner.next();
        }
    }
}
