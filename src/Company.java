import java.io.Serializable;
import java.rmi.Remote;
import java.util.List;

public class Company implements Serializable, Remote {
    private String name;
    private List<Airplane> airplaneList;

    public Company(String name, List<Airplane> airplaneList) {
        this.name = name;
        this.airplaneList = airplaneList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Airplane> getAirplaneList() {
        return airplaneList;
    }

    public void setAirplaneList(List<Airplane> airplaneList) {
        this.airplaneList = airplaneList;
    }

    public String getParam() {
        String str = "";
        str = str + " имя компании " + this.name;
        for (int i = 0; i < airplaneList.size(); i++) {
            Airplane airplane = airplaneList.get(i);
            str = str + " \n Имя самолёта " + airplane.getName() + " Вместимость: " + airplane.getVm() + " Грузоподъёмность: " + airplane.getGr() ;
        }
        return str;
    }
}
