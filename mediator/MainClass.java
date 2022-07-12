public class MainClass {
    public static void main(String[] args) {
        ServerMediator serverMediator = new ServerMediator();

        GameServer server1 = new GameServer(1, serverMediator);
        GameServer server2 = new GameServer(2, serverMediator);
        GameServer server3 = new GameServer(3, serverMediator);
        MatchmakingServer matchmakingServer = new MatchmakingServer(serverMediator);

        for(int i = 0; i < 30; i++)
            server1.addPlayer();

        for(int i = 0; i < 32; i++)
            server2.addPlayer();

        for(int i = 0; i < 35; i++)
            server3.addPlayer();



        for(int i = 0; i < 10; i++) {
            System.out.println("PLAYER " + (i + 1) +  " wants to join the game.");
            System.out.println("Current player number in Server 1: " + server1.getOccupancyRatio());
            System.out.println("Current player number in Server 2: " + server2.getOccupancyRatio());
            System.out.println("Current player number in Server 3: " + server3.getOccupancyRatio());

            int serverId = matchmakingServer.getMostEligibleServer();

            if(serverId == 1)
                server1.addPlayer();
            if(serverId == 2)
                server2.addPlayer();
            if(serverId == 3)
                server3.addPlayer();

            System.out.println("-----------------------------------------------------------------\n");

        }
    }
}
