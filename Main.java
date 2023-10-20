import java.io.FileWriter;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int quantityToWinner;
        try {
            Scanner scan = new Scanner(System.in);
            ComparatorWeight c = new ComparatorWeight();
            PriorityQueue<Toy> pq = new PriorityQueue<>(c);

            System.out.println("Please, enter information about toy: id, weight, name with space between. " +
                    "When you finish, press button Enter 2 times: ");
            while (true) {

                String toyString = scan.nextLine();
                if (toyString.equals("")) {
                    break;
                }
                if (!checkValidData(toyString)) {
                    System.out.println("Please, reenter information about toy. Data invalid!");
                    continue;
                }

                Toy toy = getToy(toyString);
                pq.add(toy);
            }

            System.out.println("How many toys does machine need to give out? Maximum 10");
            quantityToWinner = scan.nextInt();
            scan.close();

            ToyShop toyShop = new ToyShop(pq);
            for (int i = 0; i < 10; i++) {
                Toy toy = toyShop.getNextToy();
            }

            try (FileWriter file = new FileWriter("answer.txt", true)) {
                for (int i = 0; i < quantityToWinner; i++) {
                    Toy toy = getToyFromQueue(toyShop);
                    if(toy!=null) {
                        file.write(toy.getId() + " " + toy.getName());
                        file.write("\n");
                    } else System.out.println("The toys' queue is over! ");
                }


            } catch (Exception e) {
                e.printStackTrace();

            }

    }catch(Exception e){
            System.out.println("You didn't enter any information! Application will be closed!");
    }

    }

    public static boolean checkValidData(String toyString) {
        String[] data = toyString.split(" ");
        if(data.length<3) return false;
        try{
            int id = Integer.parseInt(data[0]);
            int weight = Integer.parseInt(data[1]);
        }catch(Exception e){
            return false;
        }
        return true;
    }

    public static Toy getToy(String toyString) {
        String[] data = toyString.split(" ");
        Toy toy = new Toy();
        for (int i = 0; i < data.length; i++) {
            if(i==0) toy.setId(Integer.parseInt(data[i]));
            else if (i==1) {
                toy.setWeight(Integer.parseInt(data[i]));
            }else toy.setName(data[i]);

        }
        return toy;
    }

    public static Toy get(PriorityQueue<Toy> pq){
        return pq.poll();
    }

    public static Toy getToyFromQueue(ToyShop toyShop){
        return toyShop.getToyFromQueue();
    }

}
