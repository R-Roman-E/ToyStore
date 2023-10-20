import java.util.Comparator;

public class ComparatorWeight implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        int w1 = o1.getWeight();
        int w2 = o2.getWeight();
        if(w2>w1) return +1;
        if(w2<w1) return -1;
        return 0;
    }
}
