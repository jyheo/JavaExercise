package classes;

import java.util.Scanner;

/**
 * Created by jyheo on 2016-04-03.
 */
class Fish {
    private String name;
    private String shape;
    private int x, y;

    public Fish(String name, String shape) {
        this.name = name;
        this.shape = shape;
        x = 0;
        y = 0;
    }

    public Fish() {
        this.name = "Unknown";
        this.shape = "<--<";
        x = 0;
        y = 0;
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

    public void move1(int width, int height){
        x++;
        y++;
    }



    public void display(int x, int y) {
        if (this.x == x && this.y == y) {
            System.out.print(shape);
        }
    }
}


public class Lake {
    private int width;
    private int height;
    private Fish fish[]=new Fish[5];
    private Fish fish2[]=new Fish[5];

    public Lake(int width, int height) {
        this.width = width;
        this.height = height;
        for(int i=0;i<5;i++) {
            fish[i] = new Fish();
            fish2[i] = new Fish("p", "<***<");
        }
    }

    public void moveFish() {

        for(int i=0;i<5;i+=2) {
            fish[i].move(width, height);
            fish2[i].move(width, height);
        }
        for(int i=1;i<5;i+=2) {
            fish[i].move1(width, height);
            fish2[i].move1(width, height);
        }
    }



    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for(int a=0; a<5; a++) {
            for (int i = 0; i < height; i++) {
                System.out.print("|");
                for (int j = 0; j < width; j++) {
                    fish[a].display(j, i);
                    fish2[a].display(j, i);
                    System.out.print(" ");
                }
                System.out.println("|");
            }
        }
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void main(String args[]) {
        Lake lake = new Lake(80, 3);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
    }
}
