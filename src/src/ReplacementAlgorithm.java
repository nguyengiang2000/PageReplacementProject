public interface ReplacementAlgorithm {
    public void run(int[] list, int page);
    public int getHit();
    public int getFault();
    public int getTotal();
    public void reset();
}
