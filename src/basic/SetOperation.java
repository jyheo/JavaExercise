/**
 * Created by jyheo on 2016-03-22.
 */
public class babo {
    public static int[] union(int[] A, int[] B) {
        int[] Array1 = new int[A.length +  B.length-intersection(A,B).length];
        for(int i=0;i< A.length;i++){
            Array1[i] = A[i];
        }
        int a = A.length;
        boolean b = true;
        for(int i=0;i<B.length;i++){
            for(int j=0;j<A.length;j++){
                if(B[i] == A[j]) {
                    b = false;
                }
            }
            if(b == true){
                Array1[a] = B[i];
                a++;
            }
            b =true;
        }
        return Array1;
    }

    public static int[] intersection(int[] A, int[] B) {
        int c = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i] == B[i])
                    c++;
            }
        }
        int Array2[] = new int[c];
        c = 0;
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i] == B[i]){
                    Array2[c] = A[i];
                    c++;
                }
            }
        }
        return Array2;
    }

    public static void print_array(int[] A) {
        for (int x : A)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = new int[]{3, 5, 7, 8, 9};

        int[] C = intersection(A, B);
        print_array(C);

        int[] D = union(A, B);
        print_array(D);
    }

    /* execution result
        3 5
        1 2 3 4 5 7 8 9
    */
}
