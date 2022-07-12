public class MatchmakingServer {
    private ServerMediator mediator;

    public MatchmakingServer(ServerMediator mediator) {
        this.mediator = mediator;
    }

    public int getMostEligibleServer() {
        int mostEligible = mediator.getMostEligibleServerId();
        System.out.println("***Most eligible server is currently the server with the id: " + mostEligible);
        System.out.println("***New player will be redirected Server " + mostEligible);
        return mostEligible;
    }
}
