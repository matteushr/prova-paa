public class Main {
    public static void main(String[] args) {
        
        int arraysSize = 1000000; // Size of the array for complexity analysis
        int maxArrayRange = 1000000; //  Maximum value in the array

        SortingAlgorithms insertionSort = new InsertionSort();
        SortingAlgorithms selectionSort = new SelectionSort();
        SortingAlgorithms shellSort = new ShellSort();
        SortingAlgorithms heapSort = new HeapSort();

        System.out.println("List size: "+ arraysSize);

        insertionSort.complexityAnalysisReport(arraysSize, maxArrayRange);
        selectionSort.complexityAnalysisReport(arraysSize, maxArrayRange);
        shellSort.complexityAnalysisReport(arraysSize, maxArrayRange);
        heapSort.complexityAnalysisReport(arraysSize, maxArrayRange);


    }
}
