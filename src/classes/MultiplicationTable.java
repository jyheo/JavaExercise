import java.util.Scanner;

/**
 * Created by b10534 on 2016-03-15.
 */
public class jal {
    private int number;
    private int max_number = 9;

    boolean setNumber(int num) {
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
        jal mtable = new jal();
        int i;

        mtable.max_number = 9; // BAD practice!
        mtable.setMaxNumber(9);

        for(i=2;i<10;i++){
            mtable.setNumber(i);
            mtable.printTable();
        }

    }
}
