import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Airplane implements Serializable {
    private String name;
    private double vm;
    private double gr;

    public Airplane(String name, double vm, double gr) {
        this.name = name;
        this.vm = vm;
        this.gr = gr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getVm() {
        return vm;
    }

    public void setVm(double vm) {
        this.vm = vm;
    }

    public double getGr() {
        return gr;
    }

    public void setGr(double gr) {
        this.gr = gr;
    }
}

