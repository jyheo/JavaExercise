package basic;

import java.util.Scanner;

/**
 * Created by b10528 on 2016-03-14.
 */
public class source {
    public static boolean KawiBawiBoIf(String str){
        if(str.equals("가위") || str.equals("바위") || str.equals("보"))
            return true;
        else
            return false;
    }

 public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bob >> ");
        String bob = scanner.next();
        if(!KawiBawiBoIf(bob)){
            System.out.println("Input allowed only : 가위, 바위, 보");
            return;
        }
        System.out.print("Alice >> ");
        String alice = scanner.next();
        if(!KawiBawiBoIf(alice)){
            System.out.println("Input allowed only: 가위, 바위, 보");
            return;
        }
        if(bob.equals("가위")){
            if(alice.equals("가위")) {
                System.out.println("Tie!");
            }else if(alice.equals("바위")){
                System.out.println("Alice win!");
            }else{
                System.out.println("Bob win!");
            }
        }
        if(bob.equals("바위")){
            if(alice.equals("가위")) {
                System.out.println("Bob win!");
            }else if(alice.equals("바위")){
                System.out.println("Tie!");
            }else{
                System.out.println("Alice win!");
            }
        }
        if(bob.equals("보")){
            if(alice.equals("가위")) {
                System.out.println("Alice win!");
            }else if(alice.equals("바위")){
                System.out.println("Bob win!");
            }else{
                System.out.println("Tie!");
            }
        }
    }
}
