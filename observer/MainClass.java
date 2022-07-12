import java.util.ArrayList;

public class MainClass {
    public static void main(String[] args) {
        ArrayList<GameNode> nodes = new ArrayList<GameNode>();
        ConcreteGameNode gameNode1 = new ConcreteGameNode("GameNode1");
        ConcreteGameNode gameNode2 =  new ConcreteGameNode("GameNode2");

        nodes.add(gameNode1);
        nodes.add(gameNode2);

        ConcreteServerObserver observer1 = new ConcreteServerObserver("Observer1", nodes);
        //gameNode1.detach(observer1);

        for(int i = 0; i < 60; i++) {
            gameNode1.acceptPlayer();
        }

        gameNode1.detach(observer1);
        ConcreteServerObserver observer2 = new ConcreteServerObserver("Observer2", nodes);

        System.out.println("\n************************************************************\n");
        for(int i = 0; i < 71; i++) {
            gameNode1.deletePlayer();
        }

        /*System.out.println("\n************************GAME NODE 2 ************************************\n");

        for(int i = 0; i < 70; i++) {
            gameNode2.acceptPlayer();
        }*/

    }
}
