import java.util.Scanner;

class Fish {
    private String name; // 물고기 이름
    private String shape; // 물고기 모양
    private int x, y; // 물고기의 위치

    public Fish(String name, String shape) { // 이름하고 모양을 받음.
        this.name = name; // this << 자기 자신 객체를 나타냄, 즉 this.name의 name은 객체, = name의 name은 들어온 변수?
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

    public void move(int width, int height) { // 물고기 이동 , 매개변수는 호수의 가로,세로 크기
        double rand = Math.random(); // random함수 : 0~1까지 실수를 랜덤으로 내보냄.
        if (rand < 0.5)
            x++;
        else
            y++;
        if (x >= width) // 크기 밖을 넘어가면 0으로 초기화
            x = 0;
        if (y >= height)
            y = 0;
    }


    public void display(int x, int y) { // 물고기 모양을 화면에 그림
        if (this.x == x && this.y == y) {
            System.out.print(shape);
        }
    }
}

public class Lake { // 물고기를 가지고있는 호수
    private int width;
    private int height;
    private Fish[] fish = new Fish[10];

    public Lake(int width, int height) { // 호수 생성

        this.width = width;
        this.height = height;

        for(int n=0; n<fish.length; n++){
            fish[n] = new Fish(); // 물고기 이름 p , 생김새 ..
        }
    }

    public void moveFish() { // 여기 바꾸고
        int n;
        for(n=0; n<10; n++) {
            fish[n].move(width, height);
        }
        // fish.move(width, height);
    }

    public void display() {

        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                int n=0;
                while(n<10) {
                    fish[n].display(j, i);
                    n++;
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
        Lake lake = new Lake(80, 20);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            lake.moveFish();
            lake.display();
            scanner.next();
        }
    }
}

어제
