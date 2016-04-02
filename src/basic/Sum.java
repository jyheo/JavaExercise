import java.util.Scanner;
public class babo{
    public static void main(String[] args){
        Scanner number = new Scanner(System.in);
        double sum = 0;
        int intArray[] = new int[5];
        System.out.println("5개의 숫자 입력 : ");
        for(int i=0; i<intArray.length;i++){
            intArray[i] = number.nextInt();
        }
        for(int i=0;i<intArray.length;i++){
            sum += intArray[i];
        }
        System.out.println("숫자의 합: "+ sum);
        System.out.println("숫자의 평균 :" + sum/intArray.length);
    }
}
