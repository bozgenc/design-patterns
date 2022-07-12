public class Player implements GameObject {
    private int id;

    public Player(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public Player makeCopy(){
        Player playerObj = null;
        try {
            playerObj = (Player) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return playerObj;
    }

    public String toString(){
        return "Player with id: " + this.id;
    }
}
