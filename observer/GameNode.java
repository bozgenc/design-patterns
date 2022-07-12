public interface GameNode {
    public void attach(ServerObserver observer);
    public void detach(ServerObserver observer);
    public void notifyObservers();
}
