import java.util.Objects;

import static java.lang.Integer.*;

public class Toy implements Comparable<Toy> {
    private int id;
    private String name;
    private Integer weight;
    private int quantity;


    public Toy(int id, String name, Integer weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.quantity = 10;
    }
    public Toy(int id, String name, Integer weight, int quantity) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.quantity = quantity;
    }
    public Toy() {
        this.name = null;
        this.quantity = 10;

    }


    @Override
    public int compareTo(Toy o) {
        return compare(parseInt(getWeight().toString()), parseInt(o.getWeight().toString()));
    }

    @Override
    public String toString() {
        return "Toy{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", weight=" + weight +
                '}';
    }

    public Integer getWeight() {
        return this.weight;
    }

    public String getName() {
        return name;
    }


    public int getId() {
        return this.id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setName(String name) {
        if (!Objects.equals(this.name, "")) {
            this.name = name;
        } else {
            this.name += " " + name;
        }
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
