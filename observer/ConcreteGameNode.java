import java.util.ArrayList;

public class ConcreteGameNode implements GameNode{
    private ArrayList<ServerObserver> observers;
    private int occupancyRatio;
    private String name;

    public ConcreteGameNode(String name){
        observers = new ArrayList<ServerObserver>();
        this.name = name;
        this.occupancyRatio = 20;
    }
    @Override
    public void attach(ServerObserver observer) {
        observers.add(observer);
        System.out.println("Observer  <" + observer.getName() + "> is attached to " + this.name);
    }

    @Override
    public void detach(ServerObserver observerToDelete) {
        int observerIndex = observers.indexOf(observerToDelete);
        observers.remove(observerIndex);

        System.out.println("Observer: " + "(" +  observerToDelete.getName()+ " )" + " is detached from " + this.name);
    }

    @Override
    public void notifyObservers() {
        for(ServerObserver o : observers) {
            o.update(occupancyRatio, this.name);
        }
    }

    private void incrementNodeOccupancy(){
        this.occupancyRatio++;
        notifyObservers();

    }

    private void decrementNodeOccupancy(){
        this.occupancyRatio--;
        notifyObservers();

    }

    public void acceptPlayer() {
        incrementNodeOccupancy();
        System.out.println("Player joined the game node 1. Current player count: " + occupancyRatio);
    }

    public void deletePlayer() {
        decrementNodeOccupancy();
        System.out.println("Player left the game node 1. Current player count: " + occupancyRatio);
    }
}
