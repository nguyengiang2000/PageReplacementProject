import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class JunitTest {
    private FIFO fifo;
    private LRU lru;

    @BeforeEach
    public void setUp() {
        fifo = new FIFO();
        lru = new LRU();
    }

    @Test
    public void testFIFOPageReplacement() {
        int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int frameSize = 3;

        fifo.run(pages, frameSize);

        assertEquals(3, fifo.getHit());
        assertEquals(9, fifo.getFault());
        assertEquals(12, fifo.getTotal());
    }

    @Test
    public void testLRUPageReplacement() {
        int[] pages = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
        int frameSize = 3;

        lru.run(pages, frameSize);

        assertEquals(2, lru.getHit());
        assertEquals(10, lru.getFault());
        assertEquals(12, lru.getTotal());
    }
}
