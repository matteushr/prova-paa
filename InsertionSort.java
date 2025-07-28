
public class InsertionSort extends SortingAlgorithms {

    public InsertionSort() {
        super();
    }

    public void sort(int[] array) {

        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            movementCount++;
            int j = i - 1;

            // Move elements of array[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0 && array[j] > key) {
                comparisonCount++;
                array[j + 1] = array[j];
                movementCount++;
                j--;
            }
            array[j + 1] = key;
            movementCount++;
        }
    }

    public void complexityAnalysisReport(int arraysSize, int maxArrayRange) {
        System.out.println("Insertion Sort Complexity Analysis:");

        this.generateComplexityAnalysis(arraysSize, maxArrayRange);

    }
    
}