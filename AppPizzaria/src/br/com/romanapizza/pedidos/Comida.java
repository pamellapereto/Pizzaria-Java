package br.com.romanapizza.pedidos;


import java.util.List;

public class Comida extends Produto {
    //Variável
    private List<String> ingredientes;

    public Comida(String nome, Double preco, String tamanho, List<String> ingredientes) {
        super(nome, preco, tamanho);
        this.ingredientes = ingredientes;
    }

     public List<String> getIngredientes() {
        return ingredientes;
     }

    public void setIngredientes(List<String> ingredientes) {
        this.ingredientes = ingredientes;
    }
}
