import java.util.Scanner;
import java.io.IOException;

public class ContaBancaria {

    private static double saldo;
    private static int numBoasVindas = 0;

    public static void clear() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }

    public static double exibirSaldo() {
        System.out.println("Seu saldo e R$" + saldo);
        return saldo;
    }

    public static void menu() throws IOException, InterruptedException{ 
        Scanner teclado = new Scanner(System.in);
        int opcao;

        System.out.println("---------------------------------");
        if(numBoasVindas < 2) {
            System.out.println("Seja bem vindo ao Banco Oscar-alho");
            numBoasVindas++;
        }
        System.out.println("---------------------------------");
        System.out.println("[1] - Depositar");
        System.out.println("[2] - Sacar");
        System.out.println("[3] - Exibir saldo");
        System.out.println("[4] - Sair do sistema");

        opcao = teclado.nextInt();

        switch (opcao) {
            case 1:
                depositar();
                break;

            case 2:
                sacar();
                break;

            case 3:
                exibirSaldo();

            case 4:
                System.out.println("Obrigado por usar o Banco Oscar-Alho. Volte sempre!");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida. Tente novamente.");
                break;
        }
        menu();
    }

    public static void depositar() throws IOException, InterruptedException{
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o valor do deposito: R$");
        double valor = teclado.nextDouble();

        if (valor <= 0) {
            System.out.println("Valor invalido. Tente novamente.");
        } else {
            saldo += valor;
            System.out.println("deposito de R$" + valor + " realizado com sucesso.");
            clear();
        }
    }

    public static void sacar() throws IOException, InterruptedException{
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o valor do saque: R$");
        double valor = teclado.nextDouble();

        if (valor <= 0 || valor > saldo) {
            System.out.println("Valor invalido. Tente novamente.");
        } else {
            saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
            clear();    
        }
    }

    public static void main(String args[]) throws IOException, InterruptedException{ 
        saldo = 0;
        menu();
        clear();
    }
}
