package br.com.romanapizza.pedidos.main;

import br.com.romanapizza.pedidos.*;
import sun.security.jgss.GSSCaller;

import java.util.*;
import java.util.List;

public class Cadastro {

    static Scanner scr = new Scanner(System.in);
    private static ArrayList<Produto> menu = new ArrayList<>();
    private static ArrayList<Cliente> lista = new ArrayList<>();


    public static void main(String[] args) {
        int loopMenu = 0;

        while (loopMenu == 0) {
            System.out.print("Escolha uma das opções: \n" + "1- Clientes \n" + "2- Cadastrar produto \n 3- Exibir menu \nInsira sua opção: ");
            int opcao = Integer.parseInt(scr.nextLine());
            switch (opcao) {
                case 1:
                    paginaCliente();
                    break;
                case 2:
                    int loop = 0;
                    while (loop < 2) {
                        cadastrarProduto();

                        System.out.println("Deseja cadastrar um novo produto? \n" + "Digite sim ou não para voltar ao menu. ");
                        String escolha = scr.nextLine();

                        if (escolha.equalsIgnoreCase("sim")) {
                            loop = 1;
                        } else {
                            loop = 2;
                            loopMenu = 0;
                        }
                    }
                case 3:
                    System.out.println("------- MENU -------");
                    int i;

                    //Tarefa
                    for (i = 0; i < menu.size(); i++) {
                        // Loop utilizado utilizado para percorrer a array menu
                        if (menu.get(i) instanceof Bebida) {
                            Bebida bebida = (Bebida) menu.get(i);
                            System.out.println((i + 1) + "-" + bebida.visualizarMenu() + "\nQuantidade disponível: " +
                                    bebida.getQuantidade());
                        } else if (menu.get(i) instanceof Comida) {
                            Comida comida = (Comida) menu.get(i);
                            System.out.println((i + 1) + "-" + comida.visualizarMenu() + "\nIngredientes: " +
                                    comida.getIngredientes());
                        }
                    }
                    System.out.println("1- Atualizar produto \n 2- Remover produto");
                    int op = scr.nextInt();
                    switch (op) {
                        case 1:
                            atualizarProduto();
                            break;
                        case 2:
                            removerProduto();
                            break;
                        default:
                            System.out.println("Opção inválida");
                            break;
                    }
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }
    }

    private static void cadastrarCliente() {
        System.out.print("Digite seu nome: ");
        String nome = scr.nextLine();
        System.out.print("Digite seu telefone: ");
        String telefone = scr.nextLine();
        Cliente cliente = new Cliente(nome, telefone);
        lista.add(cliente);
        cliente.cadastroSucesso();

        System.out.print("Digite sua rua: ");
        String logradouro = scr.nextLine();
        System.out.print("Digite seu numero: ");
        int numero = scr.nextInt();
        System.out.print("Digite seu complemento: ");
        String complemento = scr.nextLine();
        System.out.print("Digite seu bairro: ");
        String bairro = scr.nextLine();
        System.out.print("Digite sua cidade: ");
        String cidade = scr.nextLine();
        System.out.print("Digite seu estado: ");
        String estado = scr.nextLine();
        System.out.print("Digite seu CEP: ");
        String cep = scr.nextLine();
        Endereco endereco = new Endereco(logradouro, numero, complemento, bairro, cidade, estado, cep);
        cliente.adicionarEndereco(endereco);
        int i;
        for (i = 1; i < cliente.getEnderecos().size(); i++) {
            System.out.println("Deseja adicionar um novo?");
            String resposta = scr.nextLine();
            if (resposta.equalsIgnoreCase("sim")) {
                cliente.adicionarEndereco(endereco);
            }
            else if (resposta.equalsIgnoreCase("não")) {
                i = 3;
            }
        }
    }

    private static void cadastrarProduto() {
        System.out.println("Selecione: \n 1-Salgados/Doces \n 2-Bebida");
        int op = Integer.parseInt(scr.nextLine());
        String nome, tamanho;
        Double preco;

        switch (op) {
            case 1:
                System.out.println("Digite o prato: ");
                nome = scr.nextLine();
                System.out.print("Digite o preço: ");
                preco = scr.nextDouble();
                System.out.println("Digite o tamanho: ");
                tamanho = scr.nextLine();
                System.out.println("Ingredientes: ");
                List<String> ingredientes = Arrays.asList(scr.nextLine());
                Comida comida = new Comida(nome, preco, tamanho, ingredientes);
                menu.add(comida);
                break;

            case 2:
                System.out.print("Digite o nome da bebida: ");
                nome = scr.nextLine();
                System.out.print("Digite o preço da bebida: ");
                preco = scr.nextDouble();
                System.out.print("Digite o tamanho da bebida (ml/L): ");
                tamanho = scr.nextLine();
                System.out.print("Digite a quantidade disponível: ");
                int quantidade = scr.nextInt();
                System.out.print("Escolha entre \n 1-Bebida alcoólica \n 2-Bebida não alcóolica ");
                int opBebida = scr.nextInt();
                boolean alcool = false;
                if (opBebida == 1) {
                    alcool = true;
                } else if (opBebida == 2) {
                    alcool = false;
                } else {
                    System.out.println("Opção inválida!");
                }
                Bebida produto = new Bebida(nome, preco, tamanho, alcool, quantidade);
                menu.add(produto);

                produto.cadastroSucesso();
                break;
        }
    }


    private static void atualizarProduto() {
        //Atualizar
        System.out.println("Escolha o produto que deseja atualizar: ");
        int i = scr.nextInt() - 1;

        if (menu.get(i) instanceof Bebida) {
            Bebida bebida = (Bebida) menu.get(i);
            System.out.println("Selecione o que deseja mudar: \n" + "1- Nome \n 2- Preço \n 3- Tamanho \n " +
                    "4- Quantidade \n 5- Alcoólica ou não");
            infosAtualizadas(i);


        } else if (menu.get(i) instanceof Comida) {
            Comida comida = (Comida) menu.get(i);
            System.out.println("Selecione o que deseja mudar: \n" + "1- Nome \n 2- Preço \n 3- Tamanho \n " +
                    "4- Ingredientes");
            infosAtualizadas(i);

        }
    }

    private static void infosAtualizadas(int i) {
        int updateProduto = scr.nextInt();

        switch (updateProduto) {
            case 1:
                System.out.println("Nome: ");
                menu.get(i).setNome(scr.nextLine());
                break;
            case 2:
                System.out.println("Preço: R$ ");
                menu.get(i).setPreco(scr.nextDouble());
                break;
            case 3:
                System.out.println("Tamanho: ");
                menu.get(i).setTamanho(scr.nextLine());
                break;

            case 4:
                if (menu.get(i) instanceof Bebida) {
                    Bebida bebida = (Bebida) menu.get(i);
                    System.out.println("Quantidade: ");
                    bebida.setQuantidade(scr.nextInt());

                } else if (menu.get(i) instanceof Comida) {
                    Comida comida = (Comida) menu.get(i);
                    System.out.println("Ingredientes: ");
                    comida.setIngredientes(Arrays.asList(scr.nextLine()));
                }

                break;

            case 5:
                if (menu.get(i) instanceof Bebida) {
                    Bebida bebida = (Bebida) menu.get(i);
                    System.out.println("1- Alcoólica\n 2- Não alcoólica");
                    int op = scr.nextInt();
                    boolean alcool = false;
                    if (op == 1) {
                        alcool = true;
                    } else if (op == 2) {
                        alcool = false;
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    bebida.setAlcool(alcool);
                } else {
                    System.out.println("Opção inválida");
                }

            default:
                System.out.println("Opção inválida");
                break;
        }
        System.out.println("Deseja alterar novamente o mesmo produto \n" + "Digite sim ou não... ");
        String escolha = scr.nextLine();
    }

    private static void removerProduto() {
        //Remover
        System.out.println("Escolha o produto que deseja remover: ");
        int i = scr.nextInt();
        menu.remove(i - 1);
        System.out.println("Item removido");
    }

    private static void paginaCliente() {
        System.out.println("Escolha entre as opções:\n 1- Cadastrar \n" + "2-Exibir");
        int opCliente = Integer.parseInt(scr.nextLine());
        switch (opCliente) {
            case 1:
                cadastrarCliente();
                break;
            case 2:
                exibirCliente();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static void exibirCliente() {
        int i;
        System.out.println("------- LISTA -------");
        for (i = 0; i < lista.size(); i++) {
            System.out.println((i + 1) + "-" + lista.get(i).visualizarLista());
        }
            System.out.println("Selecione o cliente: ");
            i = scr.nextInt() - 1;
            enderecosAssociados(i);
    }

    private static void enderecosAssociados(int i) {
        lista.get(i).visualizarLista();
        if (lista.get(i) != null) {
            Cliente cliente = (Cliente) lista.get(i);

            System.out.println((i + 1) + "-" + cliente.exibirEnderecos());
        } else {
            System.out.println("Cliente inexistente.");
        }
    }
}
