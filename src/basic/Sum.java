import java.util.Scanner;
public class babo{
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        double sum = 0;
        int Num=1;
        while(number.hasNext()){
            int num = number.nextInt();
            if(num == -1)
                break;
            else
                sum += num;
            Num++ ;
        }
        System.out.println("숫자들의 합 :" + sum);
        System.out.println("숫자들의 평균 :" + sum/Num);

    }

}

