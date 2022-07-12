import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) throws InterruptedException {
        ServerClientConnection s1 = new ServerClientConnection();
        PeerToPeerConnection p1 = new PeerToPeerConnection();
        MatchmakingServer server = new MatchmakingServer(30, 30);

        ArrayList<Player> temp = new ArrayList<>();
        temp.add(new Player(1, 10, 20, null, 16));
        temp.add(new Player(2, 20, 25, null, 58));
        temp.add(new Player(3, 80, 80, null, 80));
        temp.add(new Player(4, 90, 90, null, 24));

        for(int i = 0; i < 4; i++) {
            boolean flag = false;
            Player player = temp.get(i);
            boolean redirectToPeer = server.acceptPlayer(player);
            if(redirectToPeer) {
                server.changeImplementation(p1);
                for(Player p: server.getPlayersToChangeList()) {
                    flag = true;
                    server.changeConnectionTypeOf(p);
                    System.out.println("******** CHANGED CONNECTION TYPE OF PLAYER WITH ID: "
                            + p.getId() + " to " + p.getConnectionType() + "*********");
                    System.out.println(p);
                }
                server.flush();
            }
            else {
                server.changeImplementation(s1);
                server.changeConnectionTypeOf(player);
            }

            if(!flag)
                System.out.println(player);
        }
    }
}
