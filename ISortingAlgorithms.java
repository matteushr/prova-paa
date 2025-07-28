public interface ISortingAlgorithms {

    
    long getComparisonCount();
    long getMovementCount();

    void sort(int[] array);

    void resetCounts();
    void resetMovementCounts();
    void generateComplexityAnalysis(int arraysSize, int maxArrayRange);

    void complexityAnalysisReport(int arraysSize, int maxArrayRange);
}