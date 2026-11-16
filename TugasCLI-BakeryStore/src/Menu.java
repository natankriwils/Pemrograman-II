package BakeryStore;

import java.util.Scanner;

public class Menu {
    private Scanner scanner;
    private BakeryStore store;

    public Menu() {
        scanner = new Scanner(System.in);
        store = new BakeryStore();
    }

    public void run() {
        int choice;

        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addCake();
                    break;

                case 2:
                    addStock();
                    break;

                case 3:
                    sellCake();
                    break;

                case 4:
                    store.displayStock();
                    break;

                case 0:
                    System.out.println(
                            "Terima kasih!"
                    );
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

            System.out.println();

        } while (choice != 0);

        scanner.close();
    }

    private void showMenu() {
        System.out.println("=== BAKERY STORE ===");
        System.out.println("1. Tambah Data Kue");
        System.out.println("2. Tambah Stok Kue");
        System.out.println("3. Jual Kue");
        System.out.println("4. Lihat Stok Kue");
        System.out.println("0. Keluar");
        System.out.print("Pilih menu: ");
    }

    private void addCake() {
        System.out.println("\n=== Tambah Data Kue ===");

        System.out.print("Nama kue: ");
        String name = scanner.nextLine();

        System.out.print("Kategori kue: ");
        String category = scanner.nextLine();

        System.out.print("Harga kue (Rp): ");
        int price = scanner.nextInt();

        System.out.print("Stok awal: ");
        int stock = scanner.nextInt();
        scanner.nextLine();

        Cake cake;

        if (category.equalsIgnoreCase("Kue Basah")) {
            cake = new WetCake(name, price, stock);
        } else if (category.equalsIgnoreCase("Kue Kering")) {
            cake = new DryCake(name, price, stock);
        } else if (category.equalsIgnoreCase("Pastry")) {
            cake = new Pastry(name, price, stock);
        } else {
            System.out.println("Kategori tidak tersedia.");
            return;
        }

        if (price <= 0 || stock < 0) {
            System.out.println("Harga tidak valid.");
        } else if (store.addCake(cake)) {
            System.out.println("Data berhasil ditambahkan.");
        } else {
            System.out.println("Nama kue sudah terdaftar.");
        }
    }

    private void addStock() {
        System.out.println("\n=== Tambah Stok Kue ===");

        System.out.print("Nama kue: ");
        String name = scanner.nextLine();

        System.out.print("Jumlah stok yang ditambah: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        int stock = store.addStock(name, quantity);

        if (stock >= 0) {
            System.out.println(
                    "Stok " + name + " sekarang: " + stock
            );
        } else {
            System.out.println(
                    "Kue tidak ditemukan."
            );
        }
    }

    private void sellCake() {
        System.out.println("\n=== Jual Kue ===");

        System.out.print("Nama kue: ");
        String name = scanner.nextLine();

        System.out.print("Jumlah dijual: ");
        int quantity = scanner.nextInt();
        scanner.nextLine();

        int total = store.sellCake(name, quantity);

        if (total >= 0) {
            System.out.println(
                    "Terjual " + quantity + " " + name +
                            ". Total: Rp" + total
            );
        } else {
            System.out.println(
                    "Penjualan gagal."
            );
        }
    }
}