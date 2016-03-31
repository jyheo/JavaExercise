import java.util.Scanner;
/**
 * Created by b10727 on 2016-03-31.
 */
public class Hello {
    public static int getHello(String str){
        switch(str){
            case "가위":
                return 3;
            case "바위":
                return 2;
            case "보":
                return 1;
            default:
                return 0;
        }
    }
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Bob>");
        String bob = scanner.next();
        int iBob = getHello(bob);
        if(iBob==0){
            System.out.println("가위,바위,보만 입력하시오");
            return;
        }
        System.out.print("Alice>");
        String alice = scanner.next();
        int iAlice=getHello(alice);
        if(iAlice ==0){
            System.out.println("가위,바위,보만 입력하시오");
            return;
        }
        int iDet = iBob-iAlice;
        if(iDet==0){
            System.out.println("Tie!");
        }else if(iDet==-1||iDet ==2){
            System.out.println("Bob win!");
        }else{
            System.out.println("Alice win!");
        }
    }
}
