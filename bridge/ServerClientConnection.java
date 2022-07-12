public class ServerClientConnection extends Connection{
    public String getConnectionType() {
        return "Server-Client";
    }

    public void setConnectionType(Player p){
        p.setConnectionType(this);
    }
}
