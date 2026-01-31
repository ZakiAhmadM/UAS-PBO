package uas;
import java.util.*;

public class Admin extends User {
    private MenuService menu;
    private TransaksiService trx;
    private AkunService akun;
    private Scanner in = new Scanner(System.in);

    public Admin(String u, MenuService m, TransaksiService t, AkunService a) {
        super(u);
        menu = m;
        trx = t;
        akun = a;
    }

@Override
public void showMenu() {
    int p;
    do {
        System.out.println("\n=== MENU ADMIN ===");
        System.out.println("1. Tambah Menu");
        System.out.println("2. Cek Stok");
        System.out.println("3. Laporan Penjualan");
        System.out.println("4. Tambah Akun");
        System.out.println("5. Ganti Password");
        System.out.println("6. Lihat Karyawan");
        System.out.println("7. Hapus Karyawan");
        System.out.println("0. Logout");
        System.out.print("Pilih: ");

        p = Integer.parseInt(in.nextLine());

        if (p == 1) menu.tambahMenu();
        if (p == 2) menu.tampilMenu();
        if (p == 3) trx.laporanPenjualan();
        if (p == 4) akun.tambahAkun();
        if (p == 5) akun.gantiPassword();
        if (p == 6) akun.lihatKaryawan();
        if (p == 7) akun.hapusKaryawan();

    } while (p != 0);
}

}