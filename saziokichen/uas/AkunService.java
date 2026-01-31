package uas;

import java.io.*;
import java.util.*;

public class AkunService {
    private ArrayList<Akun> list = new ArrayList<>();
    private final String FILE = "akun.txt";
    private Scanner in = new Scanner(System.in);

    public AkunService() {
        loadFile();
    }

    private void loadFile() {
        try {
            File f = new File(FILE);
            if (!f.exists()) {
                list.add(new Akun("admin","123","ADMIN"));
                list.add(new Akun("karyawan","123","KARYAWAN"));
                saveFile();
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(FILE));
            String line;
            while ((line = br.readLine()) != null) {
                String[] d = line.split(",");
                list.add(new Akun(d[0], d[1], d[2]));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Gagal membaca file akun");
        }
    }

    private void saveFile() {
        try {
            FileWriter fw = new FileWriter(FILE);
            for (Akun a : list) {
                fw.write(a.getUsername()+","+a.getPassword()+","+a.getRole()+"\n");
            }
            fw.close();
        } catch (Exception e) {
            System.out.println("Gagal menyimpan file akun");
        }
    }

    public Akun login(String u, String p) {
        for (Akun a : list) {
            if (a.cekLogin(u, p)) return a;
        }
        return null;
    }

    public void tambahAkun() {
        System.out.print("Username: ");
        String u = in.next();
        System.out.print("Password: ");
        String p = in.next();
        System.out.print("Role (ADMIN/KARYAWAN): ");
        String r = in.next().toUpperCase();

        list.add(new Akun(u,p,r));
        saveFile();
        System.out.println("Akun berhasil ditambahkan");
    }

    public void gantiPassword() {
        System.out.print("Username: ");
        String u = in.next();
        System.out.print("Password baru: ");
        String p = in.next();

        for (Akun a : list) {
            if (a.getUsername().equals(u)) {
                a.setPassword(p);
                saveFile();
                System.out.println("Password berhasil diganti");
                return;
            }
        }
        System.out.println("Akun tidak ditemukan");
    }

    public void lihatKaryawan() {
    System.out.println("\n=== DAFTAR KARYAWAN ===");
    int no = 1;
    for (Akun a : list) {
        if (a.getRole().equals("KARYAWAN")) {
            System.out.println(no + ". " + a.getUsername());
            no++;
        }
    }
    if (no == 1) {
        System.out.println("Belum ada karyawan");
    }
}

public void hapusKaryawan() {
    Scanner in = new Scanner(System.in);
    System.out.print("Username karyawan yang dihapus: ");
    String u = in.nextLine();

    for (int i = 0; i < list.size(); i++) {
        Akun a = list.get(i);
        if (a.getUsername().equals(u) && a.getRole().equals("KARYAWAN")) {
            list.remove(i);
            saveFile();
            System.out.println("Karyawan berhasil dihapus");
            return;
        }
    }
    System.out.println("Karyawan tidak ditemukan");
}

}
