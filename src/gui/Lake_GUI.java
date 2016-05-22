package gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;



abstract class MyObject extends JButton {
    protected String name;
    protected String shape;
   // protected int x, y;
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

    public void setVelocity(int x, int y){
       velocity_x=x;
        velocity_y=y;
    }
    public void new_move(int width, int height) {
        // getX(), getY()
        int x=getX(), y=getY();
        double rand = Math.random();


        if (rand < 0.5)
        { x += velocity_x;}

        else
        { y+=velocity_y;}


        if (x + getWidth() >= width) {
            x = width - getWidth();
            velocity_x = -velocity_x;
        } else if (x <= 0) {
            x = 0;
            velocity_x = -velocity_x;
        }

        if (y + getHeight() >= height) {
            y = height - getHeight();
            velocity_y = -velocity_y;
        } else if (y <= 0) {
            y = 0;
            velocity_y = -velocity_y;
        }

        setLocation(x, y);
    }
}

public class Lake_GUI extends JFrame {
    //private int width;
    //private int height;
   // private ArrayList<MyObject> objects = new ArrayList<>();

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
        for (Component c : getContentPane().getComponents())
        if(c instanceof  MyObject)
            ((MyObject)c).new_move(getContentPane().getWidth(), getContentPane().getHeight());
        }




    public static void main(String args[]) throws InterruptedException {
        Lake_GUI lake = new Lake_GUI(320, 240);
        MyFish f = new MyFish("FIsh", "<#--<", 20, 20);
        MyFish f2 = new MyFish("FIsh", "<$--<", 50, 50);
        f2.setVelocity(5,5);
        lake.addMyObject(f);
        lake.addMyObject(f2);
        lake.addMyObject(new MyRock("Rock", "(##)", 100, 100));

        while (true) {
            lake.moveObjects();
            Thread.sleep(100);
        }
    }
}
