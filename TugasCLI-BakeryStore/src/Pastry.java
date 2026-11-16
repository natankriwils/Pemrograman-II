package BakeryStore;

public class Pastry extends Cake {

    public Pastry(String name, int price, int stock) {
        super(name, price, stock);
    }

    @Override
    public String getCategory() {
        return "Pastry";
    }
}