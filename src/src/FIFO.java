import java.util.LinkedList;
import java.util.Queue;

/**
 * The FIFO class implements the First-In-First-Out (FIFO) page replacement algorithm.
 * It keeps track of page hits, faults, and the total number of pages processed.
 */
public class FIFO implements ReplacementAlgorithm {
    private int hit;
    private int fault;
    private int total;

    /**
     * Constructs a new FIFO page replacement algorithm with hit, fault, and total counters set to zero.
     */
    public FIFO() {
        this.hit = 0;
        this.fault = 0;
        this.total = 0;
    }

    /**
     * Runs the FIFO page replacement algorithm on the given list of pages.
     *
     * @param list the array of pages to be processed
     * @param page the maximum number of pages that can be held in memory at one time
     */
    @Override
    public void run(int[] list, int page) {
        total = list.length;
        Queue<Integer> queue = new LinkedList<>();

        for (int i : list) {
            if (!queue.contains(i)) {
                fault++;
                if (queue.size() >= page) {
                    queue.poll();
                }
                queue.offer(i);
            } else {
                hit++;
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
    public int getTotal(){
        return this.total;
    }

    /**
     * Resets the hit, fault, and total counters to zero.
     */
    public void reset(){
        this.hit = 0;
        this.fault = 0;
        this.total = 0;
    }
}
