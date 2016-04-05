import java.util.Scanner;

/**
 * Created by SAM on 2016-04-02.
 */
public class sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strArray = new String[5];
        int i;


        for (i = 0; i < strArray.length; i++) {
            strArray[i] = scanner.next();
        }
        for (i = strArray.length - 1; i >= 0; i--) {
            System.out.print(strArray[i] + " ");
        }
        System.out.println();
    }
}
