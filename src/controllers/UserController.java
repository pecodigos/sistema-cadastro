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
        int count = 1;
        for (User user : users) {
            if (user.getName().contains(name)) {
                System.out.println(count + "- " + user.getName());
                count++;
            }
            if (!user.getName().contains(name)) {
                System.out.println("Não há usuário com este nome.");
            }
        }
    }
}
