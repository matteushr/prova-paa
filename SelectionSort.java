public class SelectionSort extends SortingAlgorithms {

    public SelectionSort() {
        super();
    }

    @Override
    public void sort(int[] array) {
        int n = array.length;

        // One by one move the boundary of the unsorted subarray
        for (int i = 0; i < n - 1; i++) {
            // Find the minimum element in the unsorted array
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comparisonCount++;
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            // A swap is considered 3 movements (temp = a, a = b, b = temp)
            if (minIndex != i) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
                movementCount += 3;
            }
        }
    }

    public void complexityAnalysisReport(int arraysSize, int maxArrayRange) {
        System.out.println("Selection Sort Complexity Analysis:");
        this.generateComplexityAnalysis(arraysSize, maxArrayRange);
    }
}