package uas;

import java.util.*;

public class Karyawan extends User {
    private MenuService menu;
    private TransaksiService trx;
    private Scanner in = new Scanner(System.in);

    public Karyawan(String u, MenuService m, TransaksiService t) {
        super(u);
        menu = m;
        trx = t;
    }

    @Override
    public void showMenu() {
        int p;
        do {
        System.out.println("\n=== MENU KARYAWAN ===");
        System.out.println("1. Lihat Menu");
        System.out.println("2. Transaksi");
        System.out.println("0. Logout");
        System.out.print("Pilih: ");

        p = Integer.parseInt(in.nextLine());

        if (p == 1) menu.tampilMenu();
        if (p == 2) trx.transaksi(menu);

    } while (p != 0);
}
}