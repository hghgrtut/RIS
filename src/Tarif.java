
public class Tarif {

    private String name;
    private int price;

    public Tarif(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Tarif() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
