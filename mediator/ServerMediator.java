import java.util.ArrayList;
public class ServerMediator implements Mediator {
    private ArrayList<Colleague> servers;

    public ServerMediator() {
        servers = new ArrayList<>();
    }

    public void collectData(Colleague gameServer) {
        servers.add(gameServer);
    }


    @Override
    public int getMostEligibleServerId() {
        int min = 1000000;
        int minID = 0;
        for(Colleague c: servers) {
            if(c.getOccupancyRatio() < min) {
                minID = c.getServerCode();
                min = c.getOccupancyRatio();
            }
        }
        return minID;
    }
}
