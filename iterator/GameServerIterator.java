public class GameServerIterator implements ServerIterator {
    private GameServer gameServer;
    private int i = 0;

    public GameServerIterator(GameServer server) {
        this.gameServer = server;
    }

    @Override
    public boolean hasNext() {
        return this.i < gameServer.nodeNumber();
    }

    @Override
    public GameNode next() {
        this.i++;
        return gameServer.getNextNode();
    }
}
