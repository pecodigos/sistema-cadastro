package application;

import exceptions.InvalidInputException;
import exceptions.InvalidPathException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterApplication {
    public static void main(String[] args) throws InvalidPathException {

        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();

        System.out.println("============== Bem vindo! ==============");
        int n = -1;
        while (n != 0) {

            boolean invalidInput = false;

            System.out.println("\nO que gostarias de fazer?");
            System.out.println("1- Cadastrar um novo usuário.");
            System.out.println("2- Listar todos os usuários cadastrados.");
            System.out.println("3- Buscar usuário por nome.");
            System.out.println("4- Registrar uma nova pergunta.");
            System.out.println("5- Deletar uma pergunta.");
            System.out.println("0- Fechar o programa.");

            while (!invalidInput || n > 5 || n < 0) {
                try {
                    System.out.print("\nDigite o número da opção desejada (0 a 5): ");
                    n = sc.nextInt();

                    if (n > 5 || n < 0) {
                        System.out.println("Você não digitou um número válido.");
                    }
                    System.out.println();
                    invalidInput = true;
                } catch (InputMismatchException e) {
                    throw new InvalidInputException();
                }
            }

            if (n == 1) {
                menu.registerUser();
            } else if (n == 2){
                menu.listUsers();
            } else if (n == 3) {
                menu.searchUser();
            } else if (n == 4) {
                menu.registerQuestion();
            } else if (n == 5) {
                menu.deleteQuestion();
            }

            if (n != 0) {
                n = -1;
            }
        }
        System.out.println("Até mais!");
        sc.close();
    }
}