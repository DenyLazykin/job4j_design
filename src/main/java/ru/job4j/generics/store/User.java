package ru.job4j.generics.store;

public class User extends Base {
    private final String userName;

    public User(String id, String userName) {
        super(id);
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }
}
