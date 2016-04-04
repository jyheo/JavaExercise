import java.util.Scanner;

/**
 * Created by b10534 on 2016-03-15.
 */
public class ja {
    private int x1, y1, x2, y2;

    public void setPoints(int _x1, int _y1, int _x2, int _y2) {
        if(_x1>0 && _x2>0 && _y1>0 && _y2>0) {
            x1 = _x1;
            y1 = _y1;
            x2 = _x2;
            y2 = _y2;
        }

    }

    public int getWidth() {
        int width;

        width=(x2>=x1)?(x2-x1):(x1-x2);

        return width;
    }

    public int getHeight() {
        int height;

        height=(y2>=y1)?(y2-y1):(y1-y2);

        return height;
    }

    public int getArea() {
        int width=(x2>=x1)?(x2-x1):(x1-x2);
        int height=(y2>=y1)?(y2-y1):(y1-y2);
        int area;

        area=width*height;

        return area;
    }

    public boolean equals(ja r) {

        if((this.x1 == r.x1 || this.x1 == r.x2) && (this.x2 == r.x2 || this.x2 == r.x1) && (this.y1 == r.y1 || this.y1 == r.y2) && (this.y2 == r.y2 || this.y2 == r.y1)){

            return true;
        }
        else{
            return false;
        }

    }

    public boolean in(ja r) {
        if(this.x1<=r.x1){
            if(this.x2>=r.x2){
                if(this.y1<=r.y1){  // 높이
                    if(this.y2>=r.y2){
                        return true;
                    }
                    else return false;
                }
                else if(this.y1<=r.y2){  // 높이
                    if(this.y2>=r.y1){
                        return true;
                    }
                    else return false;
                }
                else return false;
            }
            else return false;

        }
        else if(this.x1<=r.x2){
            if(this.x2>=r.x1){
                if(this.y1<=r.y1){  // 높이
                    if(this.y2>=r.y2){
                        return true;
                    }
                    else return false;
                }
                else if(this.y1<=r.y2){  // 높이
                    if(this.y2>=r.y1){
                        return true;
                    }
                    else return false;
                }
                else return false;
            }
            else return false;
        }
        else return false;

    }

    public boolean overlap(ja r) {
        if(this.x1<=r.x1){
            if(this.x2>=r.x2){
                if(this.y1<=r.y1){  // 높이
                    if(this.y2>=r.y2){
                        return false;
                    }
                    else return true;
                }
                else if(this.y1<=r.y2){  // 높이
                    if(this.y2>=r.y1){
                        return false;
                    }
                    else return true;
                }
                else return true;
            }
            else return true;

        }
        else if(this.x1<=r.x2){
            if(this.x2>=r.x1){
                if(this.y1<=r.y1){  // 높이
                    if(this.y2>=r.y2){
                        return false;
                    }
                    else return true;
                }
                else if(this.y1<=r.y2){  // 높이
                    if(this.y2>=r.y1){
                        return false;
                    }
                    else return true;
                }
                else return true;
            }
            else return true;
        }
        else return true;

    }

    public static void main(String[] args) {
        ja r1 = new ja();
        ja r2 = new ja();
        ja r3 = new ja();
        ja r4 = new ja();

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
