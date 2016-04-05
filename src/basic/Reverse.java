import java.util.Scanner;

public class Reverse{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		
		int n;
		String[] arr = new String[5];
		
		for(n=0; n<arr.length; n++){
			arr[n] = s.next();
		}
		System.out.println();
		
		for(n=arr.length-1; n>=0; n--){
			System.out.print(arr[n] + " ");
		}
		
	}
}
