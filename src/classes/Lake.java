import java.util.Scanner;

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

    public void move2(int width, int height){
        x++;
        y++;
        if(x>=width)
            x=0;
        if(y>=height)
            y=0;
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
    private Fish []fish;

    public Lake(int width, int height) {
        this.width = width;
        this.height = height;
        for(int i=0; i<10; i++){
            fish[i]=new Fish();
        }
       // fish = new Fish();
        //fish2 = new Fish("p", "<***<");
    }

    public void moveFish() {
        for(int k=0; k<10; k++){
            if(k%2==1)
                fish[k].move(width, height);
             else
                fish[k].move2(width, height);
        }//물고기 움직임임

    }

    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for(int k=0; k<10; k++){
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
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
    }
}
