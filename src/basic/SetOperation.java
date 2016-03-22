package com.company;

public class Main {
    public static int[] union(int[] A, int[] B) {
        int result[] = new int[A.length + B.length - intersection(A, B).length];//결과를 저장할 배열선언
        //결과 배열에 A배열 값 저장
        for (int i = 0; i < A.length; i++) {
            result[i] = A[i];
        }
        int index = A.length;//인덱스에 A배열 길이를 할당
        boolean inter = true;//교집합 여부 확인을 위한 boolean
        //결과 배열에 B배열 값 저장
        for (int i = 0; i < B.length; i++) {
            for (int j = 0; j < A.length; j++) {
                /*교집합이 발견될 경우 inter에 false를 할당*/
                if (B[i] == A[j]) {
                    inter = false;
                }
            }
            /*inter 가 true일때 즉 교집합이 아닌경우 결과배열에 B배열 값 저장 */
            if (inter == true) {
                result[index] = B[i];
                index++;
            }
            inter = true;//inter를 다시 true로 할당
        }
        return result;
    }

    public static int[] intersection(int[] A, int[] B) {

        int index = 0;//index
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {//만약 A B의 교집합이 발견될경우
                    index++;//몇개의 index가 필요한지 갯수 저장
                }
            }
        }
        int result[] = new int[index];//결과를 저장할 배열선언
        index = 0;//인덱스 초기화
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                if (A[i] == B[j]) {//만약 A B의 교집합이 발견될경우
                    result[index] = A[i];//결과 배열에 교집합 값 저장
                    index++;//인덱스 증가
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

    /* execution result
        3 5
        1 2 3 4 5 7 8 9
    */
}
