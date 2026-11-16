package BakeryStore;

import java.util.ArrayList;

public class BakeryStore {
    private ArrayList<Cake> cakes;

    public BakeryStore() {
        cakes = new ArrayList<>();
    }

    private Cake findCake(String name) {
        for (Cake cake : cakes) {
            if (cake.getName().equalsIgnoreCase(name)) {
                return cake;
            }
        }

        return null;
    }

    public boolean addCake(Cake cake) {
        if (findCake(cake.getName()) != null) {
            return false;
        }

        cakes.add(cake);
        return true;
    }

    public int addStock(String name, int quantity) {
        Cake cake = findCake(name);

        if (cake == null || quantity <= 0) {
            return -1;
        }

        cake.increaseStock(quantity);
        return cake.getStock();
    }

    public int sellCake(String name, int quantity) {
        Cake cake = findCake(name);

        if (cake == null || !cake.sell(quantity)) {
            return -1;
        }

        return cake.getPrice() * quantity;
    }

    public void displayStock() {
        System.out.println("\n=== Lihat Stok Kue ===");

        if (cakes.isEmpty()) {
            System.out.println("Belum ada data kue.");
            return;
        }

        for (int i = 0; i < cakes.size(); i++) {
            Cake cake = cakes.get(i);

            System.out.println(
                    (i + 1) + ". " + cake.getName() +
                            " | Rp" + cake.getPrice() +
                            " | Stok: " + cake.getStock()
            );
        }
    }
}