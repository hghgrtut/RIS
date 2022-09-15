import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        House house1 = new House("10a", 5);
        House house2 = new House("11", 6);

        List<House> streets = new ArrayList<>();
        streets.add(house1);
        streets.add(house2);
        Street sovet = new Street("Советская", streets);


        sovet.nnn();

    }
}


