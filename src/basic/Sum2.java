import java.util.Scanner;

public class jh {
    public static void main(String[] args) {
        float fSum = 0;
        int iNum = 0;

        Scanner a = new Scanner(System.in);

        while(a.hasNext()){
            fSum += a.nextFloat();
            iNum++;
        }
        System.out.println("평균: "+fSum / iNum);
    }
}
