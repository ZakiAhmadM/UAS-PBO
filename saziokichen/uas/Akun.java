package uas;

public class Akun {
    private String username;
    private String password;
    private String role;

    public Akun(String u, String p, String r) {
        username = u;
        password = p;
        role = r;
    }

    // GETTER
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getRole() { return role; }

    // SETTER
    public void setPassword(String newPassword) {
        password = newPassword;
    }

    // METHOD TAMBAHAN
    public boolean cekLogin(String u, String p) {
        return username.equals(u) && password.equals(p);
    }
}
