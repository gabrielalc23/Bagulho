private static double saldo;

public static double exibirSaldo() {
    System.out.println("Seu saldo é R$" + saldo);
    return saldo;
}

public static void menu() throws IOException, InterruptedException{ 
    Scanner teclado = new Scanner(System.in);
	Console armazenar = new Console();
    int opcao;

    System.out.println("---------------------------------");
    System.out.println("Bem-vindo ao Banco Jalimrrabei");
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
            break;

        case 4:
            System.out.println("Obrigado por usar o Banco Jalimrrabei. Volte sempre!");
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
	Console armazenar = new Console();

    System.out.print("Digite o valor do depósito: R$");
    double valor = teclado.nextDouble();

    if (valor <= 0) {
        System.out.println("Valor inválido. Tente novamente.");
    } else {
        saldo += valor;
        System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
			armazenar.clear();
	
	}
}

public static void sacar() throws IOException, InterruptedException{
    Scanner teclado = new Scanner(System.in);
	Console armazenar = new Console();
	
    System.out.print("Digite o valor do saque: R$");
    double valor = teclado.nextDouble();

    if (valor <= 0 || valor > saldo) {
        System.out.println("Valor inválido. Tente novamente.");
    } else {
        saldo -= valor;
        System.out.println("Saque de R$" + valor + " realizado com sucesso.");
		armazenar.clear();	
	}
}

public static void main(String args[]) throws IOException, InterruptedException{ 
	Console armazenar = new Console();
    saldo = 0;
    menu();
	armazenar.clear();
}
