package clasees;

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
    public void move2(int width, int height){
        x++;
        y++;
        if (x >= width) //경계넘어가면
            x = 0; //다시 제자리
        if (y >= height)
            y = 0;
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
    
    private Fish[] fish = new Fish[10]; 

    public Lake(int width, int height) {
        this.width = width;
        this.height = height;

        for(int i = 0 ; i<fish.length; i++){
            fish[i] = new Fish();
        }
    }

    public void moveFish() {
        
        for (int i=0; i < fish.length; i+=2) {
            fish[i].move(width, height);
        }
        for (int i = 1; i < fish.length; i+=2) {
            fish[i].move2(width, height);
        }
    }

    public void display() {
        for (int i=0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i=0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for(int k = 0; k<fish.length; k++) {
                    fish[k].display(j, i);
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
        Lake lake = new Lake(80, 20);
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
    }
}
