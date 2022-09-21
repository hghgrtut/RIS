package classes;

public class BalconyRoom extends BaseRoom {

    private final static long serialVersionUID = 1L;

    public BalconyRoom(String name, double square, int countPeopleInside, boolean isWorking) {
        super(name, square, countPeopleInside, isWorking);
    }

    @Override
    public String toString() {
        return super.toString() + (isWorking ? "Кто-то курит" : "Никто не курит");
    }
}
