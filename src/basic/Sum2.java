import java.util.Scanner;

/**
 * Created by SAM on 2016-04-02.
 */
public class sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum=0;
        int i=0;

        while(sc.hasNext()){
            int a=sc.nextInt();
            sum+=a;
            i++;
        }
        System.out.println(i);

        System.out.println("평균: "+(double)sum/i);
    }

}
