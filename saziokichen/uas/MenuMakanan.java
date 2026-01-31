package uas;

public class MenuMakanan {
    private String nama;
    private Integer harga;
    private Integer stok;

    public MenuMakanan(String n, Integer h, Integer s) {
        nama = n;
        harga = h;
        stok = s;
    }

    public String getNama() { return nama; }
    public Integer getHarga() { return harga; }
    public Integer getStok() { return stok; }

    public void tambahStok(Integer jumlah) {
        stok += jumlah;
    }

    public boolean cekStok(Integer jumlah) {
        return stok >= jumlah;
    }
}
