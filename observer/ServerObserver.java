public interface ServerObserver {
    public void update(int occupancyRatio, String nodeName);
    public String getName();
}
