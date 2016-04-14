import java.util.Scanner;

/**
 * Created by b10534 on 2016-03-14.
 */
public class jal {
    public static boolean isSwitch(String str){
        switch(str){
            case "가위":
            case "바위":
            case "보":
                return true;
            default:
                return false;
        }
    }

    public static boolean isBoIf(String str){
        if(str.equals("가위") || str.equals("바위") || str.equals("보"))
            return true;
        else
            return false;
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Boo >> ");
        String bob = scanner.next();
        if(!isBoIf(bob)){
            System.out.println("Input aloowed only : 가위, 바위, 보");
            return;
        }
        System.out.print("Alice >> ");
        String alice = scanner.next();
        if(!isBoIf(alice)){
            System.out.println("Input allowed only : 가위, 바위, 보");
            return;
        }

        if(bob.equals("가위")){
            if(alice.equals("가위"))
                System.out.println("Tie!");
            else if(alice.equals("바위"))
                System.out.println("Alice win!");
            else
                System.out.println("Bob win!");
        }
        else if(bob.equals("바위")){
            if(alice.equals("바위"))
                System.out.println("Tie!");
            else if(alice.equals("보"))
                System.out.println("Alice win!");
            else
                System.out.println("Bob win!");
        }
        else if(bob.equals("보")) {
            if (alice.equals("보"))
                System.out.println("Tie!");
            else if (alice.equals("가위"))
                System.out.println("Alice win!");
            else
                System.out.println("Bob win!");
        }

    }
}
