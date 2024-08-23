package controllers;

import entities.User;

import java.util.ArrayList;
import java.util.List;


public class UserController {

    List<User> users = new ArrayList<>();

    public void registerUser(String name, String email, int age, double height) {
        users.add(new User(name, email, age, height));
    }

    public List<User> listUsers() {
        return new ArrayList<>(users);
    }

    public void searchUser() {}
}
