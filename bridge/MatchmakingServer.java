import java.util.ArrayList;
public class MatchmakingServer {
    Connection connection;
    ArrayList<Player> players;
    ArrayList<Player> playersToChangeList;
    private int latitudeOfServer;
    private int longitudeOfServer;

    public MatchmakingServer(int latitude, int longitude){
        connection = new Connection();
        players = new ArrayList<>();
        playersToChangeList = new ArrayList<>();
        this.latitudeOfServer = latitude;
        this.longitudeOfServer = longitude;
    }

    public void changeImplementation(Connection c1){
        connection = c1;
    }

    public void changeConnectionTypeOf(Player p){
        connection.setConnectionType(p);
    }

    public boolean acceptPlayer(Player p){
        if(players.size() == 0) {
            players.add(p);
            return false;
        }
        else {
            boolean flag = false;
            players.add(p);
            if(!isPlayerFarFromServer(p))
                return false;
            else { // player is far from server
                for(int i = 0; i < players.size() - 1; i++) {
                    if(isPlayersCloseEachOther(players.get(i), p)){ // and there are other players close to player p,
                        playersToChangeList.add(players.get(i)); // choose peer to peer for them
                        playersToChangeList.add(p);
                        flag = true;
                    }
                }
                return flag;
            }
        }
    }

    public boolean isPlayerFarFromServer(Player p) {
        double first = (p.getLatitude() - this.latitudeOfServer) * (p.getLatitude() - this.latitudeOfServer);
        double second = (p.getLatitude() - this.longitudeOfServer) * (p.getLongitude() - this.longitudeOfServer);
        double ans = Math.sqrt(first + second);

        System.out.println("Player with id: " + p.getId() + "'s distance to server is: " + ans);
        return ans > 50;
    }

    public boolean isPlayersCloseEachOther(Player p1, Player p2) {
        double first = (p1.getLatitude() - p2.getLatitude()) * (p1.getLatitude() - p2.getLatitude());
        double second = (p1.getLongitude() - p2.getLongitude()) * (p1.getLongitude() - p2.getLongitude());
        double ans = Math.sqrt(first + second);


        System.out.println("Distance between player with id " + p1.getId() + " and player with id: " + p2.getId() + " is " + ans);
        return ans < 50;
    }

    public ArrayList<Player> getPlayersToChangeList(){
        return this.playersToChangeList;
    }

    public void flush(){
        this.playersToChangeList.clear();
    }



}
