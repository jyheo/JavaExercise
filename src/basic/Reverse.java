import java.util.Scanner;

public class jh{
    public static void main(String args[]) {
        Scanner rd = new Scanner(System.in);
        String array[] = new String[5];

        for (int i = 0; i < 5; i++) {
            array[i] = rd.next();
        }
        for(int j=4; j>=0; j--, System.out.print('\t')){
            System.out.print(array[j]);
        }

    }
}
