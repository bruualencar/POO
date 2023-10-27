package quest02_Bruna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class login {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Escolha uma das opções:");
            System.out.println("1 - Cadastro");
            System.out.println("2 - Fazer login");
            System.out.println("3 - Sair");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    fazerLogin();
                    break;
                case 3:
                    System.out.println("Finalizando...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("ERRO! Tente novamente.");
            }
        }
    }

    private static void cadastrarUsuario() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite um nome para seu usuário: ");
            String novoLogin = scanner.nextLine();
            System.out.println("Crie uma senha: ");
            String novaSenha = scanner.nextLine();

            BufferedWriter writer = new BufferedWriter(new FileWriter("usuarios.txt", true));
            writer.write(novoLogin + " " + novaSenha);
            writer.newLine();
            writer.close();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro no cadastro do usuário: " + e.getMessage());
        }
    }

    private static void fazerLogin() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o seu usuário: ");
            String login = scanner.nextLine();
            System.out.println("Digite a sua senha: ");
            String senha = scanner.nextLine();

            BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"));
            String linha;
            boolean loginEncontrado = false;

            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(" ");
                if (partes.length == 2) {
                    String usuario = partes[0];
                    String senhaArmazenada = partes[1];
                    if (usuario.equals(login) && senhaArmazenada.equals(senha)) {
                        loginEncontrado = true;
                        break;
                    }
                }
            }

            if (loginEncontrado) {
                System.out.println("Login bem-sucedido!");
            } else {
                System.out.println("Login ou senha incorretos. Escreva novamente!");
            }

            reader.close();
        } catch (IOException e) {
            System.err.println("Erro ao fazer o login: " + e.getMessage());
        }
    }

}
