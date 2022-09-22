import java.io.Serializable;

public abstract class ElectroDevice implements Serializable {
    private static final long serialVersionUID = 1L;
    private final String name;
    private final double power;
    private boolean isTurnOn;

    public double getPower(){
        return isTurnOn ? power : 0;
    }

    public ElectroDevice(String n, double p){
        this.name = n;
        this.power = p;
        this.isTurnOn = false;
    }

    public void turnOn()
    {
        isTurnOn = true;
    }
    public void turnOff()
    {
        isTurnOn = false;
    }

    @Override
    public String toString(){
        return "Название прибора: " + this.name + "   Мощность: " + this.power + "   Включён: " + this.isTurnOn;
    }
}
