/**
 * Created by MINHYE on 2016-04-03.
 */

/**
 * 1. Array of Objects
 * 2. this reference
 * 3. constructor, this()
 * 4. method overloading
 * 5. garbage collection
 * 6. static method
 */
public class Set {
    private int[] array;
    private int size;
    private final int init_size = 10; // what is final? //init_size 상수선언

    public Set() {  // constructor 생성자1 //크기가 10인 array 배열 선언
        array = new int[init_size];
        size = 0;
    }

    public Set(int[] initial_set) {     // constructor 생성자2
        this();
        extendArray(initial_set.length);
        //System.arraycopy(initial_set, 0, array, 0, initial_set.length);     //initial_set배열의 0번쨰 인덱스부터 initial_set.length 개의 값을 array배열에 0번쨰 인덱스 위치로 복사
        arraycopy_1(initial_set, array);
        // TODO: add arraycopy method in class Set, and replace System.arraycopy with the arraycopy of Set.
        addElement(initial_set);

        this.size = initial_set.length;
    }

    public Set(Set s) {     // constructor 생성자3
        this();
        extendArray(s.size);
        //System.arraycopy(s.array, 0, this.array, 0, s.size);
        arraycopy_1(s.array, this.array);

        this.size = s.size;
    }

    private int[] arraycopy_1(int[] array1, int[] array2) {    //arraycopy 대신에 private method 이용하기
        for (int i = 0; i < array1.length; i++) {
            array2[i] = array1[i];
        }
        return array2;
    }

    private void extendArray(int added_length) {
        if (size + added_length > array.length) {
            int[] tmp_array = new int[size + added_length + init_size];
            //System.arraycopy(array, 0, tmp_array, 0, size);
            arraycopy_1(array, tmp_array);
            array = tmp_array;
            // where is object referenced by this.array
            // it will be garbage-collected.
        }
    }

    public boolean isMember(int a) {
        for (int i = 0; i < size; i++)
            if (array[i] == a)
                return true;
        return false;
    }

    public void addElement(int a) { // method overloading
        if (isMember(a))
            return;
        extendArray(1);
        array[size++] = a;
    }

    public void addElement(int[] array) { // method overloading
        for (int a : array)
            addElement(a);
    }

    public Set union(Set B) {
        Set C = new Set(this);
        for (int i = 0; i < B.size; i++) {
            C.addElement(B.array[i]);
        }
        return C;
    }

    public Set intersection(Set B) {
        Set C = new Set();
        for (int i = 0; i < B.size; i++) {
            if (isMember(B.array[i]))
                C.addElement(B.array[i]);
        }
        return C;
    }

    public int cardinality() {
        return size;
    }

    public void print() {
        System.out.print("{");
        for (int i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        System.out.println("}");
    }

    public static Set intersection(Set A, Set B) {
        // TODO: implement static intersection()
        Set C = new Set();
        C = A.intersection(B);

        return C;
    }

    public static void main(String[] args) {
        Set A = new Set();
        A.addElement(3);
        A.addElement(new int[]{4, 5, 6, 7, 8, 10, 13});     //A[]={3, 4, 5, 6, 7, 8, 10, 13}
        Set B = new Set(new int[]{2, 4, 5, 6, 7, 9, 10, 11, 12});
        Set C = A.union(B);
        Set D = A.intersection(B);

        Set[] sets = new Set[]{A, B, C, D}; // array of objects
        for (Set s : sets) {
            s.print();
        }

        Set X = Set.intersection(A, B);
        X.print();
    }
}

