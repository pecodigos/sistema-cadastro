package application;

import java.util.Scanner;

public class RegisterApplication {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = 6;
        while (n != 0) {
            System.out.println("\nBem vindo. O que gostarias de fazer?");
            System.out.println("1- Cadastrar o usuário.");
            System.out.println("2- Listar todos os usuários cadastrados.");
            System.out.println("0- Fechar o programa.");
            System.out.print("\nDigite o número da opção desejada (0 a 5): ");
            n = sc.nextInt();

            if (n == 1) {
                MainMenu.registerUser();
            } else if (n == 2){
                MainMenu.listUsers();
            }
        }
        System.out.println("\nAté mais!");
        sc.close();
    }
}