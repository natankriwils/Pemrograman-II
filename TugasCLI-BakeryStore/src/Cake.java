package BakeryStore;

public abstract class Cake implements Sellable {
    private String name;
    private int price;
    private int stock;

    public Cake(String name, int price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public abstract String getCategory();

    public void increaseStock(int quantity) {
        stock += quantity;
    }

    @Override
    public boolean sell(int quantity) {
        if (quantity > 0 && quantity <= stock) {
            stock -= quantity;
            return true;
        }

        return false;
    }
}