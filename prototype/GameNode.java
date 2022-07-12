import java.util.ArrayList;
public class GameNode {
    private ArrayList<Player> players;
    private String name;

    public GameNode(String name){
        players = new ArrayList<>();
        this.name = name;
    }

    public void addPlayer(Player p) {
        players.add(p);
    }

    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    public String getName() {
        return this.name;
    }

    public void deletePlayer(){
        if(players.size() > 0)
            players.remove(players.size() -1);
        else
            System.out.println("No players in the node!");
    }

    public GameObject getClone(GameObject obj) {
        return (GameObject) obj.makeCopy();
    }

}
