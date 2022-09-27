import classes.BalconyRoom;

public class Main {

    public static void main(String[] args) {
        BalconyRoom b = new BalconyRoom("Первый балкон", 4, 2, true);
        System.out.println(b);
        b.setIsWorking(false);
        System.out.println(b);
    }
}
