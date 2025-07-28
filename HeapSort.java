public class HeapSort extends SortingAlgorithms {

    public HeapSort() {
        super();
    }

    @Override
    public void sort(int[] array) {
        int n = array.length;

        // 1. Build a max heap from the array
        // Start from the last non-leaf node and move up to the root
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        // 2. One by one, extract elements from the heap
        for (int i = n - 1; i > 0; i--) {
            // Move the current root (max element) to the end of the array
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            movementCount += 3; // A swap is 3 movements

            // Call max heapify on the reduced heap (size i)
            heapify(array, i, 0);
        }
    }

    /**
     * To heapify a subtree rooted with node i which is an index in array[].
     * n is the size of the heap.
     */
    private void heapify(int[] array, int n, int i) {
        int largest = i;       // Initialize largest as root
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;

        // If left child is larger than root
        if (leftChild < n) {
            comparisonCount++;
            if (array[leftChild] > array[largest]) {
                largest = leftChild;
            }
        }

        // If right child is larger than the current largest
        if (rightChild < n) {
            comparisonCount++;
            if (array[rightChild] > array[largest]) {
                largest = rightChild;
            }
        }

        // If the largest element is not the root
        if (largest != i) {
            // Swap the root with the largest element
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            movementCount += 3;

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
    }

    public void complexityAnalysisReport(int arraysSize, int maxArrayRange) {
        System.out.println("Heap Sort Complexity Analysis:");
        this.generateComplexityAnalysis(arraysSize, maxArrayRange);
    }
}