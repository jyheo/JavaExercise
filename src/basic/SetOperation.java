package basic;
/**
 * Created by jyheo on 2016-03-22.
 */
public class SetOperator {
    public static int[] union(int[] A, int[] B) {
        // TODO: return union of set A and B
        int[] C = new int[A.length + B.length];
        int iCnum;

        for (int i = 0; i < A.length; i++) {
            C[i] = A[i];
        }
        iCnum = A.length;

        for (int i = 0; i < B.length; i++) {

            boolean bExist = false;
            for (int j = 0; j < A.length; j++) {
                if (B[i] == A[j]) {
                    bExist = true;
                    break;
                }
            }
            if (bExist == false) {
                C[iCnum] = B[i];
                iCnum++;
            }

        }

        int[] anoC = new int[iCnum];
        for (int i = 0; i < anoC.length; i++)
            anoC[i] = C[i];

        return anoC;
    }

    public static int[] intersection(int[] A, int[] B) {
        // TODO: return intersection of set A and B
        return new int[0];
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
        print_array(C); //교집합출력

        int[] D = union(A, B);
        print_array(D); //합집합출력
    }
}
