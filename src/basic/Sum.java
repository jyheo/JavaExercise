import java.util.Scanner;

public class A1 {
    public static void main(String[] args){
        float num;
        Scanner a= new Scanner(System.in);
        System.out.println("다섯개의 숫자를 입력하세요");
         num=a.nextFloat();
        num+=a.nextFloat();
        num+=a.nextFloat();
        num+=a.nextFloat();
        num+=a.nextFloat();
        System.out.println("모든값의 합의 평균은"+num/5+"입니다");
    }
}
