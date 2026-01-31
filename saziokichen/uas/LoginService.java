package uas;

public interface LoginService {
    boolean login(String username, String password);
    void logout();
}
