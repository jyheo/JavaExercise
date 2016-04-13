public class Rectangle {
    private int x1, y1, x2, y2;

    public void setPoints(int _x1, int _y1, int _x2, int _y2) {
        if(_x1>0 && _y1>0 && _x2>0 && _y2>0) {
            x1 = _x1;
            y1 = _y1;
            x2 = _x2;
            y2 = _y2;
        }
    }

    public int getWidth() {
        int width;
        width=((x2>x1)?(x2-x1):(x1-x2));
        return width;
    }

    public int getHeight() {
        int height;
        height=((y2>y1)?(y2-y1):(y1-y2));
        return height;
    }

    public int getArea() {
        return getWidth()*getHeight();
    }

    public boolean equals(Rectangle r) {
        if(this.getArea()==r.getArea())
            if((this.x1==r.x1||this.x1==r.x2)&&(this.y1==r.y1||this.y1==r.y2))
                return true;
        return false;
    }

    public boolean in(Rectangle r) {//this가 r내부에 위치
        if(this.getArea()<=r.getArea()) {
            if (r.x1 <= r.x2) {
                if ((this.x1 <= r.x1) && (this.x2 <= r.x2) && (this.y1 <= r.y1) && (this.y2 <= r.y2))
                    return true;
            } else {
                if ((this.x1 <= r.x1) && (this.x2 <= r.x2) && (this.y1 <= r.y1) && (this.y2 <= r.y2))
                    return true;
            }
        }
        return false;
    }

    public boolean overlap(Rectangle r) {
        if (((this.x1 <= r.x1 && r.x1 <= this.x2) || (this.x1 <= r.x2 && r.x2 <= this.x2)) && ((this.y1 <= r.y1 && r.y1 <= this.y2) || (this.y1 <= r.y2 && r.y2 <= this.y2)))
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
