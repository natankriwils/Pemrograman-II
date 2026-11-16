package BakeryStore;

public class DryCake extends Cake {

    public DryCake(String name, int price, int stock) {
        super(name, price, stock);
    }

    @Override
    public String getCategory() {
        return "Kue Kering";
    }
}