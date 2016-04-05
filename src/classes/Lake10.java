import java.util.Scanner;

/**
 * Created by jyheo on 2016-04-03.
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

class Fish {
    private String name;
    private String shape;
    protected int x, y;

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

    public void move2(int width, int height) {
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
}

public class Lake {
    private int width;      //외부에서 물고기 건드릴 수 없음.
    private int height;
    private Fish[] fishes = new Fish[10];
    //private Fish fish2;

    public Lake(int width, int height) {
        this.width = width;
        this.height = height;
        //fish[10]  = new Fish();      //인자 없는 생성자
        //fish2 = new Fish("p", "<***<")
        for (int i = 0; i < fishes.length; i++) {
            if (i % 2 == 0)
                fishes[i] = new Fish("Even", "<#--<");
            else
                fishes[i] = new FoolFish("Odd", "<$--<");
        }
    }

    public void moveFish() {
        for (Fish f:fishes)
            f.move(width,height);

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
        Lake lake = new Lake(80, 20);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
    }
}
