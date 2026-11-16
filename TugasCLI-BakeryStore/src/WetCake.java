package BakeryStore;

public class WetCake extends Cake {

    public WetCake(String name, int price, int stock) {
        super(name, price, stock);
    }

    @Override
    public String getCategory() {
        return "Kue Basah";
    }
}