package uas;

import java.util.*;

public class MenuService {
    private ArrayList<MenuMakanan> list = new ArrayList<>();
    private Scanner in = new Scanner(System.in);

    public MenuService() {
        list.add(new MenuMakanan("Nasi Goreng", 15000, 10));
    }

    public void tampilMenu() {
        System.out.println("\n=== DAFTAR MENU ===");
        for (int i = 0; i < list.size(); i++) {
            MenuMakanan m = list.get(i);
            System.out.println(
                (i + 1) + ". " + m.getNama() +
                " | Harga: " + m.getHarga() +
                " | Stok: " + m.getStok()
            );
        }
    }

    public void tambahMenu() {
        System.out.print("Nama Menu : ");
        String nama = in.nextLine();

        System.out.print("Harga     : ");
        int harga = Integer.parseInt(in.nextLine());

        System.out.print("Stok      : ");
        int stok = Integer.parseInt(in.nextLine());

        list.add(new MenuMakanan(nama, harga, stok));
        System.out.println("Menu berhasil ditambahkan!");
    }

    // 🔧 FIX PENTING
    public MenuMakanan getMenu(int index) {
        return list.get(index);
    }
}
