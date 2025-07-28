import java.util.concurrent.TimeUnit;

public abstract class SortingAlgorithms implements ISortingAlgorithms {

    protected long comparisonCount;
    protected long movementCount;

    public SortingAlgorithms() {
        this.comparisonCount = 0;
        this.movementCount = 0;
    }

    @Override
    public long getComparisonCount() {
        return comparisonCount;
    }

    @Override
    public long getMovementCount() {
        return movementCount;
    }

    @Override
    public void resetCounts() {
        this.comparisonCount = 0;
    }

    private String formatDuration(long durationNano) {
        // Use TimeUnit for clear and reliable conversions.
        long hours = TimeUnit.NANOSECONDS.toHours(durationNano);
        long minutes = TimeUnit.NANOSECONDS.toMinutes(durationNano) % 60;
        long seconds = TimeUnit.NANOSECONDS.toSeconds(durationNano) % 60;
        long millis = TimeUnit.NANOSECONDS.toMillis(durationNano) % 1000;
        long micro = TimeUnit.NANOSECONDS.toMicros(durationNano) % 1000;

        StringBuilder sb = new StringBuilder();

        // Append each unit to the string only if it has a non-zero value.
        if (hours > 0) sb.append(hours).append(" hour").append(hours > 1 ? "s" : "").append(", ");
        if (minutes > 0) sb.append(minutes).append(" minute").append(minutes > 1 ? "s" : "").append(", ");
        if (seconds > 0) sb.append(seconds).append(" second").append(seconds > 1 ? "s" : "").append(", ");
        if (millis > 0) sb.append(millis).append(" ms, ");
        if (micro > 0) sb.append(micro).append(" µs, ");

        // If the string was populated, remove the trailing comma and space.
        if (sb.length() > 0) {
            return sb.substring(0, sb.length() - 2);
        } else {
            // This handles any duration less than 1 microsecond (e.g., 999 ns) and 0 ns.
            return "0 µs";
        }
    }



    @Override
    public void resetMovementCounts() {
        this.movementCount = 0;
    }

    @Override
    public abstract void sort(int[] array);

    @Override
    public void generateComplexityAnalysis(int arraysSize, int maxArrayRange) {
        System.out.println("Medium Case(Random Array): ");

        long startTime = System.nanoTime();
        sort(Arrays.generateRandomArray(arraysSize, maxArrayRange));
        long endTime = System.nanoTime();

        long totalTime = endTime - startTime;
        

        System.out.println("Comparisons: " + getComparisonCount());
        System.out.println("Movements: " + getMovementCount());
        System.out.println("Total execution time: "+ formatDuration(totalTime));
        System.out.println();
        resetCounts();
        resetMovementCounts();

        System.out.println("Best Case(Sorted Array): ");

        startTime = System.nanoTime();
        sort(Arrays.generateSortedArray(arraysSize));
        endTime = System.nanoTime();

        totalTime = endTime - startTime;

        System.out.println("Comparisons: " + getComparisonCount());
        System.out.println("Movements: " + getMovementCount());
        System.out.println("Total execution time: "+ formatDuration(totalTime));
        System.out.println();
        resetCounts();
        resetMovementCounts();

        System.out.println("Worst Case(Descending Array): ");

        startTime = System.nanoTime();
        sort(Arrays.generateDescendingArray(arraysSize));
        endTime = System.nanoTime();
        totalTime = endTime - startTime;
        System.out.println("Comparisons: " + getComparisonCount());
        System.out.println("Movements: " + getMovementCount());
        System.out.println("Total execution time: "+ formatDuration(totalTime));
        System.out.println();
        resetCounts();
        resetMovementCounts();

    }

    

    public abstract void complexityAnalysisReport(int arraysSize, int maxArrayRange);
}
