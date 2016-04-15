package classes;
import java.util.Scanner;
public class Rectangle {
    private int x1, y1, x2, y2;

    public void setPoints(int _x1, int _y1, int _x2, int _y2) {
        if(_x1<=0||_y1<=0||_x2<=0||_y2<=0) {
            System.out.println("다시입력");
            Scanner aaa = new Scanner(System.in);
            x1 = aaa.nextInt();
            y1 = aaa.nextInt();
            x2 = aaa.nextInt();
            y2 = aaa.nextInt();
        }
        if(_x1<_x2) {
            x1 = _x2;
            x2 = _x1;
        }
        else if(_x1>_x2){
            x1 = _x1;
            x2 = _x2;
        }
        if(_y1<_y2) {
            y1 = _y2;
            y2 = _y1;
        }
        else if(_y1>_y2){
            y1 = _y1;
            y2 = _y2;
        }
    }
    public int getWidth() {
        return (x1-x2);
    }
    public int getHeight() {
        return (y1-y2);
           }
    public int getArea() {
        return (x1-x2)*(y1-y2);


    }
    public boolean equals(Rectangle r) {
        if((r.x1==x1)&&(r.x2==x2)&&(r.y1==y1)&&(r.y2==y2))
            return true;
        return false;
    }
    public boolean in(Rectangle r) {
        if((r.x1>=x1&&x1>=r.x2) && (r.x1>=x2&&x2>=r.x2) && (r.y1>=y1&&y1>=r.y2) && (r.y1>=y2&&y2>=r.y2))
            return true;
        return false;
    }
    public boolean overlap(Rectangle r) {
        if(((x1<r.x1)&&(x2<r.x2))||((y2<r.y1)&&(y2<r.y2)))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        Rectangle r3 = new Rectangle();
        Rectangle r4 = new Rectangle();

        r1.setPoints(1, 1, 5, 5);
        r2.setPoints(5, 5, 1, 1);
        r3.setPoints(1, 1, 6, 6);
        r4.setPoints(3, 3, 7, 8);

        System.out.println(r1.getWidth());
        System.out.println(r1.getHeight());
        System.out.println(r1.getArea());

        if (r1.equals(r2)) {
            System.out.println("r1 equals r2");
        }
        if (r1.in(r3)) {
            System.out.println("r1 is inside r3");
        }
        if (r1.overlap(r4)) {
            System.out.println("r1 and r4 overlap.");
        }
    }

}
