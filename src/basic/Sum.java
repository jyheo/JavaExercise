import java.util.Scanner;
public class babo{
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        double sum = 0;
        while(number.hasNext()){
            int num = number.nextInt();
            if(num == -1)
                break;
            else
                sum += num;
        }
        System.out.println("숫자들의 합 :" + sum);

    }

}
