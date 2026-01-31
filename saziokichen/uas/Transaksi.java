package uas;

public class Transaksi {
    private String namaMenu;
    private int qty;
    private int subtotal;
    private String tanggal;

    public Transaksi(String namaMenu, int qty, int subtotal, String tanggal) {
        this.namaMenu = namaMenu;
        this.qty = qty;
        this.subtotal = subtotal;
        this.tanggal = tanggal;
    }

    public String getNamaMenu() {
        return namaMenu;
    }

    public int getQty() {
        return qty;
    }

    public int getSubtotal() {
        return subtotal;
    }

    public String getTanggal() {
        return tanggal;
    }
}
