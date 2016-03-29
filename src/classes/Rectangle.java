

public class rectangle {
    private int x1, y1, x2, y2;

    public void setPoints(int _x1, int _y1, int _x2, int _y2) {
        // TODO, check if x, y > 0


            if (_x1 > 0 && _x2 > 0 && _y1 > 0 && _y2 > 0) {
                x1 = _x1;
                y1 = _y1;
                x2 = _x2;
                y2 = _y2;
            }
        if(x2-x1>0) {
            x1 = _x1;
            x2 = _x2;
        }
        else{
            x1 = _x2;
            x2 = _x1;
        }
        if(y2-y1>0) {
            y1 = _y1;
            y2 = _y2;
        }
        else{
            y1 = _y2;
            y2 = _y1;
        }



    }

    public int getWidth() {
        // TODO

        return (x2-x1);
    }

    public int getHeight() {
        // TODO
        return (y2-y1);
    }

    public int getArea() {
        int Area = 0;
        Area = (x2-x1)*(y2-y1);
        return (Area);
    }

    public boolean equals(rectangle r) {
        if(x1 == r.x1 && y1 == r.y1 && x2 == r.x2 && y2 == r.y2)
        return true;

        return false;
    }

    public boolean in(rectangle r) {
        // TODO
        if(x1>=r.x1 && x2<=r.x2 && y1>=r.y1 && y2<=r.y2)
            return true;
        return false;
    }

    public boolean overlap(rectangle r) {
        // TODO
        if(x2>r.x1 && y2>r.y1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        rectangle r1 = new rectangle();
        rectangle r2 = new rectangle();
        rectangle r3 = new rectangle();
        rectangle r4 = new rectangle();

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
        else {
            System.out.println("false");
        }

        if (r1.in(r3)) {
            System.out.println("r1 is inside r3");
        }
        else {
            System.out.println("false");
        }
        if (r1.overlap(r4)) {
            System.out.println("r1 and r4 overlap.");
        }
        else {
            System.out.println("false");
        }
    }

}

