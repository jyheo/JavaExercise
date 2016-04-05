import java.util.Scanner;

public class jh {
    public static void main(String[] args) {
        float total=0;
        int num;
        Scanner a=new Scanner(System.in);
        for(int i=0; i<5; i++){
            num=a.nextInt();
            total+=num;
        }
        System.out.print("평균"+total/5);
    }
}
