package uas;

import java.time.LocalDate;
import java.util.*;

public class TransaksiService {
    private ArrayList<Transaksi> list = new ArrayList<>();

    // ===== TRANSAKSI KARYAWAN + STRUK =====
    public void transaksi(MenuService menu) {
        Scanner in = new Scanner(System.in);
        boolean lanjut = true;
        int totalBayar = 0;

        System.out.println("\n===== STRUK SAZIO KITCHEN =====");

        while (lanjut) {
            menu.tampilMenu();

            System.out.print("Pilih menu: ");
            int pilih = Integer.parseInt(in.nextLine());
            MenuMakanan m = menu.getMenu(pilih - 1);

            System.out.print("Qty: ");
            int qty = Integer.parseInt(in.nextLine());

            if (!m.cekStok(qty)) {
                System.out.println("Stok tidak cukup!");
                continue;
            }

            m.tambahStok(-qty);
            int subtotal = m.getHarga() * qty;
            totalBayar += subtotal;

            list.add(new Transaksi(
                m.getNama(),
                qty,
                subtotal,
                LocalDate.now().toString()
            ));

            System.out.println(
                m.getNama() + " x" + qty + " = " + subtotal
            );

            System.out.print("Tambah pesanan? (y/n): ");
            if (in.nextLine().equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }

        System.out.println("------------------------------");
        System.out.println("TOTAL BAYAR : " + totalBayar);
        System.out.println("Terima kasih !!!");
        System.out.println("==============================");
    }

    // ===== LAPORAN ADMIN =====
    public void laporanPenjualan() {
        System.out.println("\n=== LAPORAN PENJUALAN ===");

        Map<String, Integer> totalQty = new HashMap<>();
        Map<String, Integer> totalUang = new HashMap<>();

        for (Transaksi t : list) {
            totalQty.put(
                t.getNamaMenu(),
                totalQty.getOrDefault(t.getNamaMenu(), 0) + t.getQty()
            );
            totalUang.put(
                t.getNamaMenu(),
                totalUang.getOrDefault(t.getNamaMenu(), 0) + t.getSubtotal()
            );
        }

        int grandTotal = 0;
        for (String menu : totalQty.keySet()) {
            System.out.println(
                menu +
                " | Terjual: " + totalQty.get(menu) +
                " | Total: " + totalUang.get(menu)
            );
            grandTotal += totalUang.get(menu);
        }

        System.out.println("------------------------------");
        System.out.println("TOTAL PENJUALAN: " + grandTotal);
    }
}
