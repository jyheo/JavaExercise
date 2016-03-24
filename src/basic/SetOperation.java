package com.company;

public class Main {

    public static int[] union(int[] A, int[] B) {
        int C[] = new int[(A.length + B.length) - intersection(A, B).length];

        for(int i=0;i<A.length;i++){
            if(A[i]!=B[i]) {
                C[i] = A[i];
            }
            for(int j=A.length;j<C.length;j++) {
                if(A[i]!=B[j-A.length+intersection(A,B).length]){
                    C[j] = B[j-A.length+intersection(A,B).length];
                }
            }
        }

        return C;
    }

    public static int[] intersection(int[] A, int[] B) {

        int index=0;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if(A[i]==B[j])
                    index++;
            }
        }
        int result[] = new int[index];
        index = 0;

        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                if(A[i]==B[j]){
                    result[index]=A[i];
                    index++;
                }
            }
        }
        return result;
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


 
