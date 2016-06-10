import java.util.Scanner;

/**
 * Created by b10521 on 2016-03-14.
 */
public class KawiBawiBo{

    public static boolean isKawiBawiBoSwitch(String str) {
                switch (str) {
                        case "가위":
                        case "바위":
                        case "보":
                                return true;
                        default:
                                return false;
                    }
            }


          public static boolean isKawiBawiBoIf(String str) {
                if (str.equals("가위") || str.equals("바위") || str.equals("보"))
                     return true;
               else
                    return false;
                 // this if statement can be simplified such as
                 // return (str.equals("가위") || str.equals("바위") || str.equals("보"));
            }


            public static void main(String args[]) {
                 Scanner scanner = new Scanner(System.in);


                System.out.print("Bob >> ");
                String bob = scanner.next();
                if (!isKawiBawiBoSwitch(bob)) {
                    System.out.println("Input allowed only : 가위, 바위, 보");
                     return;
                 }
                 System.out.print("Alice >> ");
                 String alice = scanner.next();
                 if (!isKawiBawiBoIf(alice)) {
                     System.out.println("Input allowed only : 가위, 바위, 보");
                     return;
                }

             if(bob.equals("가위")) {
                 if (alice.equals("가위")) {
                     System.out.println("Tie!");
                 }
                 if (alice.equals("바위")) {
                     System.out.println("Alice win!");
                 }
                 if (alice.equals("보")) {
                     System.out.println("Bob win!");
                 }
             };
                if(bob.equals("바위")) {
                    if (alice.equals("가위")) {
                        System.out.println("Bob win!");
                    }
                    if (alice.equals("바위")) {
                        System.out.println("Tie!");
                    }
                    if (alice.equals("보")) {
                        System.out.println("Alice win!");
                    }
                }; if(bob.equals("보")) {
                    if (alice.equals("가위")) {
                        System.out.println("Alice win!");
                    }
                    if (alice.equals("바위")) {
                        System.out.println("Bob win!");
                    }
                    if (alice.equals("보")) {
                        System.out.println("Tie!");
                    }
                };

              


                 

             }
         }
