//package classes;

public class Rectangle {
    private int x1, y1, x2, y2;

    public void setPoints(int _x1, int _y1, int _x2, int _y2) {
        // TODO, check if x, y > 0

        int x; int y;
        if(_x1>0 &&_y1>0 &&_x2>0 &&_y2>0)
        {
        x1 = _x1;
        y1 = _y1;
        x2 = _x2;
        y2 = _y2;}

    }

    public int getWidth() {
        int Width;
        if(x1>=x2)
        Width=x1-x2;

        else
        Width=x2-x1;
        // TODO
        return Width;
    }

    public int getHeight() {
        int Height;
        if(y1>=y2)
            Height=y1-y2;

        else
            Height=y2-y1;
        // TODO
        return Height;
    }

    public int getArea() {

        int Area;

        Area=(getHeight()*getWidth());
        // TODO
        return Area;
    }

    public boolean equals(Rectangle r) {

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        Rectangle r3 = new Rectangle();
        Rectangle r4 = new Rectangle();

        r1.setPoints(1, 1, 5, 5);
        r2.setPoints(5, 5, 1, 1);
        r3.setPoints(1, 1, 6, 6);
        r4.setPoints(3, 3, 7, 8);

        if(r1.getWidth()==r2.getWidth() && r1.getHeight()==r2.getHeight()){
            return true;
        }// TODO
        else return false;
    }

    public boolean in(Rectangle r) {

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        Rectangle r3 = new Rectangle();
        Rectangle r4 = new Rectangle();

        r1.setPoints(1, 1, 5, 5);
        r2.setPoints(5, 5, 1, 1);
        r3.setPoints(1, 1, 6, 6);
        r4.setPoints(3, 3, 7, 8);

        if(r1.getWidth()< r3.getWidth() && r1.getHeight()< r3.getHeight()){
            return true;
        }
        // if(r1.get)
        // TODO
        else return false;
    }

    public boolean overlap(Rectangle r) {

        Rectangle r1 = new Rectangle();
        Rectangle r2 = new Rectangle();
        Rectangle r3 = new Rectangle();
        Rectangle r4 = new Rectangle();

        r1.setPoints(1, 1, 5, 5);
        r2.setPoints(5, 5, 1, 1);
        r3.setPoints(1, 1, 6, 6);
        r4.setPoints(3, 3, 7, 8);

        if(r1.getWidth()<= r4.getWidth() && r1.getHeight()<= r4.getHeight()){
            return true;
        }
        else if(r1.getWidth()> r4.getWidth() && r1.getHeight()> r4.getHeight()){
            return true;
        }
        // TODO
        else return false;
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

