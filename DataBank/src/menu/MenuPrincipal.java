package menu;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import connection.ClienteDAO;
import connection.ClienteVipDAO;
import projectdb.Cliente;
import projectdb.ClienteVip;

public class MenuPrincipal {
    private ClienteDAO clienteDAO;
    private ClienteVipDAO clienteVipDAO;

    public MenuPrincipal() {
        clienteDAO = new ClienteDAO();
        clienteVipDAO = new ClienteVipDAO();
    }

    public void exibirMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 5) {
            System.out.println("----- MENU PRINCIPAL -----");
            System.out.println("1. Cadastrar cliente");
            System.out.println("2. Buscar cliente");
            System.out.println("3. Atualizar cliente");
            System.out.println("4. Cadastrar cliente VIP");
            System.out.println("5. Sair");
            System.out.print("Selecione uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    buscarCliente();
                    break;
                case 3:
                    atualizarCliente();
                    break;
                case 4:
                    cadastrarClienteVip();
                    break;
                case 5:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, selecione uma opção válida.");
                    break;
            }

            System.out.println();
        }

        scanner.close();
    }

    private void cadastrarCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("----- CADASTRAR CLIENTE -----");

			Cliente cliente = new Cliente();

			System.out.print("Informe o ID do cliente: ");
			cliente.setId_cliente(scanner.nextInt());
			scanner.nextLine();

			System.out.print("Informe o nome do cliente: ");
			cliente.setNome(scanner.nextLine());

			System.out.print("Informe a data de nascimento do cliente (DD/MM/AAAA): ");
			String dataNascimentoStr = scanner.nextLine();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			Date dataNascimento;
			try {
			    dataNascimento = dateFormat.parse(dataNascimentoStr);
			} catch (ParseException e) {
			    System.out.println("Formato de data inválido. Use o formato DD/MM/AAAA.");
			    return;
			}
			cliente.setData_nasc(dataNascimento);

			System.out.print("Informe o telefone do cliente: ");
			cliente.setTelefone(scanner.nextLine());


			System.out.print("Informe o tipo do cliente: ");
			cliente.setTipo_cliente(scanner.nextLine());

			System.out.print("Informe o valor do cliente: ");
			cliente.setValor(scanner.nextDouble());



			clienteDAO.salvarCliente(cliente);
		}
        System.out.println("Cliente cadastrado com sucesso!");
    }

    private void buscarCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("----- BUSCAR CLIENTE -----");

			System.out.print("Informe o ID do cliente: ");
			int idCliente = scanner.nextInt();

			Cliente cliente = clienteDAO.buscarCliente(idCliente);

			if (cliente != null) {
			    System.out.println("Cliente encontrado:");
			    System.out.println("ID: " + cliente.getId_cliente());
			    System.out.println("Nome: " + cliente.getNome());
			    System.out.println("Data de Nascimento: " + cliente.getData_nasc());
			    System.out.println("Telefone: " + cliente.getTelefone());

			    System.out.println("Tipo de Cliente: " + cliente.getTipo_cliente());
			    System.out.println("Valor: " + cliente.getValor());

			} else {
			    System.out.println("Cliente não encontrado.");
			}
		}
    }

    private void atualizarCliente() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("----- ATUALIZAR CLIENTE -----");

			System.out.print("Informe o ID do cliente: ");
			int idCliente = scanner.nextInt();

			Cliente cliente = clienteDAO.buscarCliente(idCliente);

			if (cliente != null) {
			    scanner.nextLine();
			    System.out.print("Informe o novo nome do cliente: ");
			    cliente.setNome(scanner.nextLine());

			    System.out.print("Informe a nova data de nascimento do cliente (DD/MM/AAAA): ");
			    String dataNascimentoStr = scanner.nextLine();
			    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			    Date dataNascimento;
			    try {
			        dataNascimento = dateFormat.parse(dataNascimentoStr);
			    } catch (ParseException e) {
			        System.out.println("Formato de data inválido. Use o formato DD/MM/AAAA.");
			        return;
			    }
			    cliente.setData_nasc(dataNascimento);

			    System.out.print("Informe o novo telefone do cliente: ");
			    cliente.setTelefone(scanner.nextLine());



			    System.out.print("Informe o novo tipo do cliente: ");
			    cliente.setTipo_cliente(scanner.nextLine());

			    System.out.print("Informe o novo valor do cliente: ");
			    cliente.setValor(scanner.nextDouble());



			    clienteDAO.atualizarCliente(cliente);

			    System.out.println("Cliente atualizado com sucesso!");
			} else {
			    System.out.println("Cliente não encontrado.");
			}
		}
    }

    private void cadastrarClienteVip() {
        try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("----- CADASTRAR CLIENTE VIP -----");

			ClienteVip clienteVip = new ClienteVip();

			System.out.print("Informe o ID do cliente: ");
			clienteVip.setId_cliente(scanner.nextInt());
			scanner.nextLine();

			System.out.print("Informe o CPF do cliente: ");
			clienteVip.setCpf(scanner.nextInt());
			scanner.nextLine();

			System.out.print("Informe o endereço do cliente: ");
			clienteVip.setEndereco(scanner.nextLine());

			System.out.print("Informe o tempo de contribuição do cliente: ");
			clienteVip.setTempo_contribuicao(scanner.nextLine());

			clienteVipDAO.salvarClienteVip(clienteVip);
		}
        System.out.println("Cliente VIP cadastrado com sucesso!");
    }

    public static void main(String[] args) {
        MenuPrincipal menu = new MenuPrincipal();
        menu.exibirMenu();
    }
}

