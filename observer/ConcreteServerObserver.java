import java.util.ArrayList;

public class ConcreteServerObserver implements ServerObserver {
    private ArrayList<GameNode> gameNodes;
    private String name;

    public ConcreteServerObserver(String name, ArrayList<GameNode> nodes) {
        this.gameNodes =  nodes;
        this.name = name;
        System.out.println("New server observer created");
        for(GameNode node: gameNodes) {
            node.attach(this);
        }
    }


    @Override
    public void update(int occupancy, String nodeName) {
        if (occupancy < 10) {
            System.out.println(this.name + ":");
            System.out.println(nodeName + " can be deleted");
            System.out.println("--------------------------------------------------------------------");
        }
        if (occupancy > 80) {
            System.out.println(this.name + ":");
            System.out.println(nodeName + " is loaded. Expansion needed. New node will be created.");
            System.out.println("--------------------------------------------------------------------");
        }
    }

    public String getName() {
        return this.name;
    }
}
