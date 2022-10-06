import java.io.Serializable;
import java.rmi.Remote;
import java.util.ArrayList;
import java.util.List;

public class Operator implements Serializable, Remote {
    private String name;
    private List<Tarif> tarifies = new ArrayList<>();
    private static int countClient = 0;

    public Operator() {
        countClient++;
    }

    public Operator(String name) {
        this.name = name;
        countClient++;
    }

    public List<Tarif> getTarifList(){
        return tarifies;
    }
    public void setTarifList(List<Tarif> tarifList){
        this.tarifies = tarifList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountClient() {
        return countClient;
    }

    public void setCountClient(int countClient) {
        this.countClient = countClient;
    }

    public void printListClient() {
        System.out.println("Кол-во: " + countClient);
    }
}
