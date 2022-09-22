import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

public class Flowers implements Serializable, Remote {
    private Vasilek flowersecond;
    private String buket;
    private List<Flower> flowerList = new ArrayList<>();

    public Flowers(String buket) {
        this.buket = buket;
    }

    public double getCost() {
        double sum = 0.0;
        for (int i = 0; i < flowerList.size(); i++) {
            Flower flower = flowerList.get(i);
            double cost = flower.getCost();
            int number = flower.getNumber();
            sum += cost * number;
        }
        return sum;
    }

    public List<Flower> getFlowerList() {
        return flowerList;
    }

    public void setFlowerList(List<Flower> flowerList) {
        this.flowerList = flowerList;
    }

    public static void main(String[] args) {
        Roza flower = new Roza("Roza", 15, 1);
        Vasilek flowersecond = new Vasilek("Vasilek", 10, 10);
        Acsesuars acsesuars = new Acsesuars("lenta", 20, 1);


        Flowers flowers = new Flowers("buket");
        List<Flower> flowerList = flowers.getFlowerList();
        flowerList.add(flower);
        flowerList.add(flowersecond);
        flowerList.add(acsesuars);
        System.out.println(flowers.getCost());


        ObjectSerializable objectSerializable = new ObjectSerializable();
        objectSerializable.serializableToFile("test", flowers);
    }

    private void addroza(Roza flower) {

    }

    private void addacsesuars(Acsesuars flowersecond) {
    }

    private void addvasilek(Vasilek flowersecond) {
        this.flowersecond = flowersecond;
    }

    public void setFlowersecond(Vasilek flowersecond) {
        this.flowersecond = flowersecond;
    }

    public Vasilek getFlowersecond() {
        return flowersecond;
    }

    public String getBuket() {
        return buket;
    }
}
