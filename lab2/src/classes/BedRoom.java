package classes;

public class BedRoom extends BaseRoom {

    private final static long serialVersionUID = 1L;

    public BedRoom(String name, double square, int countPeopleInside, boolean isWorking) {
        super(name, square, countPeopleInside, isWorking);
    }

    @Override
    public String toString() {
        return super.toString() + (isWorking ? "Кто-то спит" : "Никто не спит");
    }
}
