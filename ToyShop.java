import java.util.*;


public class ToyShop {
    private final ArrayList<Toy> allToys = new ArrayList<>();
    private LinkedList<Toy> deliveryQueue = new LinkedList<>();


    private int totalWeight = 0;
    private final Random r = new Random();

    public ToyShop(PriorityQueue toys) {
        setQueue(toys);
    }

    private void setQueue(PriorityQueue toys) {
        allToys.addAll(toys);
        for (Toy toy: allToys
        ) {
            totalWeight+=toy.getWeight();
        }
    }

    public Toy getNextToy() {
        if (allToys.isEmpty()) return null;

        int randInt = r.nextInt(1, totalWeight+1);
        Toy chosenToy = null;
        int currentWeight = 0;

        for (Toy toy : allToys) {
            currentWeight += toy.getWeight();
            if (currentWeight >= randInt) {
                chosenToy = toy;
                addToDeliveryQueue(chosenToy);
                toy.setQuantity(toy.getQuantity()-1);
                checkQuantity();
                break;
            }
        }
        return chosenToy;
    }

    public void checkQuantity(){
        allToys.removeIf(toy -> toy.getQuantity() == 0);
    }

    public void addToDeliveryQueue(Toy toy){
        deliveryQueue.add(toy);
    }

    public Toy getToyFromQueue() {
        return deliveryQueue.poll();
    }
}
