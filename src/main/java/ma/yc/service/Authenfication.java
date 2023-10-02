package ma.yc.service;

public interface Authenfication {
    public boolean login(String[] credentials);
    public boolean logout();
}
