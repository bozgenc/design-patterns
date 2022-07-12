public class MainClass {
    public static void main(String[] args) {
        GameServer server = new GameServer();

        GameNode n1 = server.addGameNode();
        n1.setName("Node1");
        for(int i = 0; i < 100; i++) {
            Player player = new Player(i);
            n1.acceptPlayer(player);
        }

        GameNode n2 = server.addGameNode();
        n2.setName("Node2");
        for(int i = 100; i < 200; i++) {
            Player player = new Player(i);
            n2.acceptPlayer(player);
        }

        GameNode n3 = server.addGameNode();
        n3.setName("Node3");
        for(int i = 200; i < 300; i++) {
            Player player = new Player(i);
            n3.acceptPlayer(player);
        }

        GameNode n4 = server.addGameNode();
        n4.setName("Node4");
        for(int i = 300; i < 400; i++) {
            Player player = new Player(i);
            n4.acceptPlayer(player);
        }

        ServerIterator iterator = server.getServerIterator();
        System.out.println("-----------------------------");
        System.out.println("Traversing the game nodes in the server!");
        
        System.out.println("-----------------------------");

    }
}
