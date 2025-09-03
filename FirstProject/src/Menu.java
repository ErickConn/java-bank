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
		ClearConsole.clearConsole();
		
		System.out.println("Digite o nome do cliente: ");
        String name = scanner.nextLine();
        
        System.out.println("Digite sua senha: ");
        String password = scanner.nextLine();
        
        ClearConsole.clearConsole();
        
        Client account = bankService.createAccount(name, password);
        System.out.println("Conta criada: " + account.getId() + " | Nome: " + account.getName());
	}
	
	public void editClient() {
		ClearConsole.clearConsole();
		
		System.out.print("Digite o id do cliente: ");
		String id = scanner.nextLine();
		
		ClearConsole.clearConsole();
		
		Client account = bankService.getAccount(id);
		System.out.println("Cliente encontrado: " + account.getId() + " " + account.getName());
		
		System.out.println("0 - Voltar");
		System.out.println("1 - Editar nome do cliente");
		
		String option = scanner.nextLine();
		
		ClearConsole.clearConsole();
		
		switch (option) {
			case "0":
				return;
			case "1":
				System.out.println("Digite o novo nome do cliente: ");
				String nome = scanner.nextLine();
				account.setName(nome);
				System.out.println("Sucesso. Novo nome: " + nome);
				break;
			default:
				System.out.println("❌ Opção inválida. Tente novamente.");
		}
		
	}
	
	public void accessClient() {
		ClearConsole.clearConsole();
		
		System.out.print("Digite o nome do cliente: ");
		String nome = scanner.nextLine();
		
		ClearConsole.clearConsole();
		
		Client account = bankService.getAccount(nome);
		System.out.println("Id do cliente: " + account.getId());
		System.out.println("Nome: " + account.getName());
		System.out.println("Saldo: " + account.getBalance());
	}
	
	public Client login() {
		ClearConsole.clearConsole();
		
		System.out.println("Digite seu nome: ");
		String name = scanner.nextLine();
		System.out.println("Digite sua senha: ");
		String password = scanner.nextLine();
		
		ClearConsole.clearConsole();
		
		Client login = bankService.login(name, password);
		if (login != null) {
			System.out.println("Login realizado com sucesso!");
		}else {
			System.out.println("Verifique suas credenciais.");
		}
		
		return login;
		
	}
	
	public void createTransaction() {
		ClearConsole.clearConsole();
		
		System.out.println("Escolha o tipo de transação: ");
		System.out.println("0 - Voltar");
		System.out.println("1 - Depósito");
		System.out.println("2 - Saque");
		System.out.println("3 - Transferência");
			
		String option = scanner.nextLine();
		
		ClearConsole.clearConsole();
		
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
		ClearConsole.clearConsole();
		
		Client account = this.login();
		if (account == null)
			return;
		System.out.println("Digite o valor a ser depositado: ");
		int value = Integer.parseInt(scanner.nextLine());
		
		ClearConsole.clearConsole();
		
		Transaction deposit = bankService.deposit(account.getName(), value);
		if(deposit != null) {
			System.out.println("Déposito realizado com sucesso.");
			System.out.println(deposit.printTransaction());
		}
		
	}
	
	public void createWithraw() {
		ClearConsole.clearConsole();
		
		Client account = this.login();
		if (account == null)
			return;
		System.out.println("Digite o valor a ser sacado: ");
		int value = Integer.parseInt(scanner.nextLine());
		Transaction withdraw = bankService.withdraw(account.getName(), value);
		
		ClearConsole.clearConsole();
		
		if (withdraw.equals(null)) {
			System.out.println("Fundos insuficientes.");
		}else {
			System.out.println("Saque realizado com sucesso.");
			withdraw.printTransaction();
		}
	}
	
	public void createTransference() {
		ClearConsole.clearConsole();
		
		Client account = this.login();
		if (account == null)
			return;
		System.out.println("Digite o nome do cliente que quer transferir para: ");
		String name = scanner.nextLine();
		System.out.println("Digite o valor a ser transferido: ");
		int value = Integer.parseInt(scanner.nextLine());
		
		ClearConsole.clearConsole();
		
		Transaction transference = bankService.transfer(account.getName(), name, value);
		if (transference != null) {
			System.out.println("Transferência realizada com sucesso.");
			System.out.println(transference.printTransaction());
		}
	}
	
}
