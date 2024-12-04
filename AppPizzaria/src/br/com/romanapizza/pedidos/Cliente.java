package br.com.romanapizza.pedidos;

import java.util.ArrayList;

public class Cliente {
    //Variáveis declaradas
    private String nome, telefone;
    private ArrayList<Endereco> enderecos;

    //Construtor (metodo utilizado para inicializar o objeto)
    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.enderecos = new ArrayList<>();
    }

    //Getters (exemplo de encapsulamento)
    private String getNome() {
        return nome;
    }

    private String getTelefone() {
        return telefone;
    }

    public void cadastroSucesso() {
        System.out.print("Os dados do cliente são:\n" + getNome() +
                "\n" + getTelefone());
    }

    public String visualizarLista() {
        return "Nome: " + getNome() + "\n Telefone: " + getTelefone();
    }

    public ArrayList<Endereco> getEnderecos() {
        return enderecos;
    }

    public void adicionarEndereco(Endereco endereco) {
        enderecos.add(endereco);
        System.out.println("Endereço adicionado com sucesso!");
        System.out.println("Não é possível adicionar mais de 3 endereços.");
    }

    public String exibirEnderecos() {
        if (enderecos.isEmpty()) {
            System.out.println("Nenhum endereço cadastrado.");
        } else {
            System.out.println("Endereços cadastrados:");
            for (int i = 0; i < enderecos.size(); i++) {
                return enderecos.get(i).cadastroSucesso();
            }
        }
        return null;
    }
}

