

public class Rectangle {
    private int x1, y1, x2, y2;

    public void setPoints(int _x1, int _y1, int _x2, int _y2) {
        // TODO, check if x, y > 0

        if(_x1>0 && _x2>0 && _y1 >0 && _y2>0) {
            if(_x1<_x2 && _y1<_y2){
                x1 = _x1;
                y1 = _y1;
                x2 = _x2;
                y2 = _y2;
            }
            else if(_x1>_x2 && _y1<_y2){
                x1 = _x2;
                y1 = _y1;
                x2 = _x1;
                y2 = _y2;
            }
            else if(_x1>_x2 && _y1>_y2){
                x1 = _x2;
                y1 = _y2;
                x2 = _x1;
                y2 = _y1;
            }
            else{
                x1 = _x1;
                y1 = _y2;
                x2 = _x2;
                y2 = _y1;
            }
        }
    }

    public int getWidth() {
        // 가로길이 구하기
        return Math.abs(x2-x1);
    }

    public int getHeight() {
        // 세로길이 구하기
        return Math.abs(y2-y1);
    }

    public int getArea() {
        // 넓이면적 구하기
        return this.getHeight() * this.getWidth();
    }

    public boolean equals(Rectangle r) {
        // 두 개의 사각형이 일치하는 경우
        if(x1 == r.x1 && x2 == r.x2 && y1 == r.y1 && y2 == r.y2 )
            return true;
        else
            return false;
    }

    public boolean in(Rectangle r) {
        // 한 개의 사각형안에 다른 사각형이 포함되는 경우
        if(x1 <= r.x1 && x2 <= r.x2 && y1 <= r.y1 && y2 <= r.y2 )
            return true;
        else
            return false;
    }

    public boolean overlap(Rectangle r) {
        //두 개의 사각형이 겹치는 경우
        if(x1 != r.x1 && x2 != r.x2 && y1 != r.y1 && y2 != r.y2 )
            return true;
        else
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
