package collections;

import sun.java2d.loops.DrawLine;

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
    //private final int max_objects = 10;
    //private ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    //private Movable[] movables = new Movable[max_objects];


    private ArrayList<MyObject> myobjects = new ArrayList<>();


    //private int movables_num = 0;

    public LakeAL(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void addMyObject(MyObject obj) {
        myobjects.add(obj);  // 나눈거 합침
    }


    public void moveObjects() {
        Iterator<MyObject> it = myobjects.iterator();  // 이터레이터 -> 넥스트, 해즈넥스트, 리무브    따라서 리무브 쓸거면 이터레이터 쓰고 아니면 for문 쓰는게 좋음
        while(it.hasNext()){
            MyObject obj = it.next();
            if(obj instanceof Movable){
                ((Movable)obj).move(width, height);  // Movalbe m = (Movable)obj;  m.move(w, h);  주석으로 쓰는 것도 괜찮지만 한문장으로 쓰는게 더 일반적
            }
        }
        /*
        for(MyObject obj : myobjects){
            if(obj instanceof Movable){
                ((Movable)obj).move(width, height);  // Movalbe m = (Movable)obj;  m.move(w, h);
        }
         위와 같은 내용임
         */

    }

    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for(MyObject obj : myobjects){
                    if(obj instanceof Drawable){
                        Drawable d = (Drawable)obj;  // -> ((Drawable)obj).display(j, i); 가 더 일반적이다
                        d.display(j, i);
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
