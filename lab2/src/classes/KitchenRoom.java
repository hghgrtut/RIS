package classes;

public class KitchenRoom extends BaseRoom {

    private final static long serialVersionUID = 1L;

    public KitchenRoom(String name, double square, int countPeopleInside, boolean isWorking) {
        super(name, square, countPeopleInside, isWorking);
    }

    @Override
    public String toString() {
        return super.toString() + (isWorking ? "Кто-то готовит" : "Никто не готовит");
    }
}
