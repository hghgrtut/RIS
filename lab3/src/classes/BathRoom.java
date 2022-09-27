package classes;

public class BathRoom extends BaseRoom {

    private final static long serialVersionUID = 1L;

    public BathRoom(String name, double square, int countPeopleInside, boolean isWorking) {
        super(name, square, countPeopleInside, isWorking);
    }

    @Override
    public String toString() {
        return super.toString() + (isWorking ? "Кто-то моется" : "Никто не моется");
    }
}
