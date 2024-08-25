package application;

import controllers.QuestionController;
import controllers.UserController;
import entities.User;
import exceptions.InvalidInputException;
import exceptions.InvalidPathException;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {

    UserController userController = new UserController();
    QuestionController questionController = new QuestionController();

    List<String> questions = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    private int count = 1;

    public void registerUser() throws InvalidPathException {

        System.out.print("Digite o caminho para o arquivo de texto: ");
        String filePath = sc.nextLine();

        File file = new File(filePath);
        String fileParent = file.getParent();

        boolean success = new File(fileParent + "/out").mkdir();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                questions.add(line);
            }

            System.out.println("\nDigite os dados do novo usuário.");

            String name;
            String email;

            do {
                System.out.print(questions.getFirst() + " ");
                name = sc.nextLine();
                if (name.trim().length() < 10) {
                    System.out.println("Seu nome precisa ter no mínimo 10 caracteres, não incluindo espaços.\n");
                }
            } while (name.trim().length() < 10);

            do {
                System.out.print(questions.get(1) + " ");
                email = sc.nextLine();
                if (userController.listUsers().toString().contains(email) || !(email.contains("@"))) {
                    System.out.println("\nEmail inválido ou já existente. Insira um email válido, por favor.\n");
                }
            } while (userController.listUsers().toString().contains(email) || !(email.contains("@")));


            System.out.print(questions.get(2) + " ");
            int age = sc.nextInt();

            System.out.print(questions.get(3) + " ");
            double height = sc.nextDouble();

            sc.nextLine();

            userController.registerUser(name, email, age, height);

            String outFile = fileParent + String.format("/out/%d-", count) + name.toUpperCase().replaceAll("\\s+", "") + ".txt";
            count++;
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
                bw.write("Nome: " + name + "\n");
                bw.write("Email: " + email + "\n");
                bw.write("Idade: " + age + "\n");
                bw.write("Altura: " + height + "\n");
            }
        } catch (IOException e) {
            throw new InvalidPathException();
        }
        System.out.println("\nUsuário cadastrado com sucesso!");
    }

    public void listUsers() {
        int count = 1;
        System.out.println("Usuários cadastrados:");
        for (User user : userController.listUsers()) {
            System.out.println(count + "- " + user.getName());
            count++;
        }
    }

    public void searchUser() {
        System.out.print("Digite o nome do usuário que desejas buscar: ");
        String name = sc.nextLine();

        userController.searchUser(name);
    }

    public void registerQuestion() throws InvalidPathException {

        try {
            System.out.print("Digite o caminho para o arquivo de texto: ");
            String filePath = sc.nextLine();

            System.out.print("\nDigite a pergunta que desejas adicionar: ");
            String newQuestion = sc.nextLine();

            questionController.registerQuestion(newQuestion,  filePath);
        } catch (IOException e) {
            throw new InvalidPathException();
        } catch (InputMismatchException e) {
            throw new InvalidInputException();
        }
    }

    public void deleteQuestion() throws InvalidPathException {
        try {
            System.out.print("Digite o caminho para o arquivo de texto: ");
            String pathFile = sc.nextLine();

            boolean validQuestion = false;
            int number = 0;

            while (!validQuestion) {
                System.out.print("\nDigite o número da pergunta que desejas deletar: ");
                number = sc.nextInt();

                if (number > 4) {
                    validQuestion = true;
                } else {
                    System.out.println("Você precisa digitar um número válido acima de 5.");
                }
            }
            questionController.deleteQuestion(number, pathFile);

        } catch (IOException e) {
            throw new InvalidPathException();
        } catch (InputMismatchException ex) {
            throw new InvalidInputException();
        }
    }

}
