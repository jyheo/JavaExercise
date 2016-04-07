package classes;

import java.util.Scanner;

/**
 * Created by jyheo on 2016-04-04.
 */
class FoolFish extends Fish {
    FoolFish(String name, String shape) {
        super(name, shape);
    }

    public void move(int width, int height) {
        x++;
        y++;
        if (x >= width)
            x = 0;
        if (y >= height)
            y = 0;
    }
}

public class Lake10 {
    private int width;
    private int height;
    private Fish[] fishes;

    public Lake10(int width, int height) {
        this.width = width;
        this.height = height;
        fishes = new Fish[10];
        for (int i = 0; i < fishes.length; i++) {
            if (i % 2 == 0)
                fishes[i] = new Fish("Even", "<#--<");
            else
                fishes[i] = new FoolFish("Odd", "<$--<");
        }
    }

    public void moveFish() {
        for (Fish f : fishes)
            f.move(width, height);
    }

    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for (Fish f : fishes)
                    f.display(j, i);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void main(String args[]) {
        Lake10 lake = new Lake10(80, 20);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
        
        lake.moveFish();
    }
}
