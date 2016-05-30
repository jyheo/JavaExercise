import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

abstract class MyObject extends JButton {
    protected String name;
    protected String shape;
    protected int x, y;
    public MyObject(String name, String shape, int x, int y) {
        super(shape);
        setLocation(x, y);
        setSize(70, 30);
        setVisible(true);
        this.name = name;
        this.shape = shape;
        this.x = x;
        this.y = y;
    }

    public void new_move(int width, int height) {};
}

class MyRock extends MyObject {
    public MyRock(String name, String shape, int x, int y) {
        super(name, shape, x, y);
    }
}

class MyFish2 extends MyObject {
    public int velocity_x = 10;
    public int velocity_y = 10;

    public MyFish2(String name, String shape, int x, int y) {
        super(name, shape, x, y);
    }

    public void new_move(int width, int height) {
        int x = getX();
        int y = getY();

        double rand = Math.random();
        if (rand < 0.5)
            x += velocity_x;
        else
            y += velocity_y;
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
class Shark extends MyObject{
    public int velocity_x = 15;
    public int velocity_y = 15;


    public Shark(String name, String shape, int x, int y) {
        super(name, shape, x, y);
        setSize(140, 60);
    }
    public void new_move(int width, int height) {
        int x = getX();
        int y = getY();

        double rand = Math.random();
        if (rand < 0.5)
            x += velocity_x;
        else
            y += velocity_y;
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


public class LakeMouse extends JFrame implements ActionListener {

    public LakeMouse(int width, int height) {
        setTitle("Lake");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setSize(width, height);
        setVisible(true);
        getContentPane().addMouseListener(new MyMouseListener());
        getContentPane().requestFocus();
        getContentPane().addKeyListener(new MyKeyListener());
        new javax.swing.Timer(100, this).start();
    }


    public void addMyObject(MyObject obj) {
        getContentPane().add(obj);
        if(obj instanceof MyFish2)
            obj.addActionListener(new MyActionListenerFish());
        if(obj instanceof Shark)
            obj.addActionListener(new MyActionListenerShark());
    }

    public void actionPerformed(ActionEvent e) { // for Timer
        moveObjects();
        getContentPane().requestFocus();
    }

    public void moveObjects() {
        int width = getContentPane().getWidth();
        int height = getContentPane().getHeight();

        for (Component c : getContentPane().getComponents()) {
            if (c instanceof MyObject) {
                ((MyObject) c).new_move(width, height);
                if(c instanceof MyFish2 && removeObject(c))
                    getContentPane().remove(c);
            }
        }
    }
    public boolean removeObject(Component obj) {
        for (Component c : getContentPane().getComponents()) {
            if (c instanceof Shark || c instanceof MyRock) {
                if ((obj.getX() == c.getX()) && (obj.getY() == c.getY()))
                    return true;
            }
        }
        return false;
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            MyFish2 f = new MyFish2("FIsh", "<#--<", e.getX(), e.getY());
            int speed = (int)((Math.random()*6)+5);
            f.velocity_x = speed;
            f.velocity_y = speed;
            addMyObject(f);
        }
    }


    private class MyKeyListener extends KeyAdapter{
        public final int move_x = 5;
        public final int move_y = 5;
        public void keyPressed(KeyEvent e){
            int keyCode = e.getKeyCode();
            for (Component c : getContentPane().getComponents()) {
                if (c instanceof MyRock){
                    switch(keyCode){
                        case KeyEvent.VK_LEFT:
                            c.setLocation(c.getX() - move_x, c.getY());
                            break;
                        case KeyEvent.VK_RIGHT:
                            c.setLocation(c.getX() + move_x, c.getY());
                            break;
                        case KeyEvent.VK_UP:
                            c.setLocation(c.getX(), c.getY() - move_y);
                            break;
                        case KeyEvent.VK_DOWN:
                            c.setLocation(c.getX(), c.getY() + move_y);
                    }
                }
            }

        }
    }

    public static void main(String args[]) throws InterruptedException {
        LakeMouse lake = new LakeMouse(320, 240);
        MyFish2 f = new MyFish2("FIsh", "<#--<", 20, 20);
        lake.addMyObject(f);
        lake.addMyObject(new MyRock("Rock", "(##)", 100, 100));
        lake.addMyObject(new Shark("shark", " <%>==<", 50, 50));
    }
}
class MyActionListenerFish implements ActionListener{
    public int temp_x;
    public int temp_y;
    public void actionPerformed(ActionEvent e){
        MyFish2 obj = (MyFish2) e.getSource();
        if(obj.velocity_x > 0){
            temp_x = obj.velocity_x;
            temp_y = obj.velocity_y;
            obj.velocity_x = 0;
            obj.velocity_y = 0;
        }
        else{
            obj.velocity_x = this.temp_x;
            obj.velocity_y = this.temp_y;
        }
    }
}
class MyActionListenerShark implements ActionListener{
    public int temp_x;
    public int temp_y;
    public void actionPerformed(ActionEvent e){
        Shark obj = (Shark) e.getSource();
        if(obj.velocity_x > 0){
            temp_x = obj.velocity_x;
            temp_y = obj.velocity_y;
            obj.velocity_x = 0;
            obj.velocity_y = 0;
        }
        else{
            obj.velocity_x = this.temp_x;
            obj.velocity_y = this.temp_y;
        }
    }
}
