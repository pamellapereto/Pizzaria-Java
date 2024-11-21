package br.com.romanapizza.pedidos;

public class Cliente {
    //Variáveis declaradas
    private String nome, telefone;

    //Construtor (metodo utilizado para inicializar o objeto)
    public Cliente(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    //Getters (exemplo de encapsulamento)
    private String getNome() {return nome;}
    private String getTelefone() {return telefone;}

    public void cadastroSucesso() {
        System.out.print("Os dados do cliente são:\n" + getNome() +
                "\n" + getTelefone());
    }

    public String visualizarLista() {
        return "Nome: " + getNome() + "\n Telefone: " + getTelefone();
    }
}

