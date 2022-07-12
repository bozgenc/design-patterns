import java.util.ArrayList;
public class GameNode  {
    private String name;
    private ArrayList<Player> players;
    private GameNode next;

    public GameNode() {
        players = new ArrayList<Player>();
    }

    public void setNext(GameNode node) {
        this.next = node;
    }

    public GameNode getNext() {
        return this.next;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    };

    public void acceptPlayer(Player p) {
        players.add(p);
    }

    public boolean hasPlayerWithId(int id) {
        boolean present = false;
        for(Player p: players){
            if(p.getId() == id)
                present = true;
        }
        return present;
    }
}
