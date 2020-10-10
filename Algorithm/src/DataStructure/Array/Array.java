package DataStructure.Array;

public class Array {
    private int MAX_SIZE = 20;
    private int[] array = new int[MAX_SIZE];
    private int length = 0;
    private final static int ERROR = 0;
    private final static int OK = 1;

    /*
     @param:  location: where you want the element will be inserted
     @param:  element:  new element
     @return: Status code
     */

    public void insert(int location, int element) {
        if (length == MAX_SIZE)
            throw new RuntimeException("Error: DataStructure.Array.Array is full");

        if (location < 1 || location > length + 1)
            throw new RuntimeException("Error:location is illegal");

        for (int k = length - 1; k >= location - 1; k--) {
            array[k + 1] = array[k];
        }

        array[location - 1] = element;
        length++;
    }

    public int get(int location) {
        if (length == 0)
            throw new RuntimeException("DataStructure.Array.Array is empty");
        if (location < 1 || location > length)
            throw new RuntimeException("Error:location is illegal");
        return array[location];
    }

    /*
    @param:  location: where you want the element will be deleted
    @return: Status code
    */
    public void delete(int location) {
        if (length == 0)
            throw new RuntimeException("DataStructure.Array.Array is empty");

        if (location < 1 || location > length)
            throw new RuntimeException("Error:location is illegal");

        for (int k = location - 1; k <= length - 1; k++) {
            array[k] = array[k + 1];
        }
        length--;

    }

    @Override
    public String toString() {
        for (int i = 0; i < length; i++) {
            System.out.println(array[i]);
        }
        System.out.println("length= " + length);
        System.out.println("-------------------");
        return "";
    }

    public static void main(String[] args) {
        Array array = new Array();
        for (int i = 1; i <= 10; i++)
            array.insert(i, i);
        System.out.println(array);
        array.delete(5);
        array.delete(3);
        System.out.println(array);
    }
}
