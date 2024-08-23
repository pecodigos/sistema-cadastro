package application;

import exceptions.InvalidInputException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RegisterApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MainMenu menu = new MainMenu();

        int n = 6;
        boolean valid = false;

        while (n != 0) {
            System.out.println("\nBem vindo. O que gostarias de fazer?");
            System.out.println("1- Cadastrar o usuário.");
            System.out.println("2- Listar todos os usuários cadastrados.");
            System.out.println("3- Buscar usuário por nome");
            System.out.println("0- Fechar o programa.");

            while (!valid || n > 5 || n < 0) {
                try {
                    System.out.print("\nDigite o número da opção desejada (0 a 5): ");
                    n = sc.nextInt();

                    if (n > 5 || n < 0) {
                        System.out.println("Você não digitou um número válido.");
                    }

                    valid = true;
                } catch (InputMismatchException e) {
                    System.out.println("Você digitou uma informação errada. Por favor, tente novamente.");
                    sc.nextLine();
                }
            }

            if (n == 1) {
                menu.registerUser();
            } else if (n == 2){
                menu.listUsers();
            } else if (n == 3) {
                menu.searchUser();
            }
        }
        System.out.println("\nAté mais!");
        sc.close();
    }
}