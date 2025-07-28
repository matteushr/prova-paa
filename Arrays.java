public class Arrays {
    
    public static int[] generateRandomArray(int size, int maxValue) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = (int) (Math.random() * maxValue); // Random numbers between 0 and 999
        }
        return array;
    }

    public static int[] generateDescendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i; // Descending order
        }
        return array;
        
    }

    //Half of the array will be unsorted
    public static int[] generateNearlySortedArray(int size) {

        int[] array = new int[size];
        for (int i = 0; i < size / 2; i++) {
            array[i] = i; // First half sorted
        }
        for (int i = size / 2; i < size; i++) {
            array[i] = (int) (Math.random() * size); // Second half random
        }
        return array;
    }

    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i; // Sorted order
        }
        return array;
    }

}
