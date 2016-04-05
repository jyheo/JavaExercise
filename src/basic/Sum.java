import java.util.Scanner;

/**
 * Created by SAM on 2016-04-02.
 */
public class sum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        float a =0;

        for(int i=0;i<5;i++){
            a+=sc.nextFloat();
        }

        System.out.println("평균: "+a/5);

    }

}
