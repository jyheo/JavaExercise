import java.util.Scanner;

public class hello{
    public static boolean iskawibawiboSwitch(String str){
        switch(str){
            case "가위":
            case "바위":
            case "보":
                return true;
            default:
                return false;
        }
    }

    /*public static boolean iskawibawiboIf(String str){
        if(str.equals("가위")||str.equals("바위")||str.equals("보"))
            return true;
        else
            return false;
    }*/
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bob>> ");
        String bob = scanner.next();
        if (!iskawibawiboSwitch(bob)) {
            System.out.println("input allowed only : 가위, 바위, 보");
            return;
        }
            System.out.print("Alice>> ");
            String alice = scanner.next();
            if (!iskawibawiboSwitch(alice)) {
                System.out.println("input allowed only : 가위, 바위, 보");
                return;

            }

            if(bob.equals("가위")){
                if(alice.equals("가위"))
                    System.out.println("Tie");
                else if(alice.equals("바위"))
                    System.out.println("alice win");
                else
                    System.out.println("bob win");
            }
            else if(bob.equals("바위")){
                if(alice.equals("가위"))
                    System.out.println("bob win");
                else if(alice.equals("보"))
                    System.out.println("alice win");
                else
                    System.out.println("bob win");
            }
            else{
                if(alice.equals("가위"))
                    System.out.println("alice win");
                else if(alice.equals("바위"))
                    System.out.println("bob win");
                else
                    System.out.println("bob win");
            }


        }
    }
