import java.util.ArrayList;
public class GameServer {
    private ArrayList<GameNode> gameNodes;

    public GameServer(){
        gameNodes = new ArrayList<>();
    }

    public void addGameNode(GameNode node) {
        gameNodes.add(node);
    }

    public void deleteGameNode(GameNode node) {
        int delete = -1;
        for(int i = 0; i< gameNodes.size(); i++){
            if(node.getName().equals(gameNodes.get(i).getName()))
                delete = i;
        }
        gameNodes.remove(delete);

        System.out.println("Game node " + node.getName() + " is removed from server");
    }
}
