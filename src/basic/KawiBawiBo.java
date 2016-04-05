import java.util.Scanner;

/**
 * Created by jyheo on 2016-03-10.
 */
public class jh {
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
        if(bob.equals("가위")){
            if(alice.equals("보"))
                System.out.println("Bob win!");
            else if(alice.equals("가위"))
                System.out.println("Tie!");
            else
                System.out.println("Alice win!");

        }
        else if("bob"=="바위"){
            if("alice"=="보")
                System.out.println("Alice win!");
            else if("alice"=="가위")
                System.out.println("Bob win!");
            else
                System.out.println("Tie!");
        }

        else{
            if("alice"=="보")
                System.out.println("Tie!");
            else if("alice"=="가위")
                System.out.println("Alice win!");
            else
                System.out.println("Bob win!");

        }



        System.out.println("Alice win!");
        System.out.println("Bob win!");
        System.out.println("Tie!");
    }
}

