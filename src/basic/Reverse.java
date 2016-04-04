import java.util.Scanner;
/**
 * Created by b10529 on 2016-04-04.
 */
public class Reverse {
    public static void main(String[] args){
        String[] strArr=new String[5];
        Scanner scanner = new Scanner(System.in);
        int i;

        for(i=0;i< strArr.length;i++){
            strArr[i]=scanner.next();
        }
        for(i=strArr.length -1;i>=0;i--){
            System.out.print(strArr[i]+" ");
        }
        System.out.println();
    }
}
