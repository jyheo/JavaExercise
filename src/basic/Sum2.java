import java.util.Scanner;
/**
 * Created by 유오재 on 2016-03-31.
 */
public class A2 {
    public static void main(String[] args){
        float a=0;
        int b=0;
        Scanner aaa = new Scanner(System.in);
        while(aaa.hasNextInt()){
            a += aaa.nextFloat();
            b++;
        }
        System.out.println("입력된값의 평균은"+a/b+"입니다");
    }
}
