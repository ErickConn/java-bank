import java.util.Scanner;

public class Menu {
	Scanner scanner = new Scanner(System.in);
	BankService bankService = new BankService();
	
	public void mainMenu() {
		boolean running = true;
		
		while(running) {
			System.out.println("Bem-vindo ao sistema bancário simplificado feito em Java.");
			System.out.println("Digite o número para realizar a ação associada: ");
			System.out.println("0 - Sair.");
			System.out.println("1 - Criar um cliente.");
			System.out.println("2 - Editar um cliente.");
			System.out.println("3 - Acessar um cliente.");
			System.out.println("4 - Realizar uma transação.");
            System.out.println("5 - Visualizar todas as contas");
            System.out.println("6 - Visualizar todas as transações");
		
		String option = scanner.nextLine();
		
		switch (option) {
        case "0":
            System.out.println("Saindo...");
            System.exit(0);
            running = false;
            break;
        case "1":
            createClient();
            break;
        case "2":
            editClient();
            break;
        case "3":
            accessClient();
            break;
        case "4":
            createTransaction();
            break;
        case "5":
        	bankService.showAllAccounts();
        	break;
        default:
            System.out.println("❌ Opção inválida. Tente novamente.");
    }
}
}
	
	public void createClient() {
		System.out.print("Digite o nome do cliente: ");
        String name = scanner.nextLine();

        Client account = bankService.createAccount(name);
        System.out.println("Conta criada: " + account.getId() + " | Nome: " + account.getName());
	}
	
	public void editClient() {
		System.out.print("Digite o id do cliente: ");
		String id = scanner.nextLine();
		
		Client account = bankService.getAccount(id);
		// Edit menu
		System.out.println("");
		
		
	}
	
	public void accessClient() {
		System.out.print("Digite o id do cliente: ");
		String id = scanner.nextLine();
		
		Client account = bankService.getAccount(id);
		// Access menu
		System.out.println("Id do cliente: " + account.getId());
		System.out.println("Nome: " + account.getName());
		System.out.println("Saldo: " + account.getBalance());
	}
	
	public void createTransaction() {
		System.out.println("Escolha o tipo de transação: ");
		System.out.println("0 - Voltar");
		System.out.println("1 - Depósito");
		System.out.println("2 - Saque");
		System.out.println("3 - Transferência");
			
		String option = scanner.nextLine();
		
		switch(option) {
			case "0":
				return;
			case "1":
				this.createDeposit();
				break;
			case "2":
				this.createWithraw();
				break;
			case "3":
				this.createTransference();
				break;
			default:
				System.out.println("Opção inválida");
		}
	}
	
	public void createDeposit() {
		
	}
	
	public void createWithraw() {
		
	}
	
	public void createTransference() {
		
	}
	
}
