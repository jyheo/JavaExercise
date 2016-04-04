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
        this.x = (int)(rand*80);
        this.y = (int)(rand*20);

        if (x >= width)
            x = 0;
        if (y >= height)
            y = 0;
    }
    public void move2(int width,int height){
        x++;
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

    public void setShape(String shape) {
        this.shape = shape;
    }
}

public class Lake {
    private int width;
    private int height;
    private Fish fish[] = new Fish[10];
    private Scanner scanner;

    public Lake(int width, int height) {
        this.width = width;
        this.height = height;
        scanner = new Scanner(System.in);
        for(int i=0;i<fish.length;i++){
            fish[i] = new Fish();
            fish[i].setShape(scanner.next());
        }

    }

    public void moveFish() {
        for(int i=0;i<fish.length;i++){
            if(i%2==1){
                fish[i].move(width,height);
            }
            else{
                fish[i].move2(width,height);
            }

        }
    }

    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for(int k=0;k<fish.length;k++){
                    fish[k].display(j,i);
                }
                System.out.print(" ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < width; i++) {

            System.out.print("-");
        }
    }

    public static void main(String args[]) {
        Lake lake = new Lake(80, 20);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
    }
}
