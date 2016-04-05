import java.util.Scanner;

public class babo {
    public static void main(String[] args) {
        String[] names = new String[5];
        Scanner a = new Scanner(System.in);
        for (int i = 0; i < names.length; i++) {
            names[i] = a.next();
        }
        for (int i = names.length - 1; i >= 0; i--) {
            System.out.print(names[i] + " ");
        }
        System.out.println();
    }
}
