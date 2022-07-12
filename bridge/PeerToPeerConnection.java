public class PeerToPeerConnection extends Connection{
    public String getConnectionType() {
        return "Peer to Peer";
    }

    public void setConnectionType(Player p) {
        p.setConnectionType(this);
    }
}
