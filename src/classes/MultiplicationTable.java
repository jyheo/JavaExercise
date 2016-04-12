ppublic class Multiplication {


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


    int getNumber() {
        return number;
    }


    boolean setMaxNumber(int max_num) {
        if (9 <= max_num && max_num <= 19) {
            max_number = max_num;
            return true;
        } else {
            return false;
        }
    }


    int getMaxNumber() {
        return max_number;
    }


    void printTable() {
        for (int i = 2; i <= max_number; i++) {
            System.out.println(number + "x" + i + "=" + number * i);
        }
    }


    public static void main(String[] args) {
        Multiplication mtable = new Multiplication();
        for (int j = 1; j < 10; j++) {

            mtable.max_number = j;// BAD practice!
            mtable.setMaxNumber(j);

            for (int z = 1; z < 10; z++) {

                mtable.setNumber(z);

            }mtable.printTable();

        }
    }
}
