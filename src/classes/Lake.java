package classes;

import java.util.Scanner;


class Fish {
    private String name;
    private String shape;
    private int x, y; // 물고기 위치

    public Fish(String name, String shape) {
        this.name = name; //저장된 name = 인자name
        this.shape = shape;
        x = 0;
        y = 0;
    }

    public Fish()
    {
        this.name = "Unknown";
        this.shape = "<--<";
        x = 0;
        y = 0;
    }

    public void move(int width, int height) {// 물고기 이동 fish1
        double rand = Math.random();// 랜덤 함수 0~1까지 범위
        if (rand <= 0.5)
            x++;
            y++;
        if (x >= width)// 경계가 넘어서면 다시 위치로
            x = 0;
        if (y >= height)
            y = 0;
    }

    public void move2(int width, int height) {// 물고기 이동 fish2
        double rand = Math.random();// 랜덤 함수 0~1까지 범위
        if(rand<0.5)
            x++;
        else
            y++;
        if (x >= width)// 경계가 넘어서면 다시 위치로
            x = 0;
        if (y >= height)
            y = 0;
    }

    public void display(int x, int y) { // x ,y 위치에 그리기
        if (this.x == x && this.y == y) {
            System.out.print(shape);
        }
    }
    public void display2(int x, int y) { // x ,y 위치에 그리기
        if (this.x == x && this.y == y) {
            System.out.print(shape);
        }
    }
}

public class Lake {
    private int width;
    private int height;
    private Fish fish[]= new Fish[10];
    int m,n;

    public Lake(int width, int height) {
        this.width = width;
        this.height = height;

        for (m = 0; m < 10; m++) {
            fish[m] = new Fish();//인자 없는 생성자
        }
    }

    public void moveFish() {
        for(m=0;m<fish.length;m=+2) {
            fish[m].move(width, height);
        }

        for(n=1;n<fish.length;n=+2) {
            fish[n].move2(width, height);
        }
    }


    public void display() { // 호수 그림 물고기 그림
        for (int i = 0; i < width; i++)
            System.out.print("-");
        System.out.println();
        for (int i = 0; i < height; i++) {
            System.out.print("|");
            for (int j = 0; j < width; j++) {
                for(m=0;m<fish.length;m=+2) {
                    fish[m].display(j, i);
                }
                for(n=1;n<fish.length;n=+2) {
                    fish[n].display2(j, i);
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

