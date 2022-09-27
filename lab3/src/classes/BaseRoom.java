package classes;

import java.io.Serializable;
import java.rmi.Remote;

public abstract class BaseRoom implements Serializable, Remote {

    private final static long serialVersionUID = 1L;
    protected String name;
    protected double square;
    protected int countPeopleInside;
    protected boolean isWorking;

    public BaseRoom(String name, double square, int countPeopleInside, boolean isWorking) {
        this.name = name;
        this.square = square;
        this.countPeopleInside = countPeopleInside;
        this.isWorking = isWorking;
    }

    public String getName() {
        return name;
    }

    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
    }

    public double getSquare() {
        return square;
    }
    public void getIn(int countPeopleInside) {
        this.countPeopleInside += countPeopleInside;
    }
    public void getOut(int countPeopleInside){
        this.countPeopleInside += countPeopleInside;
    }

    @Override
    public String toString() {
        return name + ". " + square + "кв.м. " + countPeopleInside  + "человека внутри. ";
    }
}