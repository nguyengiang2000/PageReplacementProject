import java.util.LinkedList;

/**
 * The LRU class implements the Least Recently Used (LRU) page replacement algorithm.
 * It tracks page hits, faults, and the total number of pages processed.
 */
public class LRU implements ReplacementAlgorithm {
    private int hit;
    private int fault;
    private int total;

    /**
     * Constructs a new LRU page replacement algorithm with hit, fault, and total counters set to zero.
     */
    public LRU() {
        this.hit = 0;
        this.fault = 0;
        this.total = 0;
    }

    /**
     * Runs the LRU page replacement algorithm on the given list of pages.
     *
     * @param list the array of pages to be processed
     * @param page the maximum number of pages that can be held in memory at one time
     */
    @Override
    public void run(int[] list, int page) {
        total = list.length;
        LinkedList<Integer> usageList = new LinkedList<>();

        for (int i : list) {
            if (usageList.contains(i)) {
                hit++;
                // Move the accessed page to the head of the list
                usageList.remove((Integer) i);
                usageList.addFirst(i);
            } else {
                fault++;
                if (usageList.size() >= page) {
                    // Remove the least recently used item (the last node)
                    usageList.removeLast();
                }
                // Add the new page to the head of the list
                usageList.addFirst(i);
            }
        }
    }

    /**
     * Returns the number of page hits.
     *
     * @return the number of page hits
     */
    @Override
    public int getHit() {
        return this.hit;
    }

    /**
     * Returns the number of page faults.
     *
     * @return the number of page faults
     */
    @Override
    public int getFault() {
        return this.fault;
    }

    /**
     * Returns the total number of pages processed.
     *
     * @return the total number of pages processed
     */
    @Override
    public int getTotal() {
        return this.total;
    }

    /**
     * Resets the hit, fault, and total counters to zero.
     */
    @Override
    public void reset() {
        this.hit = 0;
        this.fault = 0;
        this.total = 0;
    }
}
