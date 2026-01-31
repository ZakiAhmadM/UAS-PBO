package uas;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        MenuService menu = new MenuService();
        TransaksiService trx = new TransaksiService();
        AkunService akun = new AkunService();

        while (true) {
            System.out.println("\nLOGIN SAZIO KITCHEN");
            System.out.print("Username: ");
            String u = in.next();
            System.out.print("Password: ");
            String p = in.next();

            Akun a = akun.login(u,p);
            if (a != null) {
                if (a.getRole().equals("ADMIN"))
                    new Admin(u,menu,trx,akun).showMenu();
                else
                    new Karyawan(u,menu,trx).showMenu();
            } else {
                System.out.println("Login gagal");
            }
        }
    }
}
