public abstract class Flower {
    private String name;
    private double cost;
    private int number;

    public Flower(String name, double cost, int number) {
        this.name = name;
        this.cost = cost;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
