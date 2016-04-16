public class dfd {
    public static void main(String[] args) {
        int[] iArray = new int[10];
        int i = 0;
        int j = 0;
        String[] strArray = new String[]{"감", "배", "사과", "포도"};
        for (i = 0; i < iArray.length; i++) {
            iArray[i] = i * 2;
        }
        for (int k : iArray) {
            System.out.print(k + ",");
        }

        System.out.println();

        for (j = strArray.length - 1; j >= 0; j--) {
            System.out.print(strArray[j] + ",");
        }
    }
}
