public class SetOperation {
    public static int[] union(int[] A, int[] B) {
    	int[] C = new int[A.length + B.length];
        int n;

        for(int i=0; i<A.length; i++) {
            C[i] = A[i];
        }
        n = A.length;

        for(int i=0; i<B.length; i++) {

            boolean TF = false;
            
            for(int j=0; j<A.length; j++) {
                if(B[i] == A[j]) {
                    TF = true;
                    break;
                }
            }
            if(TF == false) {
                C[n] = B[i];
                n++;
            }

        }

        int[] RC = new int[n];
        for(int i = 0; i < RC.length; i++)
            RC[i] = C[i];

        return RC;
    }

    public static int[] intersection(int[] A, int[] B) {
    	int[] D = new int[A.length];
    	 int n=0;
    	 	
         for (int i=0; i<B.length; i++) {

             boolean TF = false;
             
             for (int j=0; j<A.length; j++) {
                 if(B[i] == A[j]) {
                     TF = true;
                     break;
                 }
             }
             if (TF == true) {
                 D[n] = B[i];
                 n++;
             }

         }

         int[] RD = new int[n];
         for (int i = 0; i < RD.length; i++)
             RD[i] = D[i];
    	return RD;
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
}
