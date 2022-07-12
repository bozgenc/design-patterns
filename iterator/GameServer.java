public class GameServer implements Server{
    private int size = 0;
    private GameNode cursor;
    private GameNode head;
    private GameNode curr;

    private GameNode addFirst() {
        GameNode node = new GameNode();
        head = node;
        curr = node;
        cursor = node;
        size++;
        return node;
    }

    public GameNode addGameNode() {
        if(this.size == 0)
            return addFirst();
        else {
            GameNode node = new GameNode();
            curr.setNext(node);
            curr = node;
            size++;
            return node;
        }
    }

    public GameNode first() {
        return this.head;
    }

    public GameNode getNextNode() {
        GameNode temp = cursor;
        cursor = cursor.getNext();
        return temp;
    }

    public int nodeNumber() {
        return this.size;
    }

    @Override
    public ServerIterator getServerIterator() {
        return new GameServerIterator(this);
    }
}
