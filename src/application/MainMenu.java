package application;

import controllers.UserController;
import entities.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainMenu {


    UserController userController = new UserController();
    List<String> questions = new ArrayList<>();

    public void registerUser() {
        Scanner sc = new Scanner(System.in);

        System.out.print("\nDigite o caminho para o arquivo .txt: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        String fileParent = file.getParent();

        boolean success = new File(fileParent + "/out").mkdir();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(line);
            }

            System.out.print(questions.getFirst() + " ");
            String name = sc.nextLine();

            System.out.print(questions.get(1) + " ");
            String email = sc.nextLine();

            System.out.print(questions.get(2) + " ");
            int age = sc.nextInt();

            System.out.print(questions.get(3) + " ");
            double height = sc.nextDouble();

            userController.registerUser(name, email, age, height);

            int count = 1;
            String outFile = fileParent + String.format("/out/%d-", count) + name.toUpperCase().replaceAll("\\s+", "") + ".txt";
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
                for (User user : userController.listUsers()) {
                    bw.write("1 - " + user.getName() + "\n");
                    bw.write("2 - " + user.getEmail() + "\n");
                    bw.write("3 - " + user.getAge() + "\n");
                    bw.write("4 - " + user.getHeight() + "\n");
                }
                System.out.println("\nUsuário cadastrado com sucesso!");
            }
        } catch (IOException e) {
            System.out.println("Invalid directory. You need to enter a valid path for your file.");
        }
    }

    public void listUsers() {
        int count = 1;
        for (User user : userController.listUsers()) {
            System.out.println(count + "- " + user.getName());
            count++;
        }
    }

    public void searchUser() {}

    public void registerQuestion() {}

    public void deleteQuestion() {}

}
