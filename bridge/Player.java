public class Player {
    private int id;
    private int latitude;
    private int longitude;
    private Connection connectionType;
    private int netSpeed;

    public Player(int id, int latitude, int longitude, Connection connectionType, int netSpeed) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.connectionType = connectionType;
        this.netSpeed = netSpeed;
    }

    public void setConnectionType(Connection cType) {
        this.connectionType = cType;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public String getConnectionType() {
        return connectionType.getConnectionType();
    }

    public int getId() {
        return this.id;
    }

    public String toString(){
        String info = "----------------------------------\nPlayer <" + this.id + "> \n";
        info += "Latitude: " + this.latitude + "\n" + "Longitude: " + this.longitude + "\n";
        info += "Connection type: " + this.connectionType.getConnectionType() + "\n";
        info += "Internet Speed: " + this.netSpeed + "\n-----------------------------------\n";

        return info;
     }

}

