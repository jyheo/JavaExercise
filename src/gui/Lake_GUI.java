package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
  
 -/**
 - * Created by jyheo on 2016-05-22.
 - */
 +class MyMoveRock extends MyObject {
 +    public MyMoveRock(String name, String shape, int x, int y) {
         super(name, shape, x, y);}
 +  }
  
  class MyFish2 extends MyObject {
 +    private int rand = (int)(5*Math.random()+6);
 +    private int velocity_x =  rand;
 +    private int velocity_y =  rand;
 +    boolean movement = true;
 +
 +    public MyFish2(String name, String shape, int x, int y) {super(name, shape, x, y);}
 +
 +    public void stop(){
 +        velocity_x =0;
 +        velocity_y =0;
 +        movement =false;
 +    }
 +    public void move(){
 +        velocity_x = rand;
 +        velocity_y = rand;
 +        movement = true;
 +    }
 +    public void new_move(int width, int height) {
 +        int x = getX();
 +        int y = getY();
 +
 +        double rand = Math.random();
 +        if (rand < 0.5)
 +            x += velocity_x;
 +        else
 +               y += velocity_y;
 +        if (x + getWidth() >= width) {
 +            x = width - getWidth();
 +            velocity_x = -velocity_x;
 +        } else if (x <= 0) {
 +            x = 0;
 +            velocity_x = -velocity_x;
 +        }
 +        if (y + getHeight() >= height) {
 +            y = height - getHeight();
 +            velocity_y = -velocity_y;
 +        } else if (y <= 0) {
 +            y = 0;
 +            velocity_y = -velocity_y;
 +        }
 +        setLocation(x, y);
 +    }
 +}
 +class MyFishMove extends MyObject{
      private int velocity_x = 10;
      private int velocity_y = 10;
  
 -    public MyFish2(String name, String shape, int x, int y) {
 +    public MyFishMove(String name, String shape, int x, int y) {
          super(name, shape, x, y);
 +        setSize(90,40);
      }
 -
      public void new_move(int width, int height) {
          int x = getX();
          int y = getY();
 @@ -43,6 +87,15 @@ public void new_move(int width, int height) {
      }
  }
  
 +class MyActionButtun implements Action {
 +    public void actionPerformed(ActionEvent e) {
 +        MyFish2 b = (MyFish2) e.getSource();
 +        if(b.movement)
 +            b.stop();
 +        else
 +            b.move();
 +    }
 +}
  
  public class LakeMouse extends JFrame implements Action {
  
 @@ -53,26 +106,53 @@ public LakeMouse(int width, int height) {
          setSize(width, height);
          setVisible(true);
          getContentPane().addMouseListener(new MyMouseListener());
 +        getContentPane().addKeyListener(new MyKeyListener());
  
          new javax.swing.Timer(100, this).start();
      }
  
      public void addMyObject(MyObject obj) {
          getContentPane().add(obj);
 +        if(obj instanceof MyFish2)
 +            obj.addActionListener(new MyActionListenerFishButtun());
      }
  
      public void actionPerformed(ActionEvent e) { // for Timer
          moveObjects();
 +        getContentPane().requestFocus();
      }
  
      public void moveObjects() {
          int width = getContentPane().getWidth();
 -        int height =getContentPane().getHeight();
 +        int height = getContentPane().getHeight();
  
          for (Component c : getContentPane().getComponents()) {
 -            if (c instanceof MyObject)
 -                ((MyObject)c).new_move(width, height);
 +            if (c instanceof MyFish2) {
 +                ((MyObject) c).new_move(width, height);
 +                crushTest(((MyFish2)c));
 +            }
 +            if (c instanceof MyBigFish) {
 +                ((MyObject) c).new_move(width, height);
 +            }
 +        }
 +    }
  
 +    public void crushTest(MyObject obj){
 +        for (Component c : getContentPane().getComponents()) {
 +            if(c instanceof MyMoveRock) {
 +                int x = c.getX()-obj.getX();
 +                int y = c.getY()-obj.getY();
 +                if ( (x>-60 && x<60) && ( y>-20 && y<20)) {
 +                    obj.setVisible(false);
 +                }
 +            }
 +            if(c instanceof MyBigFish) {
 +                int x = c.getX()-obj.getX();
 +                int y = c.getY()-obj.getY();
 +                if ( (x>-80 && x<80) && ( y>-30 && y<30)) {
 +                    obj.setVisible(false);
 +                }
 +            }
          }
      }
  
 @@ -84,17 +164,33 @@ public void mouseClicked(MouseEvent e) {
          }
      }
  
 +    private class MyKeyListener extends KeyAdapter{
 +        private int move_speed = 5;
 +        public void keyPressed(KeyEvent e){
 +            int keyCode = e.getKeyCode();
 +            for (Component c : getContentPane().getComponents()) {
 +                if (c instanceof MyMoveRock)
 +                    switch(keyCode){
 +                        case KeyEvent.VK_UP:
 +                            c.setLocation(c.getX(), c.getY() - move_speed );break;
 +                        case KeyEvent.VK_DOWN:
 +                            c.setLocation(c.getX(), c.getY() + move_speed);break;
 +                        case KeyEvent.VK_LEFT:
 +                            c.setLocation(c.getX() - move_speed, c.getY());break;
 +                        case KeyEvent.VK_RIGHT:
 +                            c.setLocation(c.getX() + move_speed, c.getY());break;
 +                    }
 +            }
 +
 +        }
 +
 +    }
 +
      public static void main(String args[]) throws InterruptedException {
          LakeMouse lake = new LakeMouse(320, 240);
          MyFish2 f = new MyFish2("FIsh", "<#--<", 20, 20);
          lake.addMyObject(f);
 -        lake.addMyObject(new MyRock("Rock", "(##)", 100, 100));
 -
 -        // BAD Practice! changing the state of swing components in main thread.
 -        // Do it in the event dispatching thread.
 -        //while (true) {
 -        //    lake.moveObjects();
 -        //    Thread.sleep(100);
 -        //}
 +        lake.addMyObject(new MyMoveRock("Rock", "(##)", 100, 100));
 +        lake.addMyObject(new MyBigFish("BigFish", "<#++++-< ", 130, 130));
      }
  }
