public class MainClass {
    public static void main(String[] args) {
        GameServer server = new GameServer();
        GameNode node = new GameNode("Node1");
        for(int i = 0; i < 80; i++){
            Player player = new Player(i);
            node.addPlayer(player);
        }
        System.out.println("There are 80 players in the Node1\n--------------------");

        GameNode node2 = new GameNode("Node2");
        for(int i = 80; i < 180; i++){
            Player player = new Player(i);
            node2.addPlayer(player);
        }
        System.out.println("There are 100 players in the Node1\n--------------------");

        server.addGameNode(node);
        server.addGameNode(node2);

        for(int i = 0; i < 90; i++) {
            node2.deletePlayer();
        }
        System.out.println("90 players left the Node2");
        System.out.println("Current player number in the Node2 is: " + node2.getPlayers().size());
        System.out.println("Node2 going to be removed from server!\n--------------------");

        System.out.println("Cloning process is started.");
        for(int i = 0; i < node2.getPlayers().size(); i++) {
            Player p = (Player) node2.getClone(node2.getPlayers().get(i));
            System.out.println("Player with id " + i + " is cloned!");
            node.addPlayer(p);
            System.out.println("Player with id " + i + " redirected to Node1");
            System.out.println("--------------------");
        }

        System.out.println("There are no players in the Node2");
        server.deleteGameNode(node2);

    }
}
