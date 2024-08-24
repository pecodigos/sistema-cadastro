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

    public void searchUser(String name) {
        System.out.println("\nUsuários cadastrados com esse nome: ");
        int id = 1;
        boolean userFound = false;
        for (User user : users) {
            if (user.getName().startsWith(name)) {
                System.out.println(id + "- " + user.getName());
                id++;
                userFound = true;
            }
        }
        if (!userFound) {
            System.out.println("Não há usuário com este nome.");
        }
    }
}
