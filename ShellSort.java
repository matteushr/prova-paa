public class ShellSort extends SortingAlgorithms {

    public ShellSort() {
        super();
    }

    @Override
    public void sort(int[] array) {
        int n = array.length;

        // Start with a large gap, then reduce the gap
        for (int gap = n / 2; gap > 0; gap /= 2) {
            // Perform a gapped insertion sort for this gap size.
            // The first gap elements a[0..gap-1] are already in gapped order
            // so we can start at i = gap.
            for (int i = gap; i < n; i++) {
                // Save array[i] in temp and make a hole at position i
                int temp = array[i];
                movementCount++;
                int j;

                // Shift earlier gapped elements up until the correct location for a[i] is found
                for (j = i; j >= gap; j -= gap) {
                    comparisonCount++;
                    if (array[j - gap] > temp) {
                        array[j] = array[j - gap];
                        movementCount++;
                    } else {
                        break; // Found the correct spot
                    }
                }
                
                // Put temp (the original a[i]) in its correct location
                array[j] = temp;
                movementCount++;
            }
        }
    }

    public void complexityAnalysisReport(int arraysSize, int maxArrayRange) {
        System.out.println("Shell Sort Complexity Analysis:");
        this.generateComplexityAnalysis(arraysSize, maxArrayRange);
    }
}