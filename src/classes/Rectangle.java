package classes;

public class Hello {
    private int x1,x2,y1,y2;

    public void setPoints(int _x1, int _y1, int _x2, int _y2) {//r1  값을 받음
      if(_x1>_x2 && _x1>0 &&_x2>0)
      {
          x2 =_x1;
          x1 =_x2;
      }
        else if (_x1<_x2&& _x1>0 &&_x2>0)
      {
          x1=_x1 ;
          x2=_x2 ;

      }
        if(_y1>_y2 && _y1>0 &&_y2>0)
        {
            y2=_y1;
            y1=_y2;
        }
        else if(_x1<_x2 && _x1>0 &&_x2>0)
        {
            y1=_y1  ;
            y2=_y2;
        }
}

    public int getWidth() {
        return (x2 - x1);
    }

    public int getHeight() {

        return (y2 - y1);
    }

    public int getArea() {

        return (x2 - x1) * (y2 - y1);
    }

    public boolean equals(Hello r) {
        if ((x1 == r.x1) && (x2 == r.x2) && (y1 == r.y1) && (y2 == r.y2))
            //인자로 받은 좌표값 r1과 r2 값이 동일한지 비교.
            return true;
        else
            return false;
    }

    public boolean in(Hello r) {
        if ((r.x1 <= x1 && x1 <= r.x2) && (r.x1 <= x2 && x2 <= r.x2) && (r.y1 <= y1 && y1 <= r.y2) && (r.y1 <= y2 && y2 <= r.y2))
            // 인자로 받은 r1 좌표값이 해당 r3 값보다 크거다 같은지 비교
            return true;
        else
            return false;
    }

    public boolean overlap(Hello r) {
        if (((x1 <= r.x1 && r.x1 <= x2) || (x1 <= r.x2 && r.x2 <= x2)) && ((y1 <= r.y1 && r.y1 <= y2) || (y1 <= r.y2 && r.y2 <= y2)))
            // 인자로 받은 좌표값 r1과 r4가 겹쳐있는지 비교
            return true;
        else
        return false;
    }

    public static void main(String[] args) {
        Hello r1 = new Hello();
        Hello r2 = new Hello();
        Hello r3 = new Hello();
        Hello r4 = new Hello();

        r1.setPoints(3,6,5,10);
        r2.setPoints(5, 5, 1, 1);
        r3.setPoints(1,1 ,5 ,5 );
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

