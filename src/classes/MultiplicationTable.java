public class MultiplicationTable {
    private int number;
    private static int max_number = 9;

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
        if (2 <= max_num && max_num <= 9) {
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
        MultiplicationTable mtable = new MultiplicationTable();
        int n;
        mtable.setMaxNumber(9);
        for(n=2; n<=max_number; n++){
        	mtable.setNumber(n);
        	mtable.printTable();
        }
    }
}
