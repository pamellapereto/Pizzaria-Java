package br.com.romanapizza.pedidos;

//Exemplo de HERANÇA + POLIMORFISMO
public class Bebida extends Produto {
    private boolean alcool;
    private int quantidade;

    //Construtor
    public Bebida(String nome, Double preco, String tamanho, boolean alcool,
                  int quantidade) {
        super(nome, preco, tamanho);
        this.alcool = alcool;
        this.quantidade = quantidade;
    }
    public boolean isAlcool() {return alcool;}


    public void setAlcool(boolean alcool) {
        this.alcool = alcool;
    }


    public int getQuantidade() {return quantidade;}
    public void setQuantidade(int quantidade) {this.quantidade = quantidade;}
}
