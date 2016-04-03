package basic;

import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
         String[] iArray = new String[4];

    Scanner a = new Scanner(System.in);

    for (int i = 0; i < iArray.length; i++) {
        iArray[i] = a.next();
    }
    for (int i = iArray.length-1; i >=0 ; i--) {
        System.out.println( iArray[i] );
    }
    }
}

