public class GameServer implements Colleague{
    private int serverCode;
    private int occupancyRatio;
    private ServerMediator mediator;

    public GameServer(int serverCode, ServerMediator serverMediator ) {
        this.occupancyRatio = 0;
        this.serverCode = serverCode;
        this.mediator = serverMediator;
    }

    public int getServerCode() {
        return this.serverCode;
    }

    public int getOccupancyRatio() {
        return this.occupancyRatio;
    }

    public void setOccupancyRatio(int newOccupancy) {
        this.occupancyRatio = newOccupancy;
    }

    @Override
    public void echo() {
        mediator.collectData(this);
    }

    public void addPlayer() {
        this.occupancyRatio++;
        this.echo();
    }

    public void dropPlayer(){
        this.occupancyRatio--;
        this.echo();
    }

}
