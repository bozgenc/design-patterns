public class Player {
    private int id;

    public Player(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String toString(){
        String info = "----------------------------------\nPlayer <" + this.id + "> \n";
        return info;
    }
}

