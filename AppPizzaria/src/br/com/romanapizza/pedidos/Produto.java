package br.com.romanapizza.pedidos;

public class Produto {
    //Variáveis declaradas (objetos)
    private String nome;
    private Double preco;
    private String tamanho;

    //Construtor
    public Produto(String nome, Double preco, String tamanho) {
        this.nome = nome;
        this.preco = preco;
        this.tamanho = tamanho;
    }

    //Getters
    private String getNome() {return nome;}
    private Double getPreco() {return preco;}
    private String getTamanho() {return tamanho;}

    //Setters
    public void setNome(String nome) {this.nome = nome;}
    public void setPreco(Double preco) {this.preco = preco;}
    public void setTamanho(String tamanho) {this.tamanho = tamanho;}

    public void cadastroSucesso() {
        System.out.print("Os dados do produto são:\n" + getNome() +
                "\n" + getPreco() + "\n" + getTamanho());
    }
    public String visualizarMenu() {
        return "Produto: " + getNome() + "\n Preço: R$ " + getPreco() + "\n Tamanho: " + getTamanho();
    }
}
