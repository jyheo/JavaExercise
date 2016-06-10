package classes;

/**
 * Created by mamazz on 2016-06-
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
    private final int init_size = 10; // what is final?
    private int[] ArrayCopy(int a[],int[] b){
        for(int i=0; i<a.length; i++){
            b[i]=a[i];
        }
        return b;
    }
    public Set() {  // constructor
        array = new int[init_size];
        size = 0;
    }

    public Set(int[] initial_set) {
        this();
        extendArray(initial_set.length);
        System.arraycopy(initial_set, 0, array, 0, initial_set.length);
        this.size = initial_set.length;
    }

   public Set(int[] initial_set) {
        this();
        extendArray(initial_set.length);
        //ArrayCopy(initial_set,array);
        //System.arraycopy(initial_set, 0, array, 0, initial_set.length);
        addElement(initial_set);
        this.size = initial_set.length;
    }

    public Set(Set s) {
        this();
        extendArray(s.size);
        ArrayCopy(s.array, this.array);
        // TODO: add arraycopy method in class Set, and replace System.arraycopy with the arraycopy of Set.
        this.size = s.size;
    }
    
    private void extendArray(int added_length) {
        if (size + added_length > array.length) {
            int[] tmp_array = new int[size + added_length + init_size];
            ArrayCopy(array,tmp_array);
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
         Set set = new Set();
         Set C = A.intersection(B);
         return C;
    }

    public static void main(String[] args) {
         Set A = new Set();
         A.addElement(3);
         A.addElement(new int[]{4, 5, 6, 7, 8, 10, 13});
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
