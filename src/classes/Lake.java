
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
    private Fish[] fish=new Fish[10];
    //private Fish fish2;

    public Lake(int width, int height) {
        this.width = width;
        this.height = height;
        //fish[10]  = new Fish();      //인자 없는 생성자
        //fish2 = new Fish("p", "<***<")
        for(int i=0;i<10;i++) {
            fish[i] = new Fish();
        }
    }

    public void moveFish() {
        for(int m = 0; m < 10; m++){
            if(m%2==1)
                fish[m].move(width, height);
            else
                fish[m].move2(width, height);
        }   //물고기 이동시키기
        //fish2.mov0e(width, height);
    }

    public void display() {
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for(int m=0;m<10;m++){      //추가부분
                    fish[m].display(j, i);
                }
                //fish2.display(j, i);
                System.out.print(" ");
            }
            System.out.println("|");
        }
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
    }

    public static void main(String args[]) {
        Lake lake = new Lake(80, 10);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
    }
}
