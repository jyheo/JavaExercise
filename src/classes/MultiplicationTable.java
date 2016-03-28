//package classes;

/**
 * Created by jyheo on 2016-03-26.
 */
public class java { //public은 이 프로그램밖에 다른사람이 사용할 수 있음
    private int number;//private는 자기랑 같이 속해있는 애들만 사용할 수 있음
    private int max_number = 9;
    //private에 속해있는 애들

    //mathod에 아무것도 안써놓으면 당연히 public이 생략되어있는거
    /*mathod자리*/boolean setNumber(int num) {
        if (1 <= num && num <= max_number) {
            number = num;
            return true;
        } else {
            return false;
        }
    }

    int getNumber() { return number; }

    boolean setMaxNumber(int max_num) {
        if (9 <= max_num && max_num <= 19) {
            max_number = max_num;
            return true;
        } else {
            return false;
        }
    }

    int getMaxNumber() { return max_number; }

    void printTable() {
        for (int i = 1; i <= max_number; i++) {
            System.out.println(number + "x" + i + "=" + number * i);
        }
    }

    public static void main(String[] args) {
        java mtable = new java();

        mtable.max_number = 9; // BAD practice!
        mtable.setMaxNumber(9);
        for(int i=2;i<10;i++) {
            mtable.setNumber(i);
            mtable.printTable();
        }
    }
}

